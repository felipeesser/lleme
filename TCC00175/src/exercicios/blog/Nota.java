package exercicios.blog;

import java.util.Set;
import java.util.TreeSet;

public class Nota extends Conteudo {

    private Set<Comentario> comentarios = new TreeSet<>();

    public Nota(Usuario autor, String mensagem) {
        super(autor, mensagem);
    }

    public Comentario[] obterComentarios() {
        return comentarios.toArray(new Comentario[0]);
    }

    public void publicarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public boolean excluirComentario(Comentario comentario) {
        return comentarios.remove(comentario);
    }

}
