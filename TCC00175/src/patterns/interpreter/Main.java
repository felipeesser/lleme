package patterns.interpreter;

import org.omg.CORBA.UserException;

public class Main {

    public static void main(String[] args) throws UserException {

        System.out.println((new Multiplicacao(new Literal(7),new Literal(3))).calcular());
        
        System.out.println("2 3 + 5 *");

    }
}
