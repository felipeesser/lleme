package exercicios.letreiro;

import exercicios.letreiro.visitante.Visitante;

public class Mostrador1 extends Mostrador {

  public boolean[][] estados = new boolean[7][7];
  private char[][] leds = {{' ', '_', '_', '_', '_', '_', ' '},
    {'|', '\\', ' ', '|', ' ', '/', '|'},
    {'|', ' ', '\\', '|', '/', ' ', '|'},
    {'|', '-', '-', '+', '-', '-', '|'},
    {'|', ' ', '/', '|', '\\', ' ', '|'},
    {'|', '/', ' ', '|', ' ', '\\', '|'},
    {' ', '-', '-', '-', '-', '-', ' '}};

  public void aceitarVisitante(Visitante visitante) {
    visitante.visitarMostrador1(this);
  }

  public void atribuirEstados(boolean[][] estados) {
    int k = 0;
    int l = 0;
    if (estados != null) {
      k = estados.length;
      l = estados[0].length;
    }
    for (int i = 0; i < estados.length; i++)
      for (int j = 0; j < estados.length; j++)
        if (i < k && j < l)
          this.estados[i][j] = estados[i][j];
        else
          this.estados[i][j] = false;
  }

  public static void main(String[] args) {
    testes.Mostrador mostrador = new testes.Mostrador();
    boolean[][] estados = {{true, true, true, true, true, true, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true},
      {true, true, true, true, true, true, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true},
      {true, false, false, false, false, false, true}};
    mostrador.estadoLeds = estados;
    mostrador.mostrar();

    mostrador.ligar();
    mostrador.mostrar();

    mostrador.apagar();
    mostrador.mostrar();

  }

  public void mostrar() {
    for (int i = 0; i < leds.length; i++) {
      for (int j = 0; j < leds[0].length; j++)
        if (estados[i][j])
          System.out.print(leds[i][j]);
        else
          System.out.print(' ');
      System.out.println("");
    }
    System.out.println("");
  }
}
