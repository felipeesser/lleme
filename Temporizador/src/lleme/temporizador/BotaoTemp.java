package lleme.temporizador;

import lleme.lib.visitor.Element;
import lleme.temporizador.model.Temporizador;
import lleme.lib.Botao;

public abstract class BotaoTemp extends Botao implements Element {

	private Temporizador mySubjectTemporizador;

	public BotaoTemp(String nome, Temporizador temporizador) {
		super(nome);
		this.mySubjectTemporizador = temporizador;
	}

	public Temporizador getMySubjectTemporizador() {
		return mySubjectTemporizador;
	}

	public void setMySubjectTemporizador(Temporizador temporizador) {
		this.mySubjectTemporizador = temporizador;
	}
}