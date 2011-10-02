package patterns.decorator;

import org.omg.CORBA.UserException;

public class Main {
    
    public static void main(String[] args) throws UserException {
        InterpretadorDeExpressao i1 = new InterpretadorBasico();
        InterpretadorDeExpressao i2 = new InterpretadorTrigonometrico(i1);
        
        i2.interpretar("2 6 * 2 + cos");
    }
    
}
