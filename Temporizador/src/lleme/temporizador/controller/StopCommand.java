package lleme.temporizador.controller;

import lleme.lib.command.CommandImpl;
import lleme.temporizador.model.Temporizador;

public class StopCommand extends CommandImpl {

	public StopCommand(Temporizador t) {
		super(t);
	}

	public void execute() {
		getReceiver().serviceStop();
	}
}
