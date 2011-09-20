package patterns.command.framework;

import java.util.Date;

public abstract class Pessoa {

    public String nome;
    public float peso;
    public float altura;
    public Date nascimento;

    public Pessoa(String nome, float peso, float altura, Date nascimento) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.nascimento = nascimento;
    }

    public double imc() {
        if (altura != 0 && peso != 0)
            return peso / (altura * altura);
        else
            return 0;
    }

    public int idade(Date data) {
        if (nascimento != null && data != null) {
            long diff = data.getTime() - nascimento.getTime();
            if (diff > 0)
                return (int) (diff / (365L * 24L * 60L * 60L * 1000L));
            else
                return 0;
        } else
            return 0;
    }
}
