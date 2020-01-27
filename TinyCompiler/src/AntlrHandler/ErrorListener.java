package AntlrHandler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;

public class ErrorListener extends BaseErrorListener {
    public static ArrayList<Exception> Errors = null;
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        Errors.add(new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg));
    }
}
