package provas.s20141.p320141;

public class Pos {

  public Integer i;
  public Integer j;

  public Pos(int linha, int coluna) {
    this.i = linha;
    this.j = coluna;
  }

  public boolean equals(Pos p) {
    return p != null && this.i.equals(p.j) && this.j.equals(p.j);
  }
}
