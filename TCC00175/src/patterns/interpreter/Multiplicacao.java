package patterns.interpreter;

public class Multiplicacao extends OperacaoBinaria {

    public Multiplicacao(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public double calcular() {
        return operando1.calcular() * operando2.calcular();
    }
}
