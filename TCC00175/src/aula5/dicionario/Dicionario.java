package aula5.dicionario;

import java.util.Collection;
import java.util.Scanner;

public class Dicionario {
    /**
     * @associates <{aula5.dicionario.Entrada}>
     */
    String[] palavras;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
        String[] segmentos = entrada.split(">>");
        while (segmentos[0]!="sair"){
          
        }
    }

    public static void main(Collection args) {
    }

    public String consultar(String vocabulo) {
        return null;
    }

    public boolean excluir(String vocabulo) {
        return false;
    }

    public boolean incluir(String vocabulo, String significado) {
        return false;
    }
}
