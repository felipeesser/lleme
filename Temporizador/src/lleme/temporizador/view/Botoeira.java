package lleme.temporizador.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import lleme.lib.visitor.Element;
import lleme.lib.visitor.Visitor;
import lleme.temporizador.BotaoTemp;
import lleme.temporizador.controller.BotaoReset;
import lleme.temporizador.controller.BotaoStartStop;
import lleme.temporizador.model.Temporizador;

public class Botoeira extends JPanel implements Element {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BotaoTemp myControlerBotaoReset = null;

	private BotaoTemp myControlerBotaoStartStop = null;

	public Botoeira(Temporizador temporizador) {
		setLayout(new GridLayout(1, 0));
		this.myControlerBotaoReset = new BotaoReset(temporizador);
		this.myControlerBotaoStartStop = new BotaoStartStop(temporizador);
		initComponents();
	}

	private void initComponents() {
		add(myControlerBotaoReset);
		add(myControlerBotaoStartStop);
	}

	public void accept(Visitor visitor) {
		myControlerBotaoStartStop.accept(visitor);
		myControlerBotaoReset.accept(visitor);
	}
}
