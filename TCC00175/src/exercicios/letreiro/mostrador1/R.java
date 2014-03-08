package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class R extends Caractere {

    private static R instancia = null;

    private R() {

    }

    public static R obterInstancia() {
        if (instancia == null)
            instancia = new R();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{true, true, true, true, false},
                {true, false, false, false, true},
                {true, true, true, true, false},
                {true, false, false, false, false},
                {true, false, false, false, true}};
        mostrador1.acenderLeds(estados);
    }

}