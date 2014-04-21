package exercicios.calculadora.mediator;

import exercicios.calculadora.visitor.InicializarVariavel;
import exercicios.calculadora.visitor.ListarVariaveis;
import exercicios.calculadora.visitor.Visitor;

import patterns.memento.Memento;

public class MediadorDeAlteracao extends Mediador {

    public Expressao expressao;
    public MapaVariaveis mapaVariaveis;

    public class MementoMediador implements Memento {

        private Expressao expressao;
        private MapaVariaveis mapaVariaveis;
    }

    @Override
    public void objetoAlterado(ClasseMediada objetoMediado) {
        if (objetoMediado == expressao)
            objetoExpressaoAlterado(expressao);
        else
            objetoMapaAlterado(mapaVariaveis);
    }

    public void objetoExpressaoAlterado(Expressao mediado) {
        ListarVariaveis v = new ListarVariaveis();
        expressao.expressao.accept(v);
        mapaVariaveis.updateVars(v.nomesVars);
    }

    public void objetoMapaAlterado(MapaVariaveis mediado) {
        for (String nome : mapaVariaveis.listVarsNames())
            expressao.expressao.accept(new InicializarVariavel(nome, mapaVariaveis.getVar(nome)));
    }

    @Override
    public void criarClassesRelacionadas() {
        expressao = new Expressao(this);
        mapaVariaveis = new MapaVariaveis(this);
    }

    public Expressao getEditorExpressao() {
        return expressao;
    }

    public MapaVariaveis getEditorVariaveis() {
        return mapaVariaveis;
    }

    public void setExpressaoStr(String expressaoStr) throws Exception {
        expressao.setExpressaoStr(expressaoStr);
    }

    public void setVar(String varName, Double valor) {
        mapaVariaveis.setVar(varName, valor);
    }

    public Memento createMemento() throws CloneNotSupportedException {
        MementoMediador m = new MementoMediador();
        m.expressao = expressao.clone();
        m.mapaVariaveis = mapaVariaveis.clone();
        return m;
    }

    public void setMemento(Memento m) throws ClassCastException {
        expressao = ((MementoMediador) m).expressao;
        mapaVariaveis = ((MementoMediador) m).mapaVariaveis;
    }
}
