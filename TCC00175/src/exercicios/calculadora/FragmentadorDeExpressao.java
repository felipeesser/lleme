package exercicios.calculadora;

import java.util.Stack;
import exercicios.calculadora.RepresentacaoExpressao;

public abstract class FragmentadorDeExpressao {

  private static Stack<RepresentacaoExpressao> pilha = new Stack<RepresentacaoExpressao>();

  /**
   * @return the pilha
   */
  public static Stack<RepresentacaoExpressao> getPilha() {
    return pilha;
  }
  public FragmentadorDeExpressao proximo = null;

  public abstract String extrairSimbolo(String expressaoStr) throws Exception;
}
