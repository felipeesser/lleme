package oo.blog;

import java.util.Set;
import java.util.TreeSet;

public class Blog implements InterfaceBlog {

    public Set<Conteudo> conteudos = new TreeSet<Conteudo>();

    public void operacao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addConteudo(Conteudo c) {
        conteudos.add(c);

    }
}
