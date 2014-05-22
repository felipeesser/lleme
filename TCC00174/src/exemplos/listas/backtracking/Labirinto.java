package exemplos.listas.backtracking;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Labirinto {

  private static boolean finished = false; /* Todas soluções encontradas? */

  private static int[][] labirinto = {{0, 1, 0, 0, 0},
    {0, 1, 0, 1, 0},
    {0, 0, 0, 1, 9},
    {0, 1, 0, 1, 1},
    {0, 1, 0, 0, 0}};

  public static void main(String[] args) {
    Stack<Movimentacao> sol = new Stack<>();
    Posicao inicio = new Posicao(4, 0);
    labirinto[4][0] = 2;

    backtrack(sol, inicio);
  }

  public static void backtrack(Stack<Movimentacao> sol, Posicao pos) {
    Posicao dest = null;
    if (isSolution(sol)) {
      processSolution(sol);
      dest = sol.pop().a;
      labirinto[dest.linha][dest.coluna] = 0;
    } else {

      List<Movimentacao> c = constructCandidates(sol, pos);

      for (Movimentacao mov : c) {
        sol.push(mov);
        dest = new Posicao(mov.b.linha, mov.b.coluna);
        labirinto[dest.linha][dest.coluna] = 2;
        backtrack(sol, dest);
        dest = sol.pop().a;
        labirinto[dest.linha][dest.coluna] = 0;
      }
    }
  }

  public static boolean isSolution(final Stack<Movimentacao> sol) {
    try {
      Movimentacao mov = sol.peek();
      if (labirinto[mov.b.linha][mov.b.coluna] == 9)
        return true;
    } catch (EmptyStackException e) {
    }
    return false;
  }

  public static void processSolution(final Stack<Movimentacao> a) {
    for (Movimentacao mov : a)
      System.out.println("(" + mov.a.linha + "," + mov.a.coluna + ")-->(" + mov.b.linha + "," + mov.b.coluna + ")");
    System.out.println("---\n");
  }

  public static List<Movimentacao> constructCandidates(final Stack<Movimentacao> sol, Posicao a) {
    List<Movimentacao> cand = new ArrayList();

    Posicao b1 = new Posicao(a.linha + 1, a.coluna);
    if (eValido(b1))
      cand.add(new Movimentacao(a, b1));
    Posicao b2 = new Posicao(a.linha, a.coluna + 1);
    if (eValido(b2))
      cand.add(new Movimentacao(a, b2));
    Posicao b3 = new Posicao(a.linha - 1, a.coluna);
    if (eValido(b3))
      cand.add(new Movimentacao(a, b3));
    Posicao b4 = new Posicao(a.linha, a.coluna - 1);
    if (eValido(b4))
      cand.add(new Movimentacao(a, b4));

    return cand;
  }

  private static boolean estaEm(int[] a, int n) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == n)
        return true;
    return false;
  }

  private static boolean eValido(Posicao pos) {
    if (pos.linha >= 0 && pos.linha < labirinto.length
            && pos.coluna >= 0 && pos.coluna < labirinto[0].length
            && labirinto[pos.linha][pos.coluna] != 1
            && labirinto[pos.linha][pos.coluna] != 2)
      return true;
    return false;
  }
}
