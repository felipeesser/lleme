package provas.s20141.p320141;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public static void main(String[] args) {

        backtracking(new Stack(), tabuleiro);

    }

    private static void backtracking(Stack<Movimento> movimentos, int[][] tab) {
        if (eSol(tab)) {
            imprimirTab(tab);
            processarSol(movimentos);
        } else {
            List<Movimento> cand = gerarCand(tab);
            Collections.shuffle(cand);
            for (Movimento m : cand) {
                movimentos.push(m);
                aplicar(m, tabuleiro);
                backtracking(movimentos, tab);
                desaplicar(m, tabuleiro);
                movimentos.pop();
            }
        }
    }

    private static boolean eSol(int[][] tab) {
        int cont = 0;
        for (int[] tab1 : tab)
            for (int j = 0; j < tab.length; j++)
                if (tab1[j] == 1)
                    cont++;
        return cont == 1;
    }

    private static void processarSol(Stack<Movimento> movimentos) {
        for (Movimento m : movimentos)
            System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")\n");
    }

    private static List<Movimento> gerarCand(int[][] tab) {
        int k, l, m, n;
        List<Movimento> cand = new ArrayList();

        for (int i = 0; i < tab.length; i++)
            for (int j = 0; j < tab[0].length; j++)
                if (tab[i][j] == 0) {
                    k = i - 2;
                    l = j;
                    m = i - 1;
                    n = j;
                    Movimento mv = new Movimento(new Pos(k, l), new Pos(i, j));
                    if (eValidoMov(mv, tab))
                        cand.add(mv);

                    k = i;
                    l = j - 2;
                    m = i;
                    n = j - 1;
                    mv = new Movimento(new Pos(k, l), new Pos(i, j));
                    if (eValidoMov(mv, tab))
                        cand.add(mv);

                    k = i + 2;
                    l = j;
                    m = i + 1;
                    n = j;
                    mv = new Movimento(new Pos(k, l), new Pos(i, j));
                    if (eValidoMov(mv, tab))
                        cand.add(mv);

                    k = i;
                    l = j + 2;
                    m = i;
                    n = j + 1;
                    mv = new Movimento(new Pos(k, l), new Pos(i, j));
                    if (eValidoMov(mv, tab))
                        cand.add(mv);
                }

        return cand;
    }

    private static void aplicar(Movimento mv, int[][] tab) {
        if (mv != null && tab != null && eValidoMov(mv, tab)) {
            tab[mv.a.i][mv.a.j] = 0;
            tab[mv.m.i][mv.m.j] = 0;
            tab[mv.b.i][mv.b.j] = 1;
        } else {
            System.out.println("(" + mv.a.i + "," + mv.a.j + ")-->(" + mv.b.i + "," + mv.b.j + ")");
            imprimirTab(tab);
            throw new IllegalArgumentException();
        }
    }

    private static void desaplicar(Movimento mv, int[][] tab) {
        if (mv != null && tab != null && eValidoRev(mv, tab)) {
            tab[mv.a.i][mv.a.j] = 1;
            tab[mv.m.i][mv.m.j] = 1;
            tab[mv.b.i][mv.b.j] = 0;
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
            for (int[] tab1 : tab) {
                for (int j = 0; j < tab.length; j++)
                    System.out.print(tab1[j] + " ");
                System.out.println("");
            }
        System.out.println("");
    }

}
