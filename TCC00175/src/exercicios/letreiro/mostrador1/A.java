package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Visitante;

public class A extends Visitante {

    private static A instancia = null;

    private A() {

    }

    public static A obterInstancia() {
        if (instancia == null)
            instancia = new A();
        return instancia;
    }

    @Override
    public void visitarMostrador1(Mostrador1 mostrador1) {
        boolean[][] estados
                = {{true, true, true, true, true},
                {true, false, false, false, true},
                {true, true, true, true, true},
                {true, false, false, false, true},
                {true, false, false, false, true}};
        mostrador1.ligarLeds(estados);
    }
}
