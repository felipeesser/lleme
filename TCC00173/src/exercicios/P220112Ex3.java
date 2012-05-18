package exercicios;

public class P220112Ex3 {

    public static void main(String[] args) {
        String s = "abcd";
        permutar(s, 0);

    }

    public static void permutar(String texto, int pos) {
        if (pos < texto.length())
            for (int i = pos; i < texto.length(); i++) {
                texto = trocaCaractere(texto, pos, i);
                permutar(texto, pos + 1);
            }
        else
            System.out.println(texto);
    }

    public static String trocaCaractere(String texto, int pos1, int pos2) {
        char[] str = texto.toCharArray();
        char ch = str[pos1];
        str[pos1] = str[pos2];
        str[pos2] = ch;
        return String.copyValueOf(str);
    }
}
