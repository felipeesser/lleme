package provas.s20141.p320141;

public class Movimento {

    public final Pos a;
    public final Pos m;
    public final Pos b;
    private static final Tabuleiro tab = Tabuleiro.obterInstancia();

    public Movimento(Pos a, Pos b) {
        this.a = a;
        this.b = b;
        this.m = new Pos((a.i + b.i) / 2, (a.j + b.j) / 2);
    }

}
