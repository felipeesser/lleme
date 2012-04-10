package patterns.visitor;

import patterns.decorator.InterpretadorBasico;
import patterns.decorator.InterpretadorDeExpressao;
import patterns.decorator.InterpretadorTrigonometrico;
import patterns.interpreter.RepresentacaoExpressao;

public class Main {

    public static void main(String[] args) throws Exception {

        InterpretadorDeExpressao componente = new InterpretadorBasico();
        InterpretadorDeExpressao decorador = new InterpretadorTrigonometrico(componente);

        RepresentacaoExpressao expr = decorador.interpretar("2 _a * _b + _b *");
        expr.accept(new InicializarVariavel("_a", 5));
        expr.accept(new InicializarVariavel("_b", 3));
        ListaVariaveis v = new ListaVariaveis();
        expr.accept(v);

        System.out.println(expr.calcular());
    }
}
