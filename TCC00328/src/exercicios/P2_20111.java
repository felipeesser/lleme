package exercicios;

public class P2_20111 {

    public static void main(String[] args) {

    }

    public static float determinante(float[][] matriz) {
        int i = 0;
        float m = 0f;
        if (matriz[0].length == 1) {
            return matriz[0][0];
        } else {
            for (int j = 0; j <= matriz[0].length; j++) {
                m += matriz[i][j] * Math.pow(-1, i + j) * determinante(cofator(matriz, i, j));
            }
            return m;
        }

    }

    public static float[][] cofator(float[][] A, int i, int j) {
        return null;
    }

}
