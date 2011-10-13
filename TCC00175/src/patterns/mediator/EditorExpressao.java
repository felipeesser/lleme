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

    public void setExpressao(String expressaoStr) throws Exception {
        this.expressaoStr = expressaoStr;
        expressao = interpretador.interpretar(this.expressaoStr);
        alterado();
    }

    public String getExpressaoStr() {
        return expressaoStr;
    }

    @Override
    public void alterado() {
        mediador.objetoAlterado(this);
    }
}
