package exercicios.calculadora;

import exercicios.calculadora.FragmentadorDeExpressao;
import exercicios.calculadora.RepresentacaoExpressao;

public abstract class InterpretadorDeExpressao {

  protected FragmentadorDeExpressao cadeiaDeFragmentadores = null;

  public RepresentacaoExpressao interpretar(String expressao) throws Exception {
    String expressaoAnterior;
    do {
      expressaoAnterior = expressao;
      expressao = fragmentar(expressao);
    } while (expressao != null && !expressao.equals(expressaoAnterior));
    return FragmentadorDeExpressao.getPilha().peek();
  }

  protected String fragmentar(String expressao) throws Exception {
    return cadeiaDeFragmentadores.extrairSimbolo(expressao);
  }
}
