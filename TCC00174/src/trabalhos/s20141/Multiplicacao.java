package trabalhos.s20141;

public class Multiplicacao extends OperacaoBinaria {

    @Override
    public Matriz valor() {
        if (oper1 == null || oper2 == null || oper1.linhas() != oper2.linhas() || oper1.colunas() != oper2.colunas())
            throw new IllegalArgumentException();
        Matriz resultado = null;
        // implementacao
        return resultado;
    }
}
