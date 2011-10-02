package patterns.interpreter;

public abstract class OperacaoUnaria extends Expressao {

    public Expressao operando1;

    public OperacaoUnaria(Expressao operando1) {
        this.operando1 = operando1;
    }
}
