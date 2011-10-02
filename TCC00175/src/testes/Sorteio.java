package testes;

import java.util.ArrayList;
import java.util.List;

public class Sorteio {

    public static String[][] alunos = {{"1", "GUILHERME RANGEL FERREIRA"},
        {"1", "PEDRO HENRIQUE RIBEIRO DA SILVA"},
        {"1", "RAFAEL BRAGA MORETT"},
        {"1", "ROBERTO SAMPAIO"},
        {"2", "CINTHYA DE MELO FRANCA"},
        {"2", "DEBORAH SERPA JAEGGE DECCACHE"},
        {"2", "RAFAEL MARTINS FERREIRA"},
        {"2", "RAPHAEL DOTTAVIO BOTTINO"},
        {"3", "GUILHERME ROLIM E SOUZA"},
        {"3", "MATEUS CARVALHO AZIS"},
        {"3", "PEDRO ARAUJO YUSIM"},
        {"4", "JOAO FELIPE NICOLACI PIMENTEL"},
        {"4", "LUCAS DE SOUSA NADALUTTI"},
        {"4", "LUIS ANTONIO VIEIRA JUNIOR"},
        {"4", "RODRIGO CASTRO AZEVEDO"},
        {"5", "HUDSON GOMES DA SILVA"},
        {"5", "PEDRO VITOR PEDROZA FREITAS"},
        {"5", "RAFAEL ALMEIDA DE CARVALHO"},
        {"6", "JULIANA SANTIAGO HERCULANO"},
        {"6", "LUCAS CARREIRO PINHEIRO"},
        {"6", "PHILIPE DE ALMEIDA ARAUJO"},
        {"6", "PRISCILLA MAFRA DE CARVALHO MARQUES"},
        {"6", "RONALD CHIESSE DE SOUZA"},
        {"6", "WLADIMIR LIVOLIS DE ALCANTARA CABRAL"},
        {"7", "ALEXANDRE DA SILVA ABREU"},
        {"7", "ANA PAULA LIMA LUCAS"},
        {"7", "CLOVIS PINHEIRO DE OLIVEIRA"},
        {"7", "DANIEL TAMAKI BATISTA"}};
    public static String[] apresentacoes = {"01/11/2011", "01/11/2011",
        "03/11/2011", "03/11/2011", "08/11/2011", "08/11/2011",
        "10/11/2011", "10/11/2011", "17/11/2011", "17/11/2011",
        "24/11/2011", "24/11/2011"};
    public static List<Integer> grupos = new ArrayList<Integer>();

    public static void main(String[] args) {
        grupos.add(1);
        grupos.add(2);
        grupos.add(3);
        grupos.add(4);
        grupos.add(5);
        grupos.add(6);
        grupos.add(7);
        int grupo;
        for (int i = 0; i < 7; i++) {
            System.out.println("Apresentacao do dia " + apresentacoes[11 - i]);
            grupo = sorteio(grupos);
            System.out.println("\tGrupo " + grupo);
            imprimeGrupo(grupo);
            System.out.println("");

        }
    }

    public static void imprimeGrupo(int grupo) {
        for (String[] aluno : alunos)
            if (aluno[0].equals("" + grupo))
                System.out.println("\t\t" + aluno[1]);
    }

    public static int sorteio(List<Integer> grupos) {
        Math.random();
        int numero = (int) (Math.random() * grupos.size());
        if (numero == 8)
            numero = 7;
        return grupos.remove(numero);
    }
}
