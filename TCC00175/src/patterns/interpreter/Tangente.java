package patterns.interpreter;

public class Tangente extends OperacaoUnaria{
    
    public Tangente(Expressao operando1) {
        super(operando1);
    }

    @Override
    public double calcular() {
        return Math.tan(operando1.calcular());
    }
    
}
