package exercicios.blog;

import java.util.Calendar;
import java.util.Date;

public class Conteudo {

    private Date dataDeCriacao;
    private String mensagem;
    private Usuario autor;

    public Conteudo(String mensagem, Usuario autor) {
        this.mensagem = mensagem;
        this.autor = autor;
        this.dataDeCriacao = Calendar.getInstance().getTime();
    }

    public Date obterDataDeCriacao() {
        return dataDeCriacao;
    }

    public void atribuirDataDeCriacao(Date dataCriacao) {
        this.dataDeCriacao = dataCriacao;
    }

    public String obterMensagem() {
        return mensagem;
    }

    public void atribuirMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario obterAutor() {
        return autor;
    }

    public void atribuirAutor(Usuario autor) {
        this.autor = autor;
    }

}
