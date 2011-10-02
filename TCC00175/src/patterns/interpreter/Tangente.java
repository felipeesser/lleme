package patterns.interpreter;

public class Tangente extends OperacaoUnaria{
    
    public Tangente(Expressao operando1) {
        super(operando1);
    }

    @Override
    public float interpretar() {
        return (float) Math.tan(operando1.interpretar());
    }
    
}
