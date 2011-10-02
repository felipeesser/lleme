package patterns.interpreter;

public class Multiplicacao extends OperacaoBinaria {

    public Multiplicacao(Expressao operando1, Expressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public float interpretar() {
        return operando1.interpretar() * operando2.interpretar();
    }
}
