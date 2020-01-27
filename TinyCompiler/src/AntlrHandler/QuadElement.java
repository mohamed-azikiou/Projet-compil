package AntlrHandler;

public class QuadElement {
    public String op;
    public String op1;
    public String op2;
    public String res;
    public QuadElement(String op, String op1, String op2, String res) {
        this.op = op;
        this.op1 = op1;
        this.op2 = op2;
        if(res!=null && res.isEmpty()) {
            this.res = Quad.Instance.counter++ + "T";
        } else {
            this.res = res;
        }
        Quad.Instance.quadCounter ++;
    }
}
