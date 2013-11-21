package provas.s20112;

public class P220112Ex2 {

  public static void main(String[] args) {
    float[][] matriz = {{1, 1, 0, 3}, {0, 2, 0, -2}, {0, 0, 5, 2}};
    System.out.println(solucao(matriz, 0));
  }

  public static float solucao(float[][] matriz, int variavel) {
    float resultado = matriz[variavel][matriz[0].length - 1];
    for (int j = variavel + 1; j < matriz.length; j++)
      resultado -= matriz[variavel][j] * solucao(matriz, j);
    resultado /= matriz[variavel][variavel];
    return resultado;
  }
}
