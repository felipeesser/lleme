package patterns.interpreter;

import patterns.visitor.Visitor;

public class Multiplicacao extends OperacaoBinaria {

    public Multiplicacao(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() * operando2.calcular();
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "prod";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }
}
