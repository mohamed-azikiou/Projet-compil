package AntlrHandler;

import Antlr.Small_JavaBaseVisitor;
import Antlr.Small_JavaParser;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitor<Object> extends Small_JavaBaseVisitor<Object> {
    private boolean isLang = false;
    private boolean isIo = false;

    @Override
    public Object visitDec(Small_JavaParser.DecContext ctx) {
        TSElement element = new TSElement();
        if(TS.Instance.contains(ctx.ID().toString())) {
            ErrorListener.Errors.add(new ParseCancellationException("Semantic error: variable \"" + ctx.ID().toString() + "\" already defined."));
            return super.visitDec(ctx);
        }

        element.Nom = ctx.ID().toString();
        element.type = ctx.TYPE().toString().equals(TSElement.TYPE.int_SJ.name())? TSElement.TYPE.int_SJ : ctx.TYPE().toString().equals(TSElement.TYPE.float_SJ.name())? TSElement.TYPE.float_SJ : ctx.TYPE().toString().equals(TSElement.TYPE.string_SJ.name())? TSElement.TYPE.string_SJ : TSElement.TYPE.Lib ;
        TS.Instance.add(element);

        if(ctx.STRING() != null) {
            if(TS.get(ctx.ID().getText()).type != TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Cannot assign to \"" + ctx.ID().getText() + "\" string_SJ value " + ctx.STRING().getText() + "."));
                return (Object) "null";
            }
            element.Valeur = ctx.STRING().getText();
            QuadElement quad = new QuadElement(":=", ctx.STRING().getText(), null, ctx.ID().toString());
            Quad.Instance.add(quad);
        } else if(ctx.expression() != null) {
            if(TS.get(ctx.ID().getText()).type == TSElement.TYPE.string_SJ && TS.get(ctx.expression().getText()).type != TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ":Semantic error: Incompatible types between \"" + ctx.ID().getText() + "\" and \"" + ctx.expression().getText() + "\"."));
                return (Object) "null";
            }
            String exp = visitExpression(ctx.expression()).toString();
            if (exp.equals("null")) return (Object) "null";
            if(TS.get(ctx.ID().getText()).type == TSElement.TYPE.int_SJ && TS.get(exp).type == TSElement.TYPE.float_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ":Semantic error: Incompatible types between \"" + ctx.ID().getText() + "\" and \"" + ctx.expression().getText() + "\"."));
                return (Object) "null";
            }
            element.Valeur = TS.get(exp).Valeur;
            QuadElement quad = new QuadElement(":=", exp, null, ctx.ID().toString());
            Quad.Instance.add(quad);
        }
        return null;
    }

    @Override
    public Object visitExpression(Small_JavaParser.ExpressionContext ctx) {
        if((ctx.avalue == null && ctx.evalue == null && !isLang) || (ctx.avalue != null && ctx.avalue.getText().charAt(0) == '"'))
            ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Syntactic error: Consider importing Small_Java.lang"));
        if(ctx.avalue != null) {
            return visitAtom(ctx.avalue);
        } else if(ctx.op != null) {
            String left = visitExpression(ctx.left).toString();
            String right = visitExpression(ctx.right).toString();
            if(left.equals("null") || right.equals("null")) return (Object) "null";
            TSElement.TYPE leftType = TS.Instance.get(left).type;
            TSElement.TYPE rightType = TS.Instance.get(right).type;
            if(leftType == TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Cannot apply \"" + ctx.op.getText() + "\" on variable \"" + left + "\" of type \"string_SJ\"."));
                return (Object) "null";
            }
            if(rightType == TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Cannot apply \"" + ctx.op.getText() + "\" on variable \"" + right + "\" of type \"string_SJ\"."));
                return (Object) "null";
            }
            String op;
            switch (ctx.op.getText()) {
                case "+" : op = "ADD"; break;
                case "-" : op = "SUB"; break;
                case "*" : op = "MUL"; break;
                case "/" : op = "DIV"; break;
                default: op = ctx.op.getText();
            }
            QuadElement quad = new QuadElement(op, left, right,"");
            TSElement element = new TSElement();
            element.Nom = quad.res;
            if(rightType != leftType || rightType == TSElement.TYPE.float_SJ) element.type = TSElement.TYPE.float_SJ;
            else element.type = TSElement.TYPE.int_SJ;

            String leftValue = TS.Instance.get(left).Valeur;
            String rightValue = TS.Instance.get(right).Valeur;
            final boolean b = leftValue == null || leftValue.isEmpty() || leftValue.equals("Unknown") || leftValue.equals("Error") || rightValue == null || rightValue.isEmpty() || rightValue.equals("Unknown") || rightValue.equals("Error");
            switch (ctx.op.getText()) {
                case "+" :
                    if(b) {
                        element.Valeur = "Unknown";
                        break;
                    }
                    if(element.type == TSElement.TYPE.int_SJ)
                        element.Valeur = Integer.parseInt(leftValue) + Integer.parseInt(rightValue) + "";
                    else
                        element.Valeur = Float.parseFloat(leftValue) + Float.parseFloat(rightValue) + "";
                    break;
                case "-" :
                    if(b) {
                        element.Valeur = "Unknown";
                        break;
                    }
                    if(element.type == TSElement.TYPE.int_SJ)
                        element.Valeur = Integer.parseInt(leftValue) - Integer.parseInt(rightValue) + "";
                    else
                        element.Valeur = Float.parseFloat(leftValue) - Float.parseFloat(rightValue) + "";
                    break;
                case  "*" :
                    try {
                        if(Float.parseFloat(leftValue) == 0) {
                            element.Valeur = "0";
                            break;
                        }
                    } finally {}
                    try {
                        if(Float.parseFloat(rightValue) == 0) {
                            element.Valeur = "0";
                            break;
                        }
                    } finally {}
                    if(b) {
                        element.Valeur = "Unknown";
                        break;
                    }
                    if(element.type == TSElement.TYPE.int_SJ)
                        element.Valeur = Integer.parseInt(leftValue) * Integer.parseInt(rightValue) + "";
                    else
                        element.Valeur = Float.parseFloat(leftValue) * Float.parseFloat(rightValue) + "";
                    break;
                case "/" :
                    try {
                        if(Float.parseFloat(rightValue) == 0) {
                            element.Valeur = "Error";
                            break;
                        }
                    } finally {}
                    if(b) {
                        element.Valeur = "Unknown";
                        break;
                    }
                    if(element.type == TSElement.TYPE.int_SJ)
                        element.Valeur = Integer.parseInt(leftValue) / Integer.parseInt(rightValue) + "";
                    else
                        element.Valeur = Float.parseFloat(leftValue) / Float.parseFloat(rightValue) + "";
                    break;
            }

            TS.TST.add(element);
            Quad.Instance.add(quad);
            return (Object) quad.res;
        } if(ctx.evalue != null) {
            return visitExpression(ctx.evalue);
        } else {
            return super.visitExpression(ctx);
        }
    }

    @Override
    public Object visitAtom(Small_JavaParser.AtomContext ctx) {
        TSElement element = new TSElement();
        if(ctx.ID() != null) {
            if(!TS.Instance.contains(ctx.ID().toString())) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: variable \"" + ctx.ID().toString() + "\" is not defined."));
                return (Object) "null";
            }
        } else if(ctx.FLOAT_NUMBER() != null) {
            element.Nom = ctx.content.getText();
            element.Valeur = ctx.content.getText();
            element.type = TSElement.TYPE.float_SJ;
            TS.TST.add(element);
        } else if(ctx.INT_NUMBER() != null) {
            element.Nom = ctx.content.getText();
            element.Valeur = ctx.content.getText();
            element.type = TSElement.TYPE.int_SJ;
            TS.TST.add(element);
        }
        return (Object) ctx.content.getText();
    }

    @Override
    public Object visitMov(Small_JavaParser.MovContext ctx) {
        if(!TS.Instance.contains(ctx.ID().toString())) {
            ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Variable \"" + ctx.ID().toString() + "\" is not defined."));
            return (Object) "null";
        }
        if(ctx.STRING() != null) {
            if(TS.get(ctx.ID().getText()).type != TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Cannot assign to \"" + ctx.ID().getText() + "\" string_SJ value " + ctx.STRING().getText() + "."));
                return (Object) "null";
            }
            TS.get(ctx.ID().getText()).Valeur = ctx.STRING().getText();
            QuadElement quad = new QuadElement(":=", ctx.STRING().getText(), null, ctx.ID().toString());
            Quad.Instance.add(quad);
        } else if(ctx.expression() != null) {
            if(TS.get(ctx.ID().getText()).type == TSElement.TYPE.string_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Incompatible types between \"" + ctx.ID().getText() + "\" and \"" + ctx.expression().getText() + "\"."));
                return (Object) "null";
            }
            String exp = visitExpression(ctx.expression()).toString();
            if(TS.get(ctx.ID().getText()).type == TSElement.TYPE.int_SJ && TS.get(exp).type == TSElement.TYPE.float_SJ) {
                ErrorListener.Errors.add(new ParseCancellationException("L" + ctx.getStart().getLine() + ": Semantic error: Incompatible types between \"" + ctx.ID().getText() + "\" and \"" + ctx.expression().getText() + "\"."));
                return (Object) "null";
            }
            TS.get(ctx.ID().getText()).Valeur = TS.get(exp).Valeur;
            QuadElement quad = new QuadElement(":=", exp, null, ctx.ID().toString());
            Quad.Instance.add(quad);
        }
        return null;
    }

    @Override
    public Object visitCond(Small_JavaParser.CondContext ctx) {
        if(ctx.op != null) {
            String left = visitCond(ctx.left).toString();
            String right = visitCond(ctx.right).toString();
            if(left.equals("null") || right.equals("null")) return (Object) "null";
            String leftValue = TS.get(left).Valeur;
            String rightValue = TS.get(right).Valeur;
            QuadElement quad = new QuadElement(ctx.op.getText(), left, right, "");
            TSElement element = new TSElement();
            element.Nom = quad.res;
            element.type = TSElement.TYPE.boolean_SJ;
            Quad.Instance.add(quad);
            TS.TST.add(element);
            boolean both = (leftValue.equals("Unknown") || leftValue.equals("Error")) && (rightValue.equals("Unknown") || rightValue.equals("Error"));
            boolean notBoth = (leftValue.equals("Unknown") || leftValue.equals("Error")) || (rightValue.equals("Unknown") || rightValue.equals("Error"));
            if(both) {
                element.Valeur = "Unknown";
                return (Object) quad.res;
            }
            if(ctx.op.getText().equals("&")) {
                if(leftValue.charAt(0) == '0' || rightValue.charAt(0) == '0') element.Valeur = "0";
                else if(notBoth) element.Valeur = "Unknown";
                else element.Valeur = "1";
            } else {
                if(leftValue.charAt(0) == '1' || rightValue.charAt(0) == '1') element.Valeur = "1";
                else if(notBoth) element.Valeur = "Unknown";
                else element.Valeur = "0";
            }
            return (Object) quad.res;
        } if(ctx.not != null) {
            String left = visitCond(ctx.notval).toString();
            QuadElement quad = new QuadElement(ctx.not.getText(), null, null, left);
            Quad.Instance.add(quad);
            TSElement element = TS.get(left);
            if(!element.Valeur.equals("Error") && !element.Valeur.equals("Unknown")) {
                element.Valeur = element.Valeur.charAt(0) == '0'? "1" : "0";
            }
            return (Object) quad.res;
        } if(ctx.compval != null) {
            return visitCond(ctx.compval);
        } else if(ctx.comp() != null) {
            return visitComp(ctx.comp());
        }
        return super.visitCond(ctx);
    }

    @Override
    public Object visitComp(Small_JavaParser.CompContext ctx) {
        String left = visitExpression(ctx.left).toString();
        String right = visitExpression(ctx.right).toString();
        if(left.equals("null") || right.equals("null")) return (Object) "null";
        QuadElement quad = new QuadElement(ctx.op.getText(), left, right, "");
        TSElement element = new TSElement();
        Quad.Instance.add(quad);
        TS.TST.add(element);
        element.Nom = quad.res;
        element.type = TSElement.TYPE.boolean_SJ;
        element.Valeur = "Unknown";

        if(TS.get(left).type == TSElement.TYPE.string_SJ && TS.get(right).type != TSElement.TYPE.string_SJ || TS.get(right).type == TSElement.TYPE.string_SJ && TS.get(left).type != TSElement.TYPE.string_SJ ) {
            ErrorListener.Errors.add(new ParseCancellationException("Semantic error (L" + ctx.left.start.getLine() + " P" + ctx.left.start.getCharPositionInLine() + "): Incompatible types between \"" + ctx.left.getText() + "\" and \""+ ctx.right.getText() + "\"."));
            return (Object) "null";
        }

        return (Object) quad.res;
    }

    @Override
    public Object visitCondition(Small_JavaParser.ConditionContext ctx) {
        QuadElement iff = new QuadElement("BZ", visitCond(ctx.cond()).toString(), null, null);
        Quad.Instance.add(iff);
        visitInstructions(ctx.then);
        if(ctx.els == null) iff.res = Quad.Instance.quadCounter + "";
        else {
            QuadElement jmp = new QuadElement("BR", null, null, null);
            Quad.Instance.add(jmp);
            iff.res = Quad.Instance.quadCounter + "";
            visitInstructions(ctx.els);
            jmp.res = Quad.Instance.quadCounter + "";
        }
        return null;
    }

    @Override
    public Object visitSingle_import(Small_JavaParser.Single_importContext ctx) {
        if(ctx.lib.getText().endsWith("g")) {
            if(isLang)
                ErrorListener.Errors.add(new ParseCancellationException(ctx.lib.getLine() + ":" + (ctx.lib.getStartIndex() - ctx.getStart().getStartIndex()) + "-" + (ctx.lib.getStopIndex() - ctx.getStart().getStartIndex()) + " Syntactic error: library \"Small_Java.lang\" already imported."));
            isLang = true;
        }
        if(ctx.lib.getText().endsWith("o")) {
            if(isIo)
                ErrorListener.Errors.add(new ParseCancellationException(ctx.lib.getLine() + ":" + ctx.lib.getCharPositionInLine() + "-" + ctx.lib.getCharPositionInLine() + " Syntactic error: library \"Small_Java.io\" already imported."));
            isIo = true;
        }
        return null;
    }

    @Override
    public Object visitRead_expression(Small_JavaParser.Read_expressionContext ctx) {
        if(!isIo) {
            ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: consider importing \"Small_Java.io\"."));
            return null;
        }
        for(TerminalNode t : ctx.ID()) {
            if(TS.get(t.getText()) == null) ErrorListener.Errors.add(new ParseCancellationException(t.getSymbol().getLine()+":"+t.getSymbol().getCharPositionInLine()+"-"+(t.getSymbol().getCharPositionInLine()+t.getText().length())+" Syntactic error: variable \'"+t.getText()+"\' not defined."));
        }
        Matcher matcher =  Pattern.compile("%[dfs]").matcher(ctx.STRING().getText());
        if((ctx.STRING().getText().split("%[dfs]").length ) - 1 != ctx.ID().size())
            ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: %x count different from vars count."));
        else {
            int index = 0;
            while(matcher.find()) {
                char c = matcher.group().charAt(1);
                TSElement.TYPE type = c=='f' ? TSElement.TYPE.float_SJ : c=='d' ? TSElement.TYPE.int_SJ : TSElement.TYPE.string_SJ;
                if(TS.get(ctx.ID(index).getText()) != null && TS.get(ctx.ID(index).getText()).type != type)
                    ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: incompatible types between %" + c + " and variable \"" + ctx.ID(index) + "\"."));
                Quad.Instance.add(new QuadElement("Lire", null, null, ctx.ID(index++).getText()));
            }
        }
        return null;
    }

    @Override
    public Object visitWrite_expression(Small_JavaParser.Write_expressionContext ctx) {
        if(!isIo) {
            ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: consider importing \"Small_Java.io\"."));
            return null;
        }
        for(TerminalNode t : ctx.ID()) {
            if(TS.get(t.getText()) == null) ErrorListener.Errors.add(new ParseCancellationException(t.getSymbol().getLine()+":"+t.getSymbol().getCharPositionInLine()+"-"+(t.getSymbol().getCharPositionInLine()+t.getText().length())+" Syntactic error: variable \'"+t.getText()+"\' not defined."));
        }
        Matcher matcher = Pattern.compile("%[dfs]").matcher(ctx.STRING().getText());
        String[] strings = ctx.STRING().getText().split("%[dfs]");
        strings[0]=strings[0].replace("\"","");
        strings[strings.length-1]=strings[strings.length-1].replace("\"","");
        if((strings.length) - 1 != ctx.ID().size())
            ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: %x count different from vars count."));
        else {
            int index = 0;
            while(matcher.find()) {
                char c = matcher.group().charAt(1);
                TSElement.TYPE type = c=='f' ? TSElement.TYPE.float_SJ : c=='d' ? TSElement.TYPE.int_SJ : TSElement.TYPE.string_SJ;
                if(TS.get(ctx.ID(index).getText()) != null && TS.get(ctx.ID(index).getText()).type != type)
                    ErrorListener.Errors.add(new ParseCancellationException("line"+ctx.STRING().getSymbol().getLine()+" Syntactic error: incompatible types between %" + c + " and variable \"" + ctx.ID(index) + "\"."));
                if(!strings[index].isEmpty()) Quad.Instance.add(new QuadElement("Ecrire", null, null, "\""+strings[index]+"\""));
                Quad.Instance.add(new QuadElement("Ecrire", null, null, ctx.ID(index++).getText()));
            }
            if(!strings[index].isEmpty()) Quad.Instance.add(new QuadElement("Ecrire", null, null, "\""+strings[index]+"\'"));
        }
        return null;
    }
}
