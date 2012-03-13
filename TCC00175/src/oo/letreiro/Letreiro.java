package oo.letreiro;

public class Letreiro {

    final public Display[] caracteres = new Display[5];

    public Letreiro(String mensagem) {
        for (int i = 0; i < 5 || i < mensagem.length(); i++)
            this.caracteres[i] = new Display(mensagem.charAt(i));
    }

    public void escreve() {
        for (byte i = 1; i <= 7; i++) {
            for (Display caractere : caracteres)
                caractere.escreve(i);
            System.out.println("");
        }

    }
}
