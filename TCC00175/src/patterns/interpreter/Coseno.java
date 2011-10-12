package patterns.interpreter;

import patterns.visitor.Visitor;

public class Coseno extends OperacaoUnaria {
    
    public Coseno(Expressao operando1) {
        super(operando1);
    }
    
    @Override
    public double calcular() {
        return Math.cos(operando1.calcular());
    }
    
    @Override
    public void setValor(double valor) {
        // Não faz nada
    }
    
    @Override
    public String getNome() {
        return "cos";
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpressao(this);
        operando1.accept(visitor);
    }
}
