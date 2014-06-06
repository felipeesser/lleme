package provas.s20141.p320141;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RestaUm {

  private static int[][] tabuleiro = {{9, 9, 9, 1, 1, 1, 9, 9, 9},
    {9, 9, 9, 1, 1, 1, 9, 9, 9},
    {9, 9, 9, 1, 1, 1, 9, 9, 9},
    {1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1},
    {9, 9, 9, 1, 1, 1, 9, 9, 9},
    {9, 9, 9, 1, 1, 1, 9, 9, 9},
    {9, 9, 9, 1, 1, 1, 9, 9, 9}};
//  private static int[][] tabuleiro = {
//    {9, 9, 1, 9, 9},
//    {9, 1, 1, 1, 9},
//    {1, 1, 0, 1, 1},
//    {9, 1, 1, 1, 9},
//    {9, 9, 1, 9, 9}};

  public static void main(String[] args) {
    Stack<Movimento> movmentos = new Stack();
    backtracking(movmentos);
  }

  private static void backtracking(Stack<Movimento> movimentos) {
    if (isSolution(movimentos)) {
      imprimirTab(tabuleiro);
      processSolution(movimentos);
    } else {
      List<Movimento> cand = generateCand(movimentos);
      Collections.shuffle(cand);
      for (Movimento m : cand) {
        movimentos.push(m);
        aplicar(m, tabuleiro);
        if (!impossivel(m.b, tabuleiro) && !impossivelEmTorno(m.a, tabuleiro))
          backtracking(movimentos);
        desaplicar(m, tabuleiro);
        movimentos.pop();
      }
//      if (cand.isEmpty()){
//        imprimirTab(tabuleiro);
//        processSolution(movimentos);
//      }
    }
  }

  private static boolean isSolution(Stack<Movimento> movimentos) {
    try {
      int[][] tab = tabuleiro;
      //aplicar(movimentos, tab);

      int cont = 0;
      for (int i = 0; i < tab.length; i++)
        for (int j = 0; j < tab.length; j++)
          if (tab[i][j] == 1)
            cont++;
      if (cont > 1)
        return false;
      return true;

    } catch (Throwable e) {
      return false;
    }
  }

  private static void processSolution(Stack<Movimento> movimentos) {
    for (Movimento m : movimentos)
      System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")");
  }

  private static List<Movimento> generateCand(Stack<Movimento> movimentos) {
    int k, l, m, n;
    int[][] tab = tabuleiro;
    //aplicar(movimentos, tab);
    List<Movimento> cand = new ArrayList<>();

    for (int i = 0; i < tab.length; i++)
      for (int j = 0; j < tab[0].length; j++)
        if (tab[i][j] == 0) {
          k = i - 2;
          l = j;
          m = i - 1;
          n = j;
          if (k >= 0 && k < tab.length && l >= 0 && l < tab[0].length
                  && tab[m][n] == 1 && tab[k][l] == 1)
            cand.add(new Movimento(new Pos(k, l), new Pos(i, j)));
          k = i;
          l = j - 2;
          m = i;
          n = j - 1;
          if (k >= 0 && k < tab.length && l >= 0 && l < tab[0].length
                  && tab[m][n] == 1 && tab[k][l] == 1)
            cand.add(new Movimento(new Pos(k, l), new Pos(i, j)));
          k = i + 2;
          l = j;
          m = i + 1;
          n = j;
          if (k >= 0 && k < tab.length && l >= 0 && l < tab[0].length
                  && tab[m][n] == 1 && tab[k][l] == 1)
            cand.add(new Movimento(new Pos(k, l), new Pos(i, j)));
          k = i;
          l = j + 2;
          m = i;
          n = j + 1;
          if (k >= 0 && k < tab.length && l >= 0 && l < tab[0].length
                  && tab[m][n] == 1 && tab[k][l] == 1)
            cand.add(new Movimento(new Pos(k, l), new Pos(i, j)));
        }

    return cand;
  }

  private static void aplicar(Movimento m, int[][] tabuleiro) {
    if (isValidMov(m, tabuleiro)) {
      tabuleiro[m.a.i][m.a.j] = 0;
      tabuleiro[m.b.i][m.b.j] = 1;
      tabuleiro[(m.a.i + m.b.i) / 2][(m.a.j + m.b.j) / 2] = 0;
    } else {
      System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")");
      imprimirTab(tabuleiro);
      throw new IllegalArgumentException();
    }
  }

  private static void desaplicar(Movimento m, int[][] tabuleiro) {
    if (isValidRev(m, tabuleiro)) {
      tabuleiro[m.a.i][m.a.j] = 1;
      tabuleiro[m.b.i][m.b.j] = 0;
      tabuleiro[(m.a.i + m.b.i) / 2][(m.a.j + m.b.j) / 2] = 1;
    } else {
      System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")");
      imprimirTab(tabuleiro);
      throw new IllegalArgumentException();
    }
  }

  private static boolean isValidMov(Movimento m, int[][] tab) {
    if (m.a.i >= 0 && m.a.j < tab[0].length
            && m.b.i >= 0 && m.b.j < tab[0].length
            && Math.abs(m.a.i - m.b.i) <= 2
            && Math.abs(m.a.j - m.b.j) <= 2
            && (Math.abs(m.a.i - m.b.i) == 2
            || Math.abs(m.a.j - m.b.j) == 2)
            && tab[m.a.i][m.a.j] == 1
            && tab[(m.a.i + m.b.i) / 2][(m.a.j + m.b.j) / 2] == 1
            && tab[m.b.i][m.b.j] == 0)
      return true;
    return false;
  }

  private static boolean isValidRev(Movimento m, int[][] tab) {
    if (m.a.i >= 0 && m.a.j < tab[0].length
            && m.b.i >= 0 && m.b.j < tab[0].length
            && Math.abs(m.a.i - m.b.i) <= 2
            && Math.abs(m.a.j - m.b.j) <= 2
            && (Math.abs(m.a.i - m.b.i) == 2
            || Math.abs(m.a.j - m.b.j) == 2)
            && tab[m.a.i][m.a.j] == 0
            && tab[(m.a.i + m.b.i) / 2][(m.a.j + m.b.j) / 2] == 0
            && tab[m.b.i][m.b.j] == 1)
      return true;
    return false;
  }

  private static boolean impossivel(Pos p, int[][] tabuleiro) {
    if (tabuleiro[p.i][p.j] == 1 && !contemUmEmTorno(p, tabuleiro))
      return true;
    return false;
  }

  private static boolean impossivelEmTorno(Pos p, int[][] tabuleiro) {
    List<Pos> ps = new ArrayList<>();
    ps.add(new Pos(p.i - 1, p.j));
    ps.add(new Pos(p.i, p.j - 1));
    ps.add(new Pos(p.i + 1, p.j));
    ps.add(new Pos(p.i, p.j + 1));

    for (Pos pe : ps)
      if (tabuleiro[p.i][p.j] == 0 && pe.i >= 0 && pe.i < tabuleiro.length && pe.j >= 0 && pe.j < tabuleiro[0].length
              && !(pe.i == p.i && pe.j == p.j) && !contemUmEmTorno(new Pos(pe.i, pe.j), tabuleiro))
        return true;

    return false;
  }

  private static boolean contemUmEmTorno(Pos p, int[][] tabuleiro) {
    List<Pos> ps = new ArrayList<>();
    ps.add(new Pos(p.i - 1, p.j));
    ps.add(new Pos(p.i, p.j - 1));
    ps.add(new Pos(p.i + 1, p.j));
    ps.add(new Pos(p.i, p.j + 1));

    for (Pos pe : ps)
      if (pe.i >= 0 && pe.i < tabuleiro.length && pe.j >= 0 && pe.j < tabuleiro[0].length
              && !(pe.i == p.i && pe.j == p.j) && tabuleiro[pe.i][pe.j] == 1)
        return true;
    return false;
  }

  private static void imprimirTab(int[][] tab) {
    for (int i = 0; i < tab.length; i++) {
      for (int j = 0; j < tab.length; j++)
        System.out.print(tab[i][j] + " ");
      System.out.println("");
    }
  }

  private static int[][] copy(int[][] tabuleiro) {
    int[][] tab = new int[tabuleiro.length][tabuleiro[0].length];
    for (int i = 0; i < tab.length; i++)
      System.arraycopy(tabuleiro[i], 0, tab[i], 0, tab.length);
    return tab;
  }

  private static void aplicar(Stack<Movimento> movimentos, int[][] tabuleiro) {
    for (Movimento m : movimentos)
      if (isValidMov(m, tabuleiro)) {
        tabuleiro[m.a.i][m.a.j] = 0;
        tabuleiro[m.b.i][m.b.j] = 1;
        tabuleiro[(m.a.i + m.b.i) / 2][(m.a.j + m.b.j) / 2] = 0;
      } else {
        System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")");
        imprimirTab(tabuleiro);
        throw new IllegalArgumentException();
      }
  }
}