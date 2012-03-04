package patterns.mvc.control;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import patterns.mediator.EditorExpressao;
import patterns.mediator.EditorVariaveis;
import patterns.mediator.MediadorCalculo;

public class Operacoes {

    public EditorExpressao editorExpressao = null;
    public EditorVariaveis editorVariaveis = null;

    public Operacoes() {
        MediadorCalculo med = new MediadorCalculo();
        editorExpressao = med.getEditorExpressao();
        editorVariaveis = med.getEditorVariaveis();
    }

    public Map<String, Double> alterarExpressao(String expressao) {
        try {
            editorExpressao.setExpressaoStr(expressao);
        } catch (Exception ex) {
            Logger.getLogger(Operacoes.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return editorVariaveis.listVars();
    }

    public Double getResultado() {
        return editorExpressao.getResultado();
    }

    public void alterarVariaveis(Map<String, Double> variaveis) {
        for (String var : variaveis.keySet())
            alterarVariavel(var, variaveis.get(var));
    }

    public void alterarVariavel(String variavel, Double valor) {
        editorVariaveis.setVar(variavel, valor);
    }
}
