package patterns.command.calculadora;

import patterns.mediator.MediadorDeAlteracao;
import patterns.memento.Memento;

public abstract class Command {

    protected MediadorDeAlteracao mediador;
    protected Memento memento;

    public Command(MediadorDeAlteracao mediador) {
        this.mediador = mediador;
    }

    public void execute() throws CloneNotSupportedException, Exception {
        memento = mediador.createMemento();
    }

    public void desfazer() {
        mediador.setMemento(memento);
    }
}
