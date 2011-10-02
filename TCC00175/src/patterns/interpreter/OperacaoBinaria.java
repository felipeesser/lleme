package patterns.interpreter;

public abstract class OperacaoBinaria extends Expressao {

    public Expressao operando1;
    public Expressao operando2;

    public OperacaoBinaria(Expressao operando1, Expressao operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }
    
}
