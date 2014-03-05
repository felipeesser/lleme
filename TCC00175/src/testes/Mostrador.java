package testes;

public class Mostrador {

    public boolean[][] estadoLeds = new boolean[7][7];
    private char[][] leds = {{' ', '_', '_', '_', '_', '_', ' '},
    {'|', '\\', ' ', '|', ' ', '/', '|'},
    {'|', ' ', '\\', '|', '/', ' ', '|'},
    {'|', '-', '-', '+', '-', '-', '|'},
    {'|', ' ', '/', '|', '\\', ' ', '|'},
    {'|', '/', ' ', '|', ' ', '\\', '|'},
    {' ', '-', '-', '-', '-', '-', ' '}};

    public static void main(String[] args) {
        Mostrador mostrador = new Mostrador();
        boolean[][] estados
                = {{true, true, true, true, true, true, true},
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
                if (estadoLeds[i][j])
                    System.out.print(leds[i][j]);
                else
                    System.out.print(' ');
            System.out.println("");
        }
        System.out.println("");
    }

    public void ligar() {
        for (int i = 0; i < leds.length; i++)
            for (int j = 0; j < leds[0].length; j++)
                estadoLeds[i][j] = true;
    }

    public void apagar() {
        for (int i = 0; i < leds.length; i++)
            for (int j = 0; j < leds[0].length; j++)
                estadoLeds[i][j] = false;
    }

}
