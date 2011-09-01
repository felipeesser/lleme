package lleme.temporizador.controller;

import lleme.temporizador.model.Temporizador;

public class StartCommand extends CommandImpl {

    public StartCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStart();
    }
}
