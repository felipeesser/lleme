package patterns.command.app1.model;

import patterns.command.framework.Pessoa;
import java.util.Date;

public class Paciente extends Pessoa {

    public Paciente(String nome, float peso, float altura, Date nascimento) {
        super(nome, peso, altura, nascimento);
    }

    public MementoPaciente createMemento() {
        return new MementoPaciente(this.nome, this.peso, this.altura, this.nascimento);
    }

    public void setMemento(MementoPaciente m) {
        this.nome = m.nome;
        this.peso = m.peso;
        this.altura = m.altura;
        this.nascimento = m.nascimento;
    }
}
