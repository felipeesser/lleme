package patterns.interpreter;

public class Seno extends OperacaoUnaria {

    public Seno(Expressao operando1) {
        super(operando1);
    }

    @Override
    public float interpretar() {
        return (float) Math.sin(operando1.interpretar());
    }
}
