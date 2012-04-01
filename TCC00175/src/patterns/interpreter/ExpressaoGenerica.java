package patterns.interpreter;

import patterns.visitor.Node;

public abstract class ExpressaoGenerica implements Cloneable, Node {

    public abstract double calcular();

    public abstract void setValor(double valor);

    public abstract String getNome();

    @Override
    public ExpressaoGenerica clone() throws CloneNotSupportedException {
        return (ExpressaoGenerica) super.clone();
    }
}
