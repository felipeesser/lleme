package exercicios.jogoDeDados;


public class Regra1 extends Regra {

    @Override
    public Resultado decidirResultado(int pontoInicial, int pontosObtidos) {
        if (pontoInicial < 2 || pontoInicial > 12)
            return decidirPrimeiraJogada(pontoInicial, pontosObtidos);
        else
            return decidirJogadaNormal(pontoInicial, pontosObtidos);
    }

    private Resultado decidirPrimeiraJogada(int pontoInicial, int pontosObtidos) {
        if (pontosObtidos == 7 || pontosObtidos == 11) {
            return Resultado.GANHOU;
        } else if (pontosObtidos == 2 || pontosObtidos == 3 || pontosObtidos == 12) {
            return Resultado.PERDEU;
        } else {
            return Resultado.INDEFINIDO;
        }
    }

    private Resultado decidirJogadaNormal(int pontoInicial, int pontosObtidos) {
        if (pontosObtidos == 7) {
            return Resultado.PERDEU;
        } else if (pontosObtidos == pontoInicial) {
            return Resultado.GANHOU;
        } else {
            return Resultado.INDEFINIDO;
        }
    }
}
