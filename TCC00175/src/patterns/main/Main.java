package patterns.main;

import org.omg.CORBA.UserException;
import patterns.decorator.InterpretadorBasico;
import patterns.decorator.InterpretadorDeExpressao;
import patterns.decorator.InterpretadorTrigonometrico;

public class Main {

    public static void main(String[] args) throws UserException {

        InterpretadorDeExpressao componente = new InterpretadorBasico();
        InterpretadorDeExpressao decorador = new InterpretadorTrigonometrico(componente);
        decorador.interpretar("2 6 * 2 + tan ");
    }
}
