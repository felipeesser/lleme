package patterns.visitor;

import patterns.interpreter.ExpressaoGenerica;

public class InicializarVariavel extends Visitor {
    
    public String nomeVariavel;
    public double valor;
    
    public InicializarVariavel(String nomeVariavel, double valor) {
        this.nomeVariavel = nomeVariavel;
        this.valor = valor;
    }
    
    @Override
    public void visitExpressao(ExpressaoGenerica expr) {
        if (expr.getNome().equals(nomeVariavel))
            expr.setValor(valor);
    }
}
