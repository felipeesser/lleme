package aulas;

public class Hanoi {

  public static void main(String[] args) {
    System.out.println(moveTorre(3, 'a', 'b', 'c', 0));
  }

  public static int moveTorre(int n, char a, char b, char c, int cont) {
    if (n == 1)
      cont++;
    else {
      cont = moveTorre(n - 1, a, c, b, cont);
      System.out.println("mover de " + a + " para " + b + "\n");
      cont = moveTorre(n - 1, c, b, a, cont);
    }
    return cont;
  }
}
