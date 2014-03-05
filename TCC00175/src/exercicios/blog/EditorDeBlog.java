package exercicios.blog;

import java.util.Date;

public class EditorDeBlog {

    private BD bd = BD.getInstance();

    public EditorDeBlog() {
        super();
    }

    public Blog criarBlog(Usuario usuario, String titulo) {
        Blog blog = new Blog(usuario, titulo);
        bd.save(blog);
        return blog;
    }

    public void publicarNota(Blog blog, Usuario autor, String mensagem) throws Exception {
        Nota nota = null;
        if (blog.obterDono() == autor) {
            nota = new Nota(autor, mensagem);
            blog.publicarNota(nota);
        } else {
            throw new Exception("Usuario não autorizado");
        }
    }

    public void publicarComentario(Nota nota, Usuario autor, String mensagem) {
        Comentario comentario = new Comentario(autor, mensagem);
        nota.publicarComentario(comentario);
    }

    public void excluirComentario(Nota nota, Comentario comentario) {
        Usuario usuario = comentario.obterAutor();
        Date data = comentario.obterDataDeCriacao();
        String mensagem = comentario.obterMensagem();
        boolean foiRemovido = nota.excluirComentario(comentario);
        if (foiRemovido) {
            enviarEmail(usuario, data, mensagem);
        }
    }

    public void excluirNota(Blog blog, Nota nota) {
        Usuario usuario = nota.obterAutor();
    }

    private void enviarEmail(Usuario usuario, Date data, String mensagem) {
        System.out.println("Email enviado para " + usuario.obterEmail());
    }
}
