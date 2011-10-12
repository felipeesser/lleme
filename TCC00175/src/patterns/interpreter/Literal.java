package patterns.interpreter;

import patterns.visitor.Visitor;

public class Literal extends Expressao {

    public double numero;

    public Literal(double numero) {
        this.numero = numero;
    }

    @Override
    public double calcular() {
        return numero;
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return numero + "";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
    }
}
