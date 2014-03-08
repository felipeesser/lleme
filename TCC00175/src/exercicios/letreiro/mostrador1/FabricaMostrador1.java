package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;
import exercicios.letreiro.Fabrica;
import exercicios.letreiro.Mostrador;

public class FabricaMostrador1 extends Fabrica {

    @Override
    public Mostrador criarMostrador() {
        return new Mostrador1();
    }

    @Override
    public Caractere obterCaractere(char caractere) {
        switch (caractere) {
            case 'A':
            case 'a':
                return A.obterInstancia();
            case 'E':
            case 'e':
                return E.obterInstancia();
            case 'I':
            case 'i':
                return I.obterInstancia();
            case 'U':
            case 'u':
                return U.obterInstancia();
            case 'D':
            case 'd':
                return D.obterInstancia();
            case 'L':
            case 'l':
                return L.obterInstancia();
            case 'N':
            case 'n':
                return N.obterInstancia();
            case 'R':
            case 'r':
                return R.obterInstancia();
            case 'Z':
            case 'z':
                return R.obterInstancia();
            default:
                return Space.obterInstancia();
        }
    }

}
