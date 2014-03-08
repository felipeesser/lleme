package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class Z extends Caractere {

    private static Z instancia = null;

    private Z() {

    }

    public static Z obterInstancia() {
        if (instancia == null)
            instancia = new Z();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{true, true, true, true, true},
                {false, false, false, false, true},
                {false, false, true, false, false},
                {false, true, false, false, false},
                {true, true, true, true, true}};
        mostrador1.acenderLeds(estados);
    }

}
