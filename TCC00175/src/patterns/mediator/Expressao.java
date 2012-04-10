package patterns.mediator;

import patterns.decorator.InterpretadorBasico;
import patterns.decorator.InterpretadorDeExpressao;
import patterns.decorator.InterpretadorTrigonometrico;
import patterns.interpreter.RepresentacaoExpressao;

public class Expressao extends ClasseMediada implements Cloneable {

    private String expressaoStr;
    private InterpretadorDeExpressao interpretador;
    public RepresentacaoExpressao expressao;

    public Expressao(Mediador mediador) {
        super(mediador);
        interpretador = new InterpretadorTrigonometrico(new InterpretadorBasico());
    }

    public void setExpressaoStr(String expressaoStr) throws Exception {
        if (!expressaoStr.trim().equals(this.expressaoStr)) {
            this.expressaoStr = expressaoStr;
            expressao = interpretador.interpretar(this.expressaoStr);
            alterado();
        }
    }

    public String getExpressaoStr() {
        return expressaoStr;
    }

    public Double getResultado() {
        return expressao.calcular();
    }

    @Override
    public void alterado() {
        mediador.objetoAlterado(this);
    }

    public Expressao clone() throws CloneNotSupportedException {
        Expressao expr = (Expressao) super.clone();
        if (expr.expressao != null)
            expr.expressao = expressao.clone();
        return expr;
    }
}
