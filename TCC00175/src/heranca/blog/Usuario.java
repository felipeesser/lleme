package heranca.blog;

import java.util.Collection;

public class Usuario {
    /**
     * @attribute
     */
    private String nome;

    /**
     * @attribute
     */
    private String email;

    /**
     * @associates <{aula6.blog.Blog}>
     */
    Collection favoritos;

}
