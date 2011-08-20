/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina;

/**
 *
 * @author Luiz Leme
 */
public class Avaliacao {
    private float notaTrab, notaP3;
    private int matricula;
    
    public Avaliacao(float nt, float np3, int m){
        this.notaTrab  = nt;
        this.notaP3    = np3;
        this.matricula = m;
    }

    public void setNotaP3(float notaP3) {
        this.notaP3 = notaP3;
    }

    public void setNotaTrab(float notaTrab) {
        this.notaTrab = notaTrab;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    
    public float getNotaP3() {
        return notaP3;
    }

    public float getNotaTrab() {
        return notaTrab;
    }
}
