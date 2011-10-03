package patterns.interpreter;

public class Seno extends OperacaoUnaria {

    public Seno(Expressao operando1) {
        super(operando1);
    }

    @Override
    public double calcular() {
        return  Math.sin(operando1.calcular());
    }
}
