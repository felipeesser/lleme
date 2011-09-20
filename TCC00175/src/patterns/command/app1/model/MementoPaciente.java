package patterns.command.app1.model;

import java.util.Date;

public class MementoPaciente extends Memento {

    final String nome;
    final float peso;
    final float altura;
    final Date nascimento;

    protected MementoPaciente(String nome, float peso, float altura, Date nascimento) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.nascimento = nascimento;
    }
    
    
}
