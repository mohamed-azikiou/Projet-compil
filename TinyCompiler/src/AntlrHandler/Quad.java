package AntlrHandler;

import java.util.ArrayList;

public class Quad extends ArrayList<QuadElement> {
    public int counter = 0;
    public int quadCounter = 0;
    public static Quad Instance;
    public static boolean IsTS(String item) {return '0'<=item.charAt(0)&&item.charAt(0)<='9'&&item.endsWith("T");}
}
