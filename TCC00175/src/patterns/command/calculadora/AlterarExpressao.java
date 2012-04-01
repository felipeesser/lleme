package patterns.command.calculadora;

import patterns.mediator.MediadorDeAlteracao;

public class AlterarExpressao extends Command {

    private String expressao;

    public AlterarExpressao(String expressao, MediadorDeAlteracao mediador) {
        super(mediador);
        this.expressao = expressao;
    }

    public AlterarExpressao(MediadorDeAlteracao mediador) {
        super(mediador);
    }

    @Override
    public void execute() throws CloneNotSupportedException, Exception {
        super.execute();
        mediador.setExpressaoStr(expressao);
    }
}
