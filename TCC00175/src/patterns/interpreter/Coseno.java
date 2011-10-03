package patterns.interpreter;

public class Coseno extends OperacaoUnaria {

    public Coseno(Expressao operando1) {
        super(operando1);
    }

    @Override
    public double calcular() {
        return  Math.cos(operando1.calcular());
    }
}
