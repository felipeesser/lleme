package lleme.lib.visitor;

import lleme.temporizador.controller.BotaoReset;
import lleme.temporizador.controller.BotaoStartStop;
import lleme.temporizador.view.MostradorCronometro;
import lleme.temporizador.view.MostradorRegressivo;
import lleme.temporizador.view.MostradorRelogio;

public interface Visitor {
	public abstract void VisitMostradorCronometro(MostradorCronometro mostrador);

	public abstract void VisitMostradorRegressivo(MostradorRegressivo mostrador);

	public abstract void VisitMostradorRelogio(MostradorRelogio mostrador);

	public abstract void VisitBotaoStartStop(BotaoStartStop botao);

	public abstract void VisitBotaoReset(BotaoReset botao);
}
