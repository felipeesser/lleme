package patterns.interpreter;

import patterns.visitor.Node;

public abstract class RepresentacaoExpressao implements Cloneable, Node {

    public abstract double calcular();

    public abstract void setValor(double valor);

    public abstract String getNome();

    @Override
    public RepresentacaoExpressao clone() throws CloneNotSupportedException {
        return (RepresentacaoExpressao) super.clone();
    }
}
