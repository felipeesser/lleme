package exercicios.jogoDeDados;


public class Main {

    public static void Main() {
        MesaDeDado mesa = new MesaDeDado(new Regra1());
        Partida partida = new Partida(mesa);

        imprimirAndamento(partida);
        while (partida.obterResultado() == Resultado.INDEFINIDO) {
            partida.jogar();
            imprimirAndamento(partida);
        }
    }

    private static void imprimirAndamento(Partida partida) {
        System.out.println("Ponto inicial: " + partida.obterPontoInicial());
        System.out.println("Ultimo ponto: " + partida.obterUltimoPonto());
        System.out.println("Resultado: " + partida.obterResultado());
    }
}
