package exercicios.letreiro;

import exercicios.letreiro.mostrador1.A;
import exercicios.letreiro.mostrador1.Mostrador1;

public class FabricaMostrador1 extends Fabrica {

    @Override
    public Mostrador criarMostrador() {
        return new Mostrador1();
    }

    @Override
    public Visitante obterCaractere(char caractere) {
        switch (caractere) {
            case 'A':
            case 'a':
                return A.obterInstancia();
            case 'E':
            case 'e':
                return A.obterInstancia();
            case 'I':
            case 'i':
                return A.obterInstancia();
            case 'U':
            case 'u':
                return A.obterInstancia();
            case 'D':
            case 'd':
                return A.obterInstancia();
            case 'L':
            case 'l':
                return A.obterInstancia();
            case 'N':
            case 'n':
                return A.obterInstancia();
            case 'R':
            case 'r':
                return A.obterInstancia();
            default:
                return null;
        }
    }

}
