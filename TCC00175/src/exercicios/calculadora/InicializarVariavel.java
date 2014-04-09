package exercicios.calculadora;

import exercicios.calculadora.RepresentacaoExpressao;

public class InicializarVariavel extends Visitor {

  public String nomeVariavel;
  public double valor;

  public InicializarVariavel(String nomeVariavel, double valor) {
    this.nomeVariavel = nomeVariavel;
    this.valor = valor;
  }

  @Override
  public void visitExpressao(RepresentacaoExpressao expr) {
    if (expr.getNome().equals(nomeVariavel))
      expr.setValor(valor);
  }
}
