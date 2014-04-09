package exercicios.calculadora;

import exercicios.calculadora.InterpretadorDeExpressao;

public abstract class Decorador extends InterpretadorDeExpressao {

  /**
   * @aggregation shared
   */
  private InterpretadorDeExpressao componente;

  private Decorador() {
  }

  public Decorador(InterpretadorDeExpressao componente) {
    this.componente = componente;
  }

  @Override
  protected String fragmentar(String expressao) throws Exception {
    expressao = componente.cadeiaDeFragmentadores.extrairSimbolo(expressao);
    return cadeiaDeFragmentadores.extrairSimbolo(expressao);
  }
}
