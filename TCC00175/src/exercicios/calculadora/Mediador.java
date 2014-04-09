package exercicios.calculadora;

public abstract class Mediador {

  public Mediador() {
    criarClassesRelacionadas();
  }

  public abstract void objetoAlterado(ClasseMediada mediado);

  public abstract void criarClassesRelacionadas();
}
