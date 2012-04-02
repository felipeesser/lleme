package patterns.command.calculadora;

import patterns.mediator.MediadorDeAlteracao;
import patterns.memento.Originator;

public class AlterarExpressao extends Command {

    private String expressao;

    public AlterarExpressao(String expressao, MediadorDeAlteracao mediador, Originator originator) throws CloneNotSupportedException {
        super(mediador, originator);
        this.expressao = expressao;
    }

    public void execute() throws CloneNotSupportedException, Exception {
        mediador.setExpressaoStr(expressao);
    }
}
