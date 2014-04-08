package trabalhos.s20141;

public class Matriz extends Expressao {

    private double[][] matriz = null;

    public Matriz(int linhas, int colunas) {
        if (linhas < 0 || colunas < 0)
            throw new IllegalArgumentException();
        matriz = new double[linhas][colunas];
    }

    public double obter(int lin, int col) {
        if (lin < linhas() && col < colunas())
            return matriz[lin][col];
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public void atribuir(int lin, int col, double valor) {
        if (lin < linhas() && col < colunas())
            matriz[lin][col] = valor;
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    public int linhas() {
        return matriz.length;
    }

    public int colunas() {
        return matriz[0].length;
    }

    @Override
    public Matriz valor() {
        return this;
    }

}
