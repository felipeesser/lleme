package trabalhos.s20141;

public class Escalar extends Literal{

  private double valor;
  
  public Escalar(double valor) {
    this.valor=valor;
  }

  
  @Override
  public Escalar calcular() {
    return this;
  }
  
  public double getValor(){
    return 0;
  }
}
