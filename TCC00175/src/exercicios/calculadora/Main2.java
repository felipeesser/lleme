package exercicios.calculadora;

import exercicios.calculadora.InterpretadorDeExpressao;
import exercicios.calculadora.InterpretadorTrigonometrico;
import exercicios.calculadora.InterpretadorBasico;
import exercicios.calculadora.RepresentacaoExpressao;
import exercicios.calculadora.InicializarVariavel;
import exercicios.calculadora.ListaVariaveis;

public class Main2 {

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
