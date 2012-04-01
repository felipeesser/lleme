package patterns.visitor;

public abstract interface Node {

    public abstract void accept(Visitor visitor);
}
