package provas.s20141.p320141;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tabuleiro {

    private static Set<Pos> uns = new HashSet();
    private static Tabuleiro tab = null;
    //    private static int[][] tabuleiro = {{9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {1, 1, 1, 1, 1, 1, 1, 1, 1},
//    {1, 1, 1, 1, 0, 1, 1, 1, 1},
//    {1, 1, 1, 1, 1, 1, 1, 1, 1},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9},
//    {9, 9, 9, 1, 1, 1, 9, 9, 9}};
    private static int[][] estado = {
        {9, 1, 1, 1, 9},
        {1, 1, 1, 1, 1},
        {1, 1, 0, 1, 1},
        {1, 1, 1, 1, 1},
        {9, 1, 1, 1, 9}};

    static void aplicarMov(Movimento mv, int[][] tab, Set<Pos> uns) {
        if (mv
            != null
            && tab
            != null
            && eValidoMov(mv,
            tab)) {
            tab[mv.a.i][mv.a.j] = 0;
            tab[mv.m.i][mv.m.j] = 0;
            tab[mv.b.i][mv.b.j] = 1;
            uns.remove(mv.a);
            uns.remove(mv.m);
            uns.add(mv.b);
        } else {
            System.out.println("("
                + mv.a.i
                + ","
                + mv.a.j
                + ")-->("
                + mv.b.i
                + ","
                + mv.b.j
                + ")");
            throw new IllegalArgumentException();
        }
    }

    static List movimentosPossiveis(Set<Pos> uns, int[][] tab) {
        int k;
        int l;
        List<Movimento> cand = new ArrayList();
        for (Pos pu : uns) {
            k = pu.i;
            l = pu.j
                + 2;
            Movimento mv = new Movimento(new Pos(pu.i,
                pu.j),
                new Pos(k,
                l));
            if (eValidoMov(mv,
                tab))
                cand.add(mv);
            k = pu.i
                - 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i,
                pu.j),
                new Pos(k,
                l));
            if (eValidoMov(mv,
                tab))
                cand.add(mv);
            k = pu.i;
            l = pu.j
                - 2;
            mv = new Movimento(new Pos(pu.i,
                pu.j),
                new Pos(k,
                l));
            if (eValidoMov(mv,
                tab))
                cand.add(mv);
            k = pu.i
                + 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i,
                pu.j),
                new Pos(k,
                l));
            if (eValidoMov(mv,
                tab))
                cand.add(mv);
        }
        return cand;
    }

    private static boolean eValidoRev(Movimento mv, int[][] tab) {
        if (mv
            != null
            && tab
            != null)
            if (mv.a.i
                >= 0
                && mv.a.i
                < tab.length
                && mv.a.j
                >= 0
                && mv.a.j
                < tab[0].length
                && mv.b.i
                >= 0
                && mv.b.i
                < tab.length
                && mv.b.j
                >= 0
                && mv.b.j
                < tab[0].length
                && Math.abs(mv.a.i
                - mv.b.i)
                <= 2
                && Math.abs(mv.a.j
                - mv.b.j)
                <= 2
                && (Math.abs(mv.a.i
                - mv.b.i)
                == 2
                || Math.abs(mv.a.j
                - mv.b.j)
                == 2)
                && tab[mv.a.i][mv.a.j]
                == 0
                && tab[mv.m.i][mv.m.j]
                == 0
                && tab[mv.b.i][mv.b.j]
                == 1)
                return true;
        return false;
    }

    static void desaplicarMov(Movimento mv, int[][] tab, Set<Pos> uns) {
        if (mv
            != null
            && tab
            != null
            && eValidoRev(mv,
            tab)) {
            tab[mv.a.i][mv.a.j] = 1;
            tab[mv.m.i][mv.m.j] = 1;
            tab[mv.b.i][mv.b.j] = 0;
            uns.add(mv.a);
            uns.add(mv.m);
            uns.remove(mv.b);
        } else {
            System.out.println("("
                + mv.a.i
                + ","
                + mv.a.j
                + ")-->("
                + mv.b.i
                + ","
                + mv.b.j
                + ")");
            throw new IllegalArgumentException();
        }
    }

    private static boolean eValidoMov(Movimento mv, int[][] tab) {
        if (mv
            != null
            && tab
            != null)
            if (mv.a.i
                >= 0
                && mv.a.i
                < tab.length
                && mv.a.j
                >= 0
                && mv.a.j
                < tab[0].length
                && mv.b.i
                >= 0
                && mv.b.i
                < tab.length
                && mv.b.j
                >= 0
                && mv.b.j
                < tab[0].length
                && Math.abs(mv.a.i
                - mv.b.i)
                <= 2
                && Math.abs(mv.a.j
                - mv.b.j)
                <= 2
                && (Math.abs(mv.a.i
                - mv.b.i)
                == 2
                || Math.abs(mv.a.j
                - mv.b.j)
                == 2)
                && tab[mv.a.i][mv.a.j]
                == 1
                && tab[mv.m.i][mv.m.j]
                == 1
                && tab[mv.b.i][mv.b.j]
                == 0)
                return true;
        return false;
    }

    private Tabuleiro() {
        for (int i = 0; i
            < estado.length; i++)
            for (int j = 0; j
                < estado[0].length; j++)
                if (estado[i][j]
                    == 1)
                    uns.add(new Pos(i,
                        j));
    }

    public static Tabuleiro obterInstancia() {
        if (tab
            == null)
            tab = new Tabuleiro();
        return tab;
    }

    public int[][] obterEstado() {
        return estado;
    }

    public Set<Pos> obterUns() {
        return uns;
    }
}
