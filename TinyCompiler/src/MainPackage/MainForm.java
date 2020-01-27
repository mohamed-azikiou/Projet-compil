package MainPackage;

import Antlr.Small_JavaLexer;
import Antlr.Small_JavaParser;
import AntlrHandler.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class MainForm {
    private JPanel MainPanel;
    private JTextArea InputCode;
    private JTextArea ErrorOutput;
    private JButton ParseButton;
    private JTable SymbolsTable;
    private JTable QuadTable;
    private JTextArea ObjectCode;
    private DefaultTableModel tableModel;
    private DefaultTableModel quadModel;

    public MainForm() {
        ParseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            ErrorOutput.setText("Building solution\n");
            tableModel.setRowCount(0);
            quadModel.setRowCount(0);
            Small_JavaLexer lexer = new Small_JavaLexer(CharStreams.fromString(InputCode.getText()));
            Small_JavaParser parser = new Small_JavaParser(new CommonTokenStream(lexer));
            Visitor<String> visitor = new Visitor<>();
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());
            ErrorListener.Errors=new ArrayList<>();
            TS.Instance = new TS();
            TS.TST = new TS();
            Quad.Instance = new Quad();
            ObjectCode.setText("");
            Small_JavaParser.FileContext tree = parser.file();

            if(ErrorListener.Errors.size()==0) {
                visitor.visit(tree);
            }
            if(ErrorListener.Errors.size()==0) {
                int label = -1;
                HashMap<Integer, Integer> bz= new HashMap<>();
                for(TSElement element : TS.Instance) {
                    tableModel.addRow(new String[] {element.Nom, element.type.toString(), element.Valeur});
                }
                for (int i = 0; i<Quad.Instance.size(); i++)
                    quadModel.addRow(new String[] {i + "", Quad.Instance.get(i).op, Quad.Instance.get(i).op1, Quad.Instance.get(i).op2, Quad.Instance.get(i).res});
                ObjectCode.append("data SEGMENT\n");
                for(TSElement element : TS.Instance) {
                    switch (element.type) {
                        case int_SJ:
                            ObjectCode.append(element.Nom + " DW ?\n");
                            break;
                        case float_SJ:
                            ObjectCode.append(element.Nom + " DW ?\n");
                            break;
                        case string_SJ:
                            ObjectCode.append(element.Nom + " DB 128 dup('$')\n");
                            break;
                    }
                }
                ObjectCode.append("ENDS\n\ncode SEGMENT\nstart:\nMOV AX, data\nMOV DS, AX\n\n");
                int loopIndex=0;
                for (int i = 0; i<Quad.Instance.size(); i++) {
                    if(bz.containsKey(i)) {
                        ObjectCode.append("L"+bz.get(i)+": ");
                        bz.remove(i);
                    }
                    switch (Quad.Instance.get(i).op) {
                        case ":=" :
                            if(Quad.Instance.get(i).op1.charAt(0) == '"') {
                                int ii = 1;
                                for(; ii < Quad.Instance.get(i).op1.length()-1;ii++) {
                                    ObjectCode.append("MOV "+Quad.Instance.get(i).res+"["+(ii-1)+"], '"+ Quad.Instance.get(i).op1.charAt(ii) +"'\n");
                                }
                                ObjectCode.append("MOV "+Quad.Instance.get(i).res+"["+(ii-1)+"], '$'\n");
                            } else
                            if(TS.get(Quad.Instance.get(i).res) != null && TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.string_SJ) {
                                ObjectCode.append("MOV CX, 63\n");
                                ObjectCode.append("LOOPL"+ loopIndex +": MOV BX, CX\n");
                                ObjectCode.append("MOV AL, "+Quad.Instance.get(i).op1+"[BX]\n");
                                ObjectCode.append("MOV "+Quad.Instance.get(i).res+"[BX], AL\n");
                                ObjectCode.append("LOOP LOOPL"+ loopIndex++ +"\n");
                                ObjectCode.append("MOV AL, "+Quad.Instance.get(i).op1+"[0]\n");
                                ObjectCode.append("MOV "+Quad.Instance.get(i).res+"[0], AL\n");
                            } else
                            if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                ObjectCode.append("POP AX\n");
                                ObjectCode.append("MOV "+Quad.Instance.get(i).res+", AX\n");
                            }
                            else ObjectCode.append("MOV "+Quad.Instance.get(i).res+", "+Quad.Instance.get(i).op1+"\n");
                            break;

                        case "ADD" :
                        case "SUB" :
                            if ('0'<=Quad.Instance.get(i).op2.charAt(0)&&Quad.Instance.get(i).op2.charAt(0)<='9'&&Quad.Instance.get(i).op2.endsWith("T")) {
                                ObjectCode.append("POP AX\n");
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP BX\n");
                                    ObjectCode.append(Quad.Instance.get(i).op+" BX, AX\n");
                                } else {
                                    ObjectCode.append(Quad.Instance.get(i).op+" "+Quad.Instance.get(i).op1+", AX\n");
                                }
                            } else {
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP AX\n");
                                    ObjectCode.append(Quad.Instance.get(i).op+" AX, "+Quad.Instance.get(i).op2+"\n");
                                } else {
                                    ObjectCode.append("MOV AX, "+Quad.Instance.get(i).op1+"\n");
                                    ObjectCode.append(Quad.Instance.get(i).op+" AX, "+Quad.Instance.get(i).op2+"\n");
                                }
                            }
                            ObjectCode.append("PUSH AX\n");
                            break;

                        case "MUL" :
                            if ('0'<=Quad.Instance.get(i).op2.charAt(0)&&Quad.Instance.get(i).op2.charAt(0)<='9'&&Quad.Instance.get(i).op2.endsWith("T")) {
                                ObjectCode.append("POP AX\n");
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP BX\n");
                                    ObjectCode.append("MUL BX\n");
                                } else {
                                    try{
                                        Float.parseFloat(Quad.Instance.get(i).op1);
                                        ObjectCode.append("MOV DX, "+Quad.Instance.get(i).op1+"\n");
                                        ObjectCode.append("MUL DX\n");
                                    } catch (Exception ed) {
                                        ObjectCode.append("MUL "+Quad.Instance.get(i).op1+"\n");
                                    }
                                }
                            } else {
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP AX\n");
                                    try{
                                        Float.parseFloat(Quad.Instance.get(i).op2);
                                        ObjectCode.append("MOV DX, "+Quad.Instance.get(i).op2+"\n");
                                        ObjectCode.append("MUL DX\n");
                                    } catch (Exception ed) {
                                        ObjectCode.append("MUL "+Quad.Instance.get(i).op2+"\n");
                                    }
                                } else {
                                    ObjectCode.append("MOV AX, "+Quad.Instance.get(i).op1+"\n");
                                    try{
                                        Float.parseFloat(Quad.Instance.get(i).op2);
                                        ObjectCode.append("MOV DX, "+Quad.Instance.get(i).op2+"\n");
                                        ObjectCode.append("MUL DX\n");
                                    } catch (Exception ed) {
                                        ObjectCode.append("MUL "+Quad.Instance.get(i).op2+"\n");
                                    }
                                }
                            }
                            ObjectCode.append("PUSH AX\n");
                            break;

                        case "DIV" :
                            ObjectCode.append("XOR DX, DX\n");
                            if ('0'<=Quad.Instance.get(i).op2.charAt(0)&&Quad.Instance.get(i).op2.charAt(0)<='9'&&Quad.Instance.get(i).op2.endsWith("T")) {
                                ObjectCode.append("POP BX\n");
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP AX\n");
                                    ObjectCode.append("DIV BX\n");
                                } else {
                                    ObjectCode.append("MOV AX, "+Quad.Instance.get(i).op1+"\n");
                                    ObjectCode.append("DIV BX\n");
                                }
                            } else {
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP AX\n");
                                    try{
                                        Float.parseFloat(Quad.Instance.get(i).op2);
                                        ObjectCode.append("MOV DX, "+Quad.Instance.get(i).op2+"\n");
                                        ObjectCode.append("DIV DX\n");
                                    } catch (Exception ed) {
                                        ObjectCode.append("DIV "+Quad.Instance.get(i).op2+"\n");
                                    }
                                } else {
                                    ObjectCode.append("MOV AX, "+Quad.Instance.get(i).op1+"\n");
                                    try{
                                        Float.parseFloat(Quad.Instance.get(i).op2);
                                        ObjectCode.append("MOV DX, "+Quad.Instance.get(i).op2+"\n");
                                        ObjectCode.append("DIV DX\n");
                                    } catch (Exception ed) {
                                        ObjectCode.append("DIV "+Quad.Instance.get(i).op2+"\n");
                                    }
                                }
                            }
                            ObjectCode.append("PUSH AX\n");
                            break;

                        case ">":
                        case "<":
                        case ">=":
                        case "<=":
                        case "=":
                        case "!=":
                            if ('0'<=Quad.Instance.get(i).op2.charAt(0)&&Quad.Instance.get(i).op2.charAt(0)<='9'&&Quad.Instance.get(i).op2.endsWith("T")) {
                                ObjectCode.append("POP AX\n");
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP BX\n");
                                    ObjectCode.append("CMP BX, AX\n");
                                } else {
                                    ObjectCode.append("CMP "+Quad.Instance.get(i).op1+", AX\n");
                                }
                            } else {
                                if ('0'<=Quad.Instance.get(i).op1.charAt(0)&&Quad.Instance.get(i).op1.charAt(0)<='9'&&Quad.Instance.get(i).op1.endsWith("T")) {
                                    ObjectCode.append("POP AX\n");
                                    ObjectCode.append("CMP AX, "+Quad.Instance.get(i).op2+"\n");
                                } else {
                                    ObjectCode.append("MOV AX, "+Quad.Instance.get(i).op1+"\n");
                                    ObjectCode.append("CMP AX, "+Quad.Instance.get(i).op2+"\n");
                                }
                            }
                            String op=null;
                            switch (Quad.Instance.get(i).op) {
                                case ">": op = "JG"; break;
                                case ">=": op = "JGE"; break;
                                case "<": op = "JNGE"; break;
                                case "<=": op = "JNG"; break;
                                case "=": op = "JE"; break;
                                case "!=": op = "JNE"; break;
                            }
                            ObjectCode.append(op+" L"+ ++label +"\n");
                            ObjectCode.append("PUSH 0\n");
                            ObjectCode.append("JMP L"+(label+1)+"\n");
                            ObjectCode.append("L"+ label +": PUSH 1\n");
                            ObjectCode.append("L"+ ++label +": ");
                            break;

                        case "|":
                        case "&":
                            ObjectCode.append("POP BX\n");
                            ObjectCode.append("POP AX\n");
                            ObjectCode.append((Quad.Instance.get(i).op.charAt(0)=='|'?"OR":"AND")+" AX, BX\n");
                            ObjectCode.append("PUSH AX\n");
                            break;

                        case "!":
                            ObjectCode.append("POP AX\n");
                            ObjectCode.append("NOT AX\n");
                            ObjectCode.append("AND AX,1\n");
                            ObjectCode.append("PUSH AX\n");
                            break;

                        case "BZ":
                            bz.put(Integer.parseInt(Quad.Instance.get(i).res), ++label);
                            ObjectCode.append("POP AX\n");
                            ObjectCode.append("CMP AX, 0\n");
                            ObjectCode.append("JE L"+label+"\n");
                            break;

                        case "Lire":
                            ObjectCode.append("MOV BX, OFFSET " + Quad.Instance.get(i).res + "\n");
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.string_SJ) {
                                ObjectCode.append("CALL READ_STR\n");
                            }
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.int_SJ) {
                                ObjectCode.append("CALL READ_INT\n");
                            }
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.float_SJ) {
                                ObjectCode.append("CALL READ_FLOAT\n");
                            }

                        case "ECRIRE":
                            ObjectCode.append("MOV BX, OFFSET " + Quad.Instance.get(i).res + "\n");
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.string_SJ) {
                                ObjectCode.append("CALL READ_STR\n");
                            }
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.int_SJ) {
                                ObjectCode.append("CALL READ_INT\n");
                            }
                            if(TS.get(Quad.Instance.get(i).res).type == TSElement.TYPE.float_SJ) {
                                ObjectCode.append("CALL READ_FLOAT\n");
                            }

                    }
                }
                if(bz.containsKey(Quad.Instance.size())) {
                    ObjectCode.append("L"+bz.get(Quad.Instance.size())+": ");
                    bz.remove(Quad.Instance.size());
                }
                ObjectCode.setText(ObjectCode.getText().replace("PUSH AX\nPOP AX\n",""));
                ErrorOutput.setText(ErrorOutput.getText()+"Build succeeded\n");
                ObjectCode.append("\nMOV AX, 4C00h\nINT 21h\n\n");
                ObjectCode.append("READ_STR:\nMOV AH, 1\nSTART_READ_STR:\nINT 21h\nMOV DS[BX], AL\nINC BX\nCMP AL, 0Dh\nJNE START_READ_STR\nMOV DS[BX-1], '$'\nRET\n\n");
                ObjectCode.append("READ_INT:\nMOV CH, 0\nMOV SI, 10\nSTART_READ_INT:\nMOV AH, 1\nINT 21h\nCMP AL, 0Dh\nJE END_READ_INT\nMOV CL, AL\nSUB CL, '0'\nMOV AX, DS[BX]\nMUL SI\nADD AX, CX\nMOV DS[BX], AX\nJMP START_READ_INT \nEND_READ_INT:\nRET\n\n");
                ObjectCode.append("READ_FLOAT:\nXOR CH, CH\nMOV DI, -1\nMOV SI, 10\nSTART_READ_FLOAT:\nMOV AH, 1\nINT 21h\nCMP AL, 0Dh\nJE END_READ_FLOAT\nCMP AL, '.'\nJNE NEX_READ_FLOAT\nMOV DI,0\nJMP START_READ_FLOAT\nNEX_READ_FLOAT:\nCMP DI, 0\nJNGE NEXT_READ_FLOAT\nINC DI\nNEXT_READ_FLOAT:\nMOV CL, AL\nSUB CL, '0'\nMOV AX, DS[BX]\nMUL SI\nADD AX, CX\nMOV DS[BX], AX\nJMP START_READ_FLOAT \nEND_READ_FLOAT:\nMOV CX, DI\nMOV AX, DS[BX]\nCMP CX, 0\nJNG END_END_READ_FLOAT\nLOOP_READ_FLOAT:\nDIV SI\nLOOP LOOP_READ_FLOAT\nMOV DS[BX], AX\nEND_END_READ_FLOAT:\nRET\n\n");
                ObjectCode.append("\nENDS\nEND start\n");
            }
            else {
                ErrorOutput.setText(ErrorOutput.getText()+"Build ended with errors:\n");
                for(Exception exp : ErrorListener.Errors)
                    ErrorOutput.setText(ErrorOutput.getText()+'\n'+exp.getMessage());
            }
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[2].getClassName());
        JFrame mainFrame = new JFrame("Small_Java IDE");
        MainForm Main = new MainForm();
        mainFrame.setContentPane(Main.MainPanel);
        mainFrame.setSize(1300,600);
        mainFrame.setVisible(true);
    }

    private void createUIComponents() {
        //SymbolsTable
        String[] TSColumnIdentifiers = {"Nom", "Type", "Valeur"};
        String[] QuadColumnIdentifiers = {"", "Operator", "Operand 1", "Operand 2", "Result"};
        tableModel = new DefaultTableModel();
        tableModel.setDataVector(null, TSColumnIdentifiers);
        quadModel = new DefaultTableModel();
        quadModel.setDataVector(null, QuadColumnIdentifiers);
        SymbolsTable = new JTable(tableModel);
        QuadTable = new JTable(quadModel);
    }
}
