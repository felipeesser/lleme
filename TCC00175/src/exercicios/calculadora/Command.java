package exercicios.calculadora;

import patterns.memento.Memento;
import patterns.memento.Originator;

public abstract class Command {

  protected MediadorDeAlteracao mediador;
  protected Memento memento;
  protected Memento mementoCalculadora;

  public Command(MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
    this.mediador = mediador;
    memento = mediador.createMemento();
    mementoCalculadora = originator.createMemento();
  }

  public abstract void execute() throws CloneNotSupportedException, Exception;

  public Memento desfazer() {
    mediador.setMemento(memento);
    return mementoCalculadora;
  }
}
