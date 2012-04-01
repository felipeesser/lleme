package patterns.visitor;

import java.util.HashSet;
import java.util.Set;
import patterns.interpreter.ExpressaoGenerica;

public class ListaVariaveis extends Visitor {
    
    public Set<String> nomesVars = new HashSet<String>();
    
    @Override
    public void visitExpressao(ExpressaoGenerica expr) {
        if (expr.getNome().startsWith("_"))
            nomesVars.add(expr.getNome());
    }
}
