package provas.s20141.p320141;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RestaUm {

    public static void main(String[] args) {

        Tabuleiro tab = Tabuleiro.obterInstancia();

        backtracking(new Stack(), tab.obterEstado(), tab.obterUns());

    }

    private static void backtracking(Stack<Movimento> movimentos, int[][] tab, Set<Pos> uns) {
        if (eSol(tab, uns)) {
            imprimirTab(tab);
            processarSol(movimentos);
        } else {
            List<Movimento> cand = gerarCand(tab, uns);
            //Collections.shuffle(cand);
            for (Movimento m : cand) {
                movimentos.push(m);
                Tabuleiro.aplicarMov(m, tab, uns);
                //imprimirTab(tab);
                backtracking(movimentos, tab, uns);
                Tabuleiro.desaplicarMov(m, tab, uns);
                movimentos.pop();
            }
            //if (cand.isEmpty()) {
            //imprimirTab(tab);
            //processarSol(movimentos);
            //System.out.print("*** FIM ***\n\n");
            //}
        }
    }

    private static boolean eSol(int[][] tab, Set<Pos> uns) {
//        int contUm = 0;
//        for (int[] linha : tab)
//            for (int j = 0; j < linha.length; j++)
//                if (linha[j] == 1)
//                    contUm++;
//        return contUm == 1;
        return uns.size() == 1;
    }

    private static void processarSol(Stack<Movimento> movimentos) {
        for (Movimento m : movimentos)
            System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")\n");
    }

    private static List<Movimento> gerarCand(int[][] tab, Set<Pos> uns) {
        List<Movimento> cand = Tabuleiro.movimentosPossiveis(uns, tab);

        return cand;
    }

    private static void imprimirTab(int[][] tab) {
        if (tab != null)
            for (int[] linha : tab) {
                for (int j = 0; j < linha.length; j++)
                    System.out.print(linha[j] + " ");
                System.out.println("");
            }
        System.out.println("");
    }

}
