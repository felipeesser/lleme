package exercicios.calculadora.memento;

public interface Originator {

    public Memento createMemento();

    public void setMemento(Memento m);
}
