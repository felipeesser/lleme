package patterns.interpreter;

public class Coseno extends OperacaoUnaria {

    public Coseno(Expressao operando1) {
        super(operando1);
    }

    @Override
    public float interpretar() {
        return (float) Math.cos(operando1.interpretar());
    }
}
