package patterns.decorator;

import org.omg.CORBA.UserException;

import patterns.chainOfResponsabilities.FragmentadorExpressao;

public abstract class InterpretadorDeExpressao {

    public FragmentadorExpressao cadeiaDeFragmentadores = null;

    public void interpretar(String expressao) throws UserException {
        do
            expressao = cadeiaDeFragmentadores.fragmentarExpressao(expressao);
        while (expressao != null);
        System.out.println(FragmentadorExpressao.pilha.peek().interpretar());
    }

    public String fragmentar(String expressao) throws UserException {
        return cadeiaDeFragmentadores.fragmentarExpressao(expressao);
    }
}
