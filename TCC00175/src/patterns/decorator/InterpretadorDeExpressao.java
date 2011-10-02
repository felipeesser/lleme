package patterns.decorator;

import org.omg.CORBA.UserException;

import patterns.chainOfResponsabilities.FragmentadorDeExpressao;

public abstract class InterpretadorDeExpressao {

    protected FragmentadorDeExpressao cadeiaDeFragmentadores = null;

    public void interpretar(String expressao) throws UserException {
        String expressaoAnterior;
        do {
            expressaoAnterior = expressao;
            expressao = fragmentar(expressao);
        } while (expressao != null && !expressao.equals(expressaoAnterior));
        System.out.println(FragmentadorDeExpressao.getPilha().peek().interpretar());
    }

    protected String fragmentar(String expressao) throws UserException {
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
