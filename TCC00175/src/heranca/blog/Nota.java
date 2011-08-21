package heranca.blog;

import java.util.Collection;

public class Nota extends Conteudo {
    /**
     * @associates <{aula6.blog.Comentario}>
     */
    Collection comentarios;

    protected void comentar(Comentario comentario) {
    }
}
