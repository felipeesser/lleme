package exemplos;

public class Multiplicacao {

  public static void main(String[] args) {
    System.out.println(multiplica(3, 4));
  }

  public static int multiplica(int x, int y) {
    if (y == 1)
      return x;
    else
      return x + multiplica(x, y - 1);
  }
}
