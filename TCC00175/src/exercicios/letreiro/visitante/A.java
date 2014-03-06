package exercicios.letreiro.visitante;

import exercicios.letreiro.Mostrador1;
import exercicios.letreiro.visitante.Visitante;

public class A extends Visitante {

  @Override
  public void visitarMostrador1(Mostrador1 mostrador1) {
    boolean[][] estados = {{true, true, true, true, true, true, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true},
      {true, true, true, true, true, true, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true}};
    mostrador1.atribuirEstados(estados);
  }
}
