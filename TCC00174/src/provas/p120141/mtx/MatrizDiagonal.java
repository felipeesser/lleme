package provas.p120141.mtx;

public class MatrizDiagonal extends Matriz {

    public MatrizDiagonal(int linhas) {
        super(1, linhas);
    }

    @Override
    public double obter(int lin, int col) {
        if (lin < numeroDeLinhas() && col < numeroDeColunas()) {
            return super.obter(1, col);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void atribuir(int lin, int col, double valor) {
        if (lin < numeroDeLinhas() && col < numeroDeColunas()) {
            atribuir(1, col, valor);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int numeroDeLinhas() {
        return super.numeroDeColunas();
    }

    @Override
    public int numeroDeColunas() {
        return super.numeroDeColunas();
    }

}
