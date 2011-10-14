package patterns.mediator;

import patterns.visitor.InicializarVariavel;
import patterns.visitor.ListaVariaveis;

public class MediadorCalculo extends Mediador {

    public EditorExpressao editExpr;
    public EditorVariaveis editVar;

    @Override
    public void objetoAlterado(ClasseMediada mediado) {
        if (mediado == editExpr)
            objetoCalculoAlterado((EditorExpressao) mediado);
        else
            objetoCalculoAlterado((EditorVariaveis) mediado);
    }

    public void objetoCalculoAlterado(EditorExpressao mediado) {
        ListaVariaveis v = new ListaVariaveis();
        editExpr.expressao.accept(v);
        editVar.updateVars(v.nomesVars);
    }

    public void objetoCalculoAlterado(EditorVariaveis mediado) {
        for (String nome : editVar.listVarsNames())
            editExpr.expressao.accept(new InicializarVariavel(nome, editVar.getVar(nome)));
    }

    @Override
    public void criarClassesRelacionadas() {
        editExpr = new EditorExpressao(this);
        editVar = new EditorVariaveis(this);
    }
}
