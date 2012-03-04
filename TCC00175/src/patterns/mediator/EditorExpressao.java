package patterns.mediator;

import patterns.decorator.InterpretadorBasico;
import patterns.decorator.InterpretadorDeExpressao;
import patterns.decorator.InterpretadorTrigonometrico;
import patterns.interpreter.Expressao;

public class EditorExpressao extends ClasseMediada {

    private String expressaoStr;
    public Expressao expressao;
    private InterpretadorDeExpressao interpretador;

    public EditorExpressao(Mediador mediador) {
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
}
