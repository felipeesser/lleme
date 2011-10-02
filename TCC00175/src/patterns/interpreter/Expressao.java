package patterns.interpreter;

import java.util.Stack;
import org.omg.CORBA.UserException;

public abstract class Expressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();

    public abstract float interpretar();

}
