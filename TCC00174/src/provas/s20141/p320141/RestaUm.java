package provas.s20141.p320141;

import java.util.ArrayList;
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
    {9, 9, 9, 1, 1, 1, 9, 9, 9},};

  public static void main(String[] args) {
    Stack<Movimento> movmentos = new Stack();
    backtracking(movmentos);
  }

  private static boolean isSolution(Stack<Movimento> movimentos) {
    try {
      int[][] tab = tabuleiro.clone();
      aplicar(movimentos, tab);

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
      System.out.println("(" + m.a.linha + "," + m.a.coluna + ")-->(" + m.b.linha + "," + m.b.coluna + ")");
  }

  private static List<Movimento> generateCand(Stack<Movimento> movimentos) {
    int k, l, m, n;
    int[][] tab = tabuleiro.clone();
    aplicar(movimentos, tab);
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

  private static void backtracking(Stack<Movimento> movimentos) {
    if (isSolution(movimentos))
      processSolution(movimentos);
    else {
      List<Movimento> cand = generateCand(movimentos);
      for (Movimento m : cand) {
        movimentos.push(m);
        backtracking(movimentos);
        movimentos.pop();
      }
    }
  }

  private static void aplicar(Stack<Movimento> movimentos, int[][] tab) {
    for (Movimento m : movimentos)
      if (isValid(m, tab)) {
        tab[m.a.linha][m.a.coluna] = 0;
        tab[m.b.linha][m.b.coluna] = 1;
        tab[(m.a.linha + m.b.linha) / 2][(m.a.coluna + m.b.coluna) / 2] = 0;
      } else {
        System.out.println("(" + m.a.linha + "," + m.a.coluna + ")-->(" + m.b.linha + "," + m.b.coluna + ")");
        imprimirTab(tab);
        throw new IllegalArgumentException();
      }
  }

  private static boolean isValid(Movimento m, int[][] tab) {
    if (m.a.linha >= 0 && m.a.coluna < tab[0].length
            && m.b.linha >= 0 && m.b.coluna < tab[0].length
            && Math.abs(m.a.linha - m.b.linha) <= 2
            && Math.abs(m.a.coluna - m.b.coluna) <= 2
            && (Math.abs(m.a.linha - m.b.linha) == 2
            || Math.abs(m.a.coluna - m.b.coluna) == 2)
            && tab[m.a.linha][m.a.coluna] == 1
            && tab[(m.a.linha + m.b.linha) / 2][(m.a.coluna + m.b.coluna) / 2] == 1
            && tab[m.b.linha][m.b.coluna] == 0)
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
}
