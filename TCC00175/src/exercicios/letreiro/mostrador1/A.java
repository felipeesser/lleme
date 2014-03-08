package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class A extends Caractere {

    private static A instancia = null;

    private A() {

    }

    public static A obterInstancia() {
        if (instancia == null)
            instancia = new A();
        return instancia;
    }

    @Override
    public void acenderLedsMostrador1(Mostrador1 mostrador) {
        boolean[][] estados
                = {{true, true, true, true, true},
                {true, false, false, false, true},
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true}};
        mostrador.acenderLeds(estados);
    }
}
