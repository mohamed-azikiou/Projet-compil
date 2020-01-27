package AntlrHandler;

import java.util.Objects;

public class TSElement {
    public enum TYPE { Unknown, boolean_SJ, int_SJ, float_SJ, string_SJ, Lib }

    public String Nom = null;
    public TYPE type;
    public String Valeur = null;
    public  boolean Déclarée = true; //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSElement tsElement = (TSElement) o;
        return Objects.equals(Nom, tsElement.Nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nom, type);
    }
}
