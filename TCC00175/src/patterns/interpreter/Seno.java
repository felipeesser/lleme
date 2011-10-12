package patterns.interpreter;

import patterns.visitor.Visitor;

public class Seno extends OperacaoUnaria {

    public Seno(Expressao operando1) {
        super(operando1);
    }

    @Override
    public double calcular() {
        return Math.sin(operando1.calcular());
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "sen";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
    }
}
