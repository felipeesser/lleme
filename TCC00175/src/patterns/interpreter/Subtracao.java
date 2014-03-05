package patterns.interpreter;

import patterns.visitor.Visitor;

public class Subtracao extends OperacaoBinaria {

    public Subtracao(RepresentacaoExpressao operando1, RepresentacaoExpressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() - operando2.calcular();
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return "sub";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }

    public Subtracao clone() throws CloneNotSupportedException {
        return (Subtracao) super.clone();
    }
}
