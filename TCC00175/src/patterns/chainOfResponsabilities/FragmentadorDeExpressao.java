package patterns.chainOfResponsabilities;

import java.util.Stack;
import org.omg.CORBA.UserException;
import patterns.interpreter.Expressao;

public abstract class FragmentadorDeExpressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();
    public FragmentadorDeExpressao proximo = null;

    public abstract String extrairSimbolo(String expressaoStr) throws UserException;
}
