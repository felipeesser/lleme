package provas.s20141.p320141;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RestaUm {

//    private static int[][] tabuleiro = {{9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {1, 1, 1, 1, 1, 1, 1, 1, 1},
//    {1, 1, 1, 1, 0, 1, 1, 1, 1},
//    {1, 1, 1, 1, 1, 1, 1, 1, 1},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9}};
    private static int[][] tabuleiro = {
        {9, 1, 1, 1, 9},
        {1, 1, 1, 1, 1},
        {1, 1, 0, 1, 1},
        {1, 1, 1, 1, 1},
        {9, 1, 1, 1, 9}};
    private static Set<Pos> uns = new HashSet();

    public static void main(String[] args) {

        for (int i = 0; i < tabuleiro.length; i++)
            for (int j = 0; j < tabuleiro[0].length; j++)
                if (tabuleiro[i][j] == 1)
                    uns.add(new Pos(i, j));

        backtracking(new Stack(), tabuleiro, uns);

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
                aplicarMov(m, tabuleiro, uns);
                //imprimirTab(tab);
                backtracking(movimentos, tab, uns);
                desaplicarMov(m, tabuleiro, uns);
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
        int k, l;
        List<Movimento> cand = new ArrayList();

        for (Pos pu : uns) {
            k = pu.i;
            l = pu.j + 2;
            Movimento mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv, tab))
                cand.add(mv);
            k = pu.i - 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv, tab))
                cand.add(mv);
            k = pu.i;
            l = pu.j - 2;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv, tab))
                cand.add(mv);
            k = pu.i + 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv, tab))
                cand.add(mv);
        }

        return cand;
    }

    private static void aplicarMov(Movimento mv, int[][] tab, Set<Pos> uns) {
        if (mv != null && tab != null && eValidoMov(mv, tab)) {
            tab[mv.a.i][mv.a.j] = 0;
            tab[mv.m.i][mv.m.j] = 0;
            tab[mv.b.i][mv.b.j] = 1;
            uns.remove(mv.a);
            uns.remove(mv.m);
            uns.add(mv.b);
        } else {
            System.out.println("(" + mv.a.i + "," + mv.a.j + ")-->(" + mv.b.i + "," + mv.b.j + ")");
            imprimirTab(tab);
            throw new IllegalArgumentException();
        }
    }

    private static void desaplicarMov(Movimento mv, int[][] tab, Set<Pos> uns) {
        if (mv != null && tab != null && eValidoRev(mv, tab)) {
            tab[mv.a.i][mv.a.j] = 1;
            tab[mv.m.i][mv.m.j] = 1;
            tab[mv.b.i][mv.b.j] = 0;
            uns.add(mv.a);
            uns.add(mv.m);
            uns.remove(mv.b);
        } else {
            System.out.println("(" + mv.a.i + "," + mv.a.j + ")-->(" + mv.b.i + "," + mv.b.j + ")");
            imprimirTab(tab);
            throw new IllegalArgumentException();
        }
    }

    private static boolean eValidoMov(Movimento mv, int[][] tab) {
        if (mv != null && tab != null)
            if (mv.a.i >= 0 && mv.a.i < tab.length
              && mv.a.j >= 0 && mv.a.j < tab[0].length
              && mv.b.i >= 0 && mv.b.i < tab.length
              && mv.b.j >= 0 && mv.b.j < tab[0].length
              && Math.abs(mv.a.i - mv.b.i) <= 2
              && Math.abs(mv.a.j - mv.b.j) <= 2
              && (Math.abs(mv.a.i - mv.b.i) == 2 || Math.abs(mv.a.j - mv.b.j) == 2)
              && tab[mv.a.i][mv.a.j] == 1
              && tab[mv.m.i][mv.m.j] == 1
              && tab[mv.b.i][mv.b.j] == 0)
                return true;
        return false;
    }

    private static boolean eValidoRev(Movimento mv, int[][] tab) {
        if (mv != null && tab != null)
            if (mv.a.i >= 0 && mv.a.i < tab.length
              && mv.a.j >= 0 && mv.a.j < tab[0].length
              && mv.b.i >= 0 && mv.b.i < tab.length
              && mv.b.j >= 0 && mv.b.j < tab[0].length
              && Math.abs(mv.a.i - mv.b.i) <= 2
              && Math.abs(mv.a.j - mv.b.j) <= 2
              && (Math.abs(mv.a.i - mv.b.i) == 2 || Math.abs(mv.a.j - mv.b.j) == 2)
              && tab[mv.a.i][mv.a.j] == 0
              && tab[mv.m.i][mv.m.j] == 0
              && tab[mv.b.i][mv.b.j] == 1)
                return true;
        return false;
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
