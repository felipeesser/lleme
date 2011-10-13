package patterns.mediator;

import patterns.visitor.InicializarVariavel;
import patterns.visitor.ListaVariaveis;

public class MediadorCalculo extends Mediador {

    public EditorExpressao editExpr;
    public EditorVariaveis editVar;

    @Override
    public <T> void objetoAlterado(T mediado) {
        objetoAlterado(mediado);
    }

    public void objetoAlterado(EditorExpressao mediado) {
        ListaVariaveis v = new ListaVariaveis();
        editExpr.expressao.accept(v);
        for (String nome : v.nomesVars)
            if (editVar.getVar(nome) == null)
                editVar.setVar(nome, 0.0);
        for (String nome : editVar.listVarsNames())
            if (!v.nomesVars.contains(nome))
                editVar.removeVar(nome);
    }

    public void objetoAlterado(EditorVariaveis mediado) {
        for (String nome : editVar.listVarsNames())
            editExpr.expressao.accept(new InicializarVariavel(nome, editVar.getVar(nome)));
    }

    @Override
    public void criarClassesRelacionadas() {
        editExpr = new EditorExpressao(this);
        editVar = new EditorVariaveis(this);
    }
}
