package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class L extends Caractere {

    private static L instancia = null;

    private L() {

    }

    public static L obterInstancia() {
        if (instancia == null)
            instancia = new L();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, true, true, true, true}};
        mostrador1.acenderLeds(estados);
    }

}
