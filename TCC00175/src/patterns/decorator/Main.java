package patterns.decorator;

import patterns.interpreter.Expressao;
import patterns.visitor.InicializarVariavel;

public class Main {

    public static void main(String[] args) throws Exception {

        InterpretadorDeExpressao componente = new InterpretadorBasico();
        InterpretadorDeExpressao decorador = new InterpretadorTrigonometrico(componente);

        Expressao expr = decorador.interpretar("2 _a * _b +");
        expr.accept(new InicializarVariavel("_a", 5));
        expr.accept(new InicializarVariavel("_b", 3));

        System.out.println(expr.calcular());
    }
}
