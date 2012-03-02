package patterns.mvc.control;

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
        editorExpressao = new EditorExpressao(med);
        editorVariaveis = new EditorVariaveis(med);
    }

    public void alterarExpressao(String expressao) {
        try {
            editorExpressao.setExpressaoStr(expressao);
            for (String var: editorVariaveis.listVarsNames()){
                
            }
        } catch (Exception ex) {
            Logger.getLogger(Operacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterarVariavvel(String variavel, Double valor){
        editorVariaveis.setVar(variavel, valor);
    }
}
