package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class E extends Caractere {

    private static E instancia = null;

    private E() {

    }

    public static E obterInstancia() {
        if (instancia == null)
            instancia = new E();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{true, true, true, true, true},
                {true, false, false, false, false},
                {true, true, true, true, true},
                {true, false, false, false, false},
                {true, false, false, false, true}};
        mostrador1.acenderLeds(estados);
    }

}
