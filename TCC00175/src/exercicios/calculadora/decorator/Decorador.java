package exercicios.calculadora.decorator;

public abstract class Decorador extends InterpretadorDeExpressao {

    /**
     * @aggregation shared
     */
    private InterpretadorDeExpressao component;

    private Decorador() {
    }

    public Decorador(InterpretadorDeExpressao componente) {
        this.component = componente;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        return component.fragmentar(expressao);
    }
}
