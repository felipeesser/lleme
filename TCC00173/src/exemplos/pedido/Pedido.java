package exemplos.pedido;

public class Pedido {

    public int id;
    public Produto produto;
    public int qtd;

    public float valor() {
        return qtd * produto.preco;
    }
}
