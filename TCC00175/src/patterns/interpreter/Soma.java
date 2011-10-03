package patterns.interpreter;

public class Soma extends OperacaoBinaria {

    public Soma(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() + operando2.calcular();
    }
}
