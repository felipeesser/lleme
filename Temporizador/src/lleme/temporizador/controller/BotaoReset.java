package lleme.temporizador.controller;

import java.awt.event.ActionEvent;

import lleme.lib.visitor.Visitor;
import lleme.temporizador.BotaoTemp;
import lleme.temporizador.model.Temporizador;
import lleme.lib.command.Command;

public class BotaoReset extends BotaoTemp {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1842445485507380512L;

	private Command tempCommand = null;

	public BotaoReset(Temporizador temporizador) {
		super("Reset", temporizador);
		tempCommand = new ResetCommand(temporizador);
	}

	public void actionPerformed(ActionEvent e) {
		e.getActionCommand();
		tempCommand.execute();
	}

	public void accept(Visitor visitor) {
		visitor.VisitBotaoReset(this);
	}
}
