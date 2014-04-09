package exercicios.calculadora;

import java.util.HashSet;
import java.util.Set;
import exercicios.calculadora.RepresentacaoExpressao;

public class ListaVariaveis extends Visitor {

  public Set<String> nomesVars = new HashSet<String>();

  @Override
  public void visitExpressao(RepresentacaoExpressao expr) {
    if (expr.getNome().startsWith("_"))
      nomesVars.add(expr.getNome());
  }
}
