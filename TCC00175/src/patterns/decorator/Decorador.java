package patterns.decorator;

import org.omg.CORBA.UserException;

public abstract class Decorador extends InterpretadorDeExpressao {

    /**
     * @aggregation shared
     */
    private InterpretadorDeExpressao componente;

    private Decorador() {
    }

    public Decorador(InterpretadorDeExpressao componente) {
        this.componente = componente;
    }

    @Override
    public String fragmentar(String expressao) throws UserException {
        expressao = componente.cadeiaDeFragmentadores.extrairSimbolo(expressao);
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
