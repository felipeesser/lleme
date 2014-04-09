package exercicios.calculadora;

public class Variavel extends RepresentacaoExpressao {

  public String nome;
  public double valor;

  public Variavel(String nome) {
    this.nome = nome;
  }

  @Override
  public double calcular() {
    return valor;
  }

  @Override
  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitExpressao(this);
  }

  public Variavel clone() throws CloneNotSupportedException {
    return (Variavel) super.clone();
  }
}
