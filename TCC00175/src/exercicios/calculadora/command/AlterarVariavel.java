package exercicios.calculadora.command;

import exercicios.calculadora.command.Command;
import exercicios.calculadora.mediator.MediadorDeAlteracao;
import patterns.memento.Originator;

public class AlterarVariavel extends Command {

    private String variavel;
    private Double valor;

    public AlterarVariavel(String variavel, Double valor, MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        super(mediador, originator);
        this.variavel = variavel;
        this.valor = valor;
    }

    public void execute() throws CloneNotSupportedException, Exception {
        mediador.setVar(variavel, valor);
    }
}
