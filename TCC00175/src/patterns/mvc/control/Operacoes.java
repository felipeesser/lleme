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

    public Map<String,Double> alterarExpressao(String expressao) {
        try {
            editorExpressao.setExpressaoStr(expressao);
            return editorVariaveis.getVars();
        } catch (Exception ex) {
            Logger.getLogger(Operacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void alterarVariavvel(String variavel, Double valor){
        editorVariaveis.setVar(variavel, valor);
    }
}
