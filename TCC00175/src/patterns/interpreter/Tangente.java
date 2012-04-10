package patterns.interpreter;

import patterns.visitor.Visitor;

public class Tangente extends OperacaoUnaria {

    public Tangente(RepresentacaoExpressao operando1) {
        super(operando1);
    }

    @Override
    public double calcular() {
        return Math.tan(operando1.calcular());
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "tan";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
    }

    public Tangente clone() throws CloneNotSupportedException {
        return (Tangente) super.clone();
    }
}
