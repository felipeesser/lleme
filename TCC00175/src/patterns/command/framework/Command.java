package patterns.command.framework;

public abstract class Command implements Cloneable{

    public abstract void execute();
    
    public abstract void desfazer();
}
