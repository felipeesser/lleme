package patterns.composite;

import patterns.prototype.Nomeavel;

public abstract class Item implements Nomeavel {

    private String nome = null;
    private double variacao = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }
}
