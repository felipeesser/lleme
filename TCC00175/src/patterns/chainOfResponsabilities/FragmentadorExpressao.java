package patterns.chainOfResponsabilities;

import java.util.Stack;
import org.omg.CORBA.UserException;
import patterns.interpreter.Expressao;

public abstract class FragmentadorExpressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();
    public FragmentadorExpressao proximo = null;

    public abstract String fragmentarExpressao(String expressaoStr) throws UserException;
}
