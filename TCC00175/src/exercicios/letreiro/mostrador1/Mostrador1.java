package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Mostrador;
import exercicios.letreiro.Visitante;

public class Mostrador1 extends Mostrador {

    private static final byte linhas = 5;
    private static final byte colunas = 5;
    public boolean[][] estados = new boolean[linhas][colunas];
    private char[][] leds
            = {{' ', '_', '_', '_', ' '},
            {'|', '\\', '|', '/', '|'},
            {'|', '-', '+', '-', '|'},
            {'|', '/', '|', '\\', '|'},
            {' ', '-', '-', '-', ' '}};

    public void aceitarVisitante(Visitante visitante) {
        visitante.visitarMostrador1(this);
    }

    public void ligarLeds(boolean[][] estados) {
        if (estados != null) {
            int k = estados.length;
            int l = estados[0].length;

            for (int i = 0; i < estados.length; i++)
                for (int j = 0; j < estados.length; j++)
                    if (i < k && j < l)
                        this.estados[i][j] = estados[i][j];
        }
    }

    public char[][] obterLeds() {
        char[][] leds = new char[linhas][colunas];
        for (int i = 0; i < leds.length; i++)
            for (int j = 0; j < leds[0].length; j++)
                if (estados[i][j])
                    leds[i][j] = this.leds[i][j];
                else
                    leds[i][j] = ' ';
        return leds;
    }
}
