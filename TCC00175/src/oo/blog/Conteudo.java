package oo.blog;

import java.util.Date;

public class Conteudo implements Comparable {

    public Date dataCriacao;
    public String mensagem;
    public Usuario autor;

    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}
