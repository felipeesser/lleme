package patterns.memento;

public interface Originator {

  public Memento createMemento();

  public void setMemento(Memento m);
}
