package exercicios.blog;

import java.util.HashMap;
import java.util.Map;

public class BD {

    private static BD instance = null;
    private final Map<String, Blog> blogs = new HashMap<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    private BD() {

    }

    public static BD getInstance() {
        if (instance == null) {
            instance = new BD();
        }
        return instance;
    }

    public void saveBlog(Blog blog) throws Exception {
        if (blogs.containsKey(blog.obterTitulo()) && blogs.get(blog.obterTitulo()) != blog) {
            throw new Exception("Blog ja cadastrado com mesmo nome");
        }
        blogs.put(blog.obterTitulo(), blog);

        for (String titulo : blogs.keySet().toArray(new String[0])) {
            if (!blogs.get(titulo).equals(titulo)) {
                blogs.remove(titulo);
            }
        }

    }

    public void saveUsuario(Usuario usuario) throws Exception {
        if (usuarios.containsKey(usuario.obterEmail()) && usuarios.get(usuario.obterEmail()) != usuario) {
            throw new Exception("Usuario ja cadastrado com mesmo email");
        }
        usuarios.put(usuario.obterEmail(), usuario);

        for (String email : usuarios.keySet().toArray(new String[0])) {
            if (!usuarios.get(email).equals(email)) {
                usuarios.remove(email);
            }
        }
    }

    public Usuario obterUsuario(String email) {
        return usuarios.get(email);
    }

    public Blog obterBlog(String titulo) {
        return blogs.get(titulo);
    }

}
