package exercicios.blog;

import java.util.Set;

public class Nota extends Conteudo {

    private Set<Comentario> comentarios;

    public Nota(String mensagem, Usuario autor) {
        super(mensagem, autor);
    }

    public Comentario[] obterComentarios() {
        return comentarios.toArray(new Comentario[0]);
    }

}
