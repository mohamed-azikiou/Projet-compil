package AntlrHandler;

import java.util.ArrayList;

public class TS extends ArrayList<TSElement> {
    public static TS Instance = null;
    public static TS TST = null;
    public TSElement get(String Name, TSElement.TYPE type) {
        for(TSElement element : Instance)
            if(element.Nom.equals(Name) && element.type == type) return element;
        return null;
    }

    public boolean contains(String Name, TSElement.TYPE type) {
        return get(Name, type) != null;
    }

    public static TSElement get(String Name) {
        if ('0' <= Name.charAt(0) && Name.charAt(0) <='9')
        {
            for(TSElement elemento : TST)
                if(elemento.Nom.equals(Name)) return elemento;
        }
        else
            for(TSElement element : Instance)
                if(element.Nom.equals(Name)) return element;
        return null;
    }

    public boolean contains(String Name) {
        return get(Name) != null;
    }

}
