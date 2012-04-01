package patterns.command.calculadora;

import patterns.mediator.MediadorDeAlteracao;

public class AlterarVariavel extends Command {

    private String variavel;
    private Double valor;

    public AlterarVariavel(String variavel, Double valor, MediadorDeAlteracao mediador) {
        super(mediador);
        this.variavel = variavel;
        this.valor = valor;
    }

    @Override
    public void execute() throws CloneNotSupportedException, Exception {
        super.execute();
        mediador.setVar(variavel, valor);
    }
}
