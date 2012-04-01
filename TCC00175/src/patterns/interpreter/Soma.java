package patterns.interpreter;

import patterns.visitor.Visitor;

public class Soma extends OperacaoBinaria {

    public Soma(ExpressaoGenerica operando1, ExpressaoGenerica operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() + operando2.calcular();
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "som";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }

    public Soma clone() throws CloneNotSupportedException {
        return (Soma) super.clone();
    }
}
