package patterns.chainOfResponsabilities;

import java.util.Stack;
import org.omg.CORBA.UserException;
import patterns.interpreter.Expressao;

public abstract class FragmentadorDeExpressao {

    private static Stack<Expressao> pilha = new Stack<Expressao>();

    /**
     * @return the pilha
     */
    public static Stack<Expressao> getPilha() {
        return pilha;
    }
    public FragmentadorDeExpressao proximo = null;

    public abstract String extrairSimbolo(String expressaoStr) throws UserException;
}
