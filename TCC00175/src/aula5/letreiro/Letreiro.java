package aula5.letreiro;

public class Letreiro {

    final public Caractere[] mensagem = new Caractere[5];

    public Letreiro(String mensagem) {
        for (int i = 0; i < 5 || i < mensagem.length(); i++)
            this.mensagem[i] = new Caractere(mensagem.charAt(i));
    }

    public void escreve() {
        for (byte i = 1; i <= 7; i++){
            for (Caractere caractere : mensagem)
                caractere.escreve(i);
            System.out.println("");
        }
                
    }
}
