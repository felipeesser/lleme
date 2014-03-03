package exercicios.jogoDeDados;


public class Dado {

    private int valor = 0;

    public int obterValor() {
        return valor;
    }

    public int sortear() {
        valor = (int) (1 + Math.random() * 6);
        return valor;
    }
}
