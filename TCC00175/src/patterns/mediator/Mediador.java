package patterns.mediator;

public abstract class Mediador {

    public Mediador() {
        criarClassesRelacionadas();
    }

    public abstract <T> void objetoAlterado(T mediado);

    public abstract void criarClassesRelacionadas();
}
