package patterns.command.calculadora;

import patterns.mediator.MediadorDeAlteracao;
import patterns.memento.Memento;
import patterns.memento.Originator;

public abstract class Command {

    protected MediadorDeAlteracao mediador;
    protected Memento memento;
    protected Memento mementoCalculadora;
    protected Originator originador;

    public Command(MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        this.mediador = mediador;
        memento = mediador.createMemento();
        mementoCalculadora = originator.createMemento();
        this.originador=originador;
    }

    public abstract void execute() throws CloneNotSupportedException, Exception;

    public Memento desfazer() {
        mediador.setMemento(memento);
        //originador.setMemento(mementoCalculadora);
        return mementoCalculadora;
    }
}
