package patterns.mediator;

import patterns.visitor.InicializarVariavel;
import patterns.visitor.ListaVariaveis;

public class MediadorCalculo extends Mediador {

    public EditorExpressao editExpr;
    public EditorVariaveis editVar;

    @Override
    public void objetoAlterado(ClasseMediada objetoMediado) {
        if (objetoMediado == editExpr)
            objetoCalculoAlterado((EditorExpressao) objetoMediado);
        // ***** E R R A D O ! ! ! *****
        //else
        //    objetoCalculoAlterado((EditorVariaveis) objetoMediado);
        if (objetoMediado == editVar)
            objetoCalculoAlterado((EditorVariaveis) objetoMediado);
    }
    
    public EditorExpressao getEditorExpressao(){
        return editExpr;
    }
    
    public EditorVariaveis getEditorVariaveis(){
        return editVar;
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
