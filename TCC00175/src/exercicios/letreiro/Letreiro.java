package exercicios.letreiro;

public class Letreiro {

    private char[] mensagem = null;
    private Mostrador[] mostradores = null;
    private Fabrica fabrica = null;
    private int tamanho = 0;
    private int posInicialMsg = 0;

    public Letreiro(byte tamanho, Fabrica fabrica) {
        this.tamanho = tamanho;
        this.fabrica = fabrica;
        this.mostradores = new Mostrador[tamanho];
        for (int i = 0; i < mostradores.length; i++)
            mostradores[i] = fabrica.criarMostrador();
    }

    public void atribuirMensagem(String mensagem) {
        int tamanho = Math.max(mensagem.length(), mostradores.length);
        char[] msgChars = mensagem.toCharArray();

        this.mensagem = new char[tamanho];
        for (int i = 0; i < this.mensagem.length; i++)
            this.mensagem[i] = ' ';
        for (int i = 0; i < msgChars.length; i++)
            this.mensagem[i] = msgChars[i];
    }

    public char[][] obterLeds() {
        Visitante visitante;
        char[][] leds = null;
        int posMsg = 0;
        for (int i = 0; i < mostradores.length; i++) {
            posMsg = (posInicialMsg + i) % tamanho;
            visitante = fabrica.obterCaractere(mensagem[posMsg]);
            mostradores[i].aceitarVisitante(visitante);
            leds = incluirMostrador(leds, mostradores[i].obterLeds());
        }
        posInicialMsg++;
        return leds;
    }

    private char[][] incluirMostrador(char[][] leds, char[][] mostrador) {
        char[][] newLeds = new char[0][0];
        if (leds == null)
            leds = mostrador;
        else {

        }
        return newLeds;
    }
}
