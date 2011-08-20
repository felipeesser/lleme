/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina;

/**
 *
 * @author Luiz Leme
 */
public class Disciplina {
    public Avaliacao[] colecao = new Avaliacao[10];
    
    public Disciplina(){
        
    }
    
    public Avaliacao buscaAvaliacao(int matricula){
        for(Avaliacao avaliacao:colecao){
            if(avaliacao.getMatricula() == matricula){
                return avaliacao;
            }
        }
        return null;
    }  
    
    public void carregaAvaliacoes(String notasT, String notasP3){
        
    }
}
