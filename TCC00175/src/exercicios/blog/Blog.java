package exercicios.blog;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Blog {

    private Date dataDeCriacao = null;
    private String titulo = null;
    private Usuario dono = null;
    private Set<Nota> notas = new TreeSet<>();

    private Blog() {

    }

    public Blog(Usuario dono, String titulo) {
        this.titulo = titulo;
        this.dono = dono;
        this.dataDeCriacao = Calendar.getInstance().getTime();
    }

    public Date obterDataDeCriacao() {
        return dataDeCriacao;
    }

    public void atribuirDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String obterTitulo() {
        return titulo;
    }

    public void atribuirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario obterDono() {
        return dono;
    }

    public void atribuirDono(Usuario dono) {
        this.dono = dono;
    }

    public Nota[] obterNotas() {
        return notas.toArray(new Nota[0]);
    }

    public void removerNota(Nota nota) {
        notas.remove(nota);
    }

    public void publicarNota(Nota nota) {
        notas.add(nota);
    }
}
