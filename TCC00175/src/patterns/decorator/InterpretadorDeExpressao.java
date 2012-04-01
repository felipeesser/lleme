package patterns.decorator;

import patterns.chainOfResponsabilities.FragmentadorDeExpressao;
import patterns.interpreter.ExpressaoGenerica;

public abstract class InterpretadorDeExpressao {

    protected FragmentadorDeExpressao cadeiaDeFragmentadores = null;

    public ExpressaoGenerica interpretar(String expressao) throws Exception {
        String expressaoAnterior;
        do {
            expressaoAnterior = expressao;
            expressao = fragmentar(expressao);
        } while (expressao != null && !expressao.equals(expressaoAnterior));
        return FragmentadorDeExpressao.getPilha().peek();
    }

    protected String fragmentar(String expressao) throws Exception {
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
