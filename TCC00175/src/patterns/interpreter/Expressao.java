package patterns.interpreter;

import java.util.Stack;
import org.omg.CORBA.UserException;

public abstract class Expressao {

    public static Stack<Expressao> pilha = new Stack<Expressao>();

    public abstract float interpretar();

    public static void main(String[] args) throws UserException {

        String exp = "4 2 3 + *";
        do
            exp = Literal.fragmentarExpressao(exp);
        while (exp != null);
        System.out.println(Literal.pilha.peek().interpretar());

    }
}
