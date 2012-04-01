package patterns.chainOfResponsabilities;

import java.util.Stack;
import patterns.interpreter.ExpressaoGenerica;

public abstract class FragmentadorDeExpressao {

    private static Stack<ExpressaoGenerica> pilha = new Stack<ExpressaoGenerica>();

    /**
     * @return the pilha
     */
    public static Stack<ExpressaoGenerica> getPilha() {
        return pilha;
    }
    public FragmentadorDeExpressao proximo = null;

    public abstract String extrairSimbolo(String expressaoStr) throws Exception;
}
