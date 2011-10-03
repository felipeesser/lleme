package patterns.interpreter;

public class Subtracao extends OperacaoBinaria {

    public Subtracao(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() - operando2.calcular();
    }
}