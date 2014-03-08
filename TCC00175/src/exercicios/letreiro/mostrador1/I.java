package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class I extends Caractere {

    private static I instancia = null;

    private I() {

    }

    public static I obterInstancia() {
        if (instancia == null)
            instancia = new I();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false}};
        mostrador1.acenderLeds(estados);
    }

}
