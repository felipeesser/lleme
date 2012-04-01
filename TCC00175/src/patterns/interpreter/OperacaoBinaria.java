package patterns.interpreter;

public abstract class OperacaoBinaria extends ExpressaoGenerica {

    public ExpressaoGenerica operando1;
    public ExpressaoGenerica operando2;

    public OperacaoBinaria(ExpressaoGenerica operando1, ExpressaoGenerica operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    @Override
    public OperacaoBinaria clone() throws CloneNotSupportedException {
        OperacaoBinaria operacao = (OperacaoBinaria) super.clone();
        if (operando1 != null)
            operacao.operando1 = operando1.clone();
        if (operando2 != null)
            operacao.operando2 = operando2.clone();
        return operacao;
    }
}
