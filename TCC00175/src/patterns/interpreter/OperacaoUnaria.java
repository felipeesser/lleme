package patterns.interpreter;

public abstract class OperacaoUnaria extends ExpressaoGenerica {

    public ExpressaoGenerica operando1;

    public OperacaoUnaria(ExpressaoGenerica operando1) {
        this.operando1 = operando1;
    }

    @Override
    public OperacaoUnaria clone() throws CloneNotSupportedException {
        OperacaoUnaria operacao = (OperacaoUnaria) super.clone();
        if (operando1 != null)
            operacao.operando1 = operando1.clone();
        return operacao;
    }
}
