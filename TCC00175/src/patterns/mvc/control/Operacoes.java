package patterns.mvc.control;

import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import patterns.command.calculadora.AlterarExpressao;
import patterns.command.calculadora.AlterarVariavel;
import patterns.command.calculadora.Command;
import patterns.mediator.MediadorDeAlteracao;

public class Operacoes {

    private MediadorDeAlteracao mediador = null;
    private Stack<Command> comandos = new Stack<>();

    public Operacoes() {
        mediador = new MediadorDeAlteracao();
        mediador.expressao = mediador.getEditorExpressao();
        mediador.mapaVariaveis = mediador.getEditorVariaveis();
    }

    public Map<String, Double> alterarExpressao(String expressao) {
        try {
            Command cmd = new AlterarExpressao(expressao, mediador);
            comandos.push(cmd);
            cmd.execute();
            this.mediador.setExpressaoStr(expressao);
        } catch (Exception ex) {
            Logger.getLogger(Operacoes.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return mediador.mapaVariaveis.listVars();
    }

    public void alterarVariavel(String variavel, Double valor) throws CloneNotSupportedException, Exception {
        Command cmd = new AlterarVariavel(variavel, valor, mediador);
        comandos.push(cmd);
        cmd.execute();
    }

    public Double getResultado() {
        return mediador.expressao.getResultado();
    }
    
    public void desfazer(){
        comandos.pop().desfazer();
    }
    //    private void alterarVariaveis(Map<String, Double> variaveis) {
    //        for (String var : variaveis.keySet())
    //            alterarVariavel(var, variaveis.get(var));
    //    }
}
