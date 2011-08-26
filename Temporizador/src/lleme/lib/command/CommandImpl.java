package lleme.lib.command;

import lleme.temporizador.model.Temporizador;

public abstract class CommandImpl extends Command {

	/**
	 * 
	 */
	public CommandImpl(Temporizador t) {
		super();
		receiver = t;
	}

	private Temporizador receiver = null;

	/**
	 * @return Returns the receiver.
	 */
	public Temporizador getReceiver() {
		return receiver;
	}

}
