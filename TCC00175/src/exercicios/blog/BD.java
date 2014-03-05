package exercicios.blog;

import java.util.HashMap;
import java.util.Map;

public class BD {

    private static BD instance = null;
    private Map<String, Blog> blogs = new HashMap<>();

    private BD() {

    }

    public static BD getInstance() {
        if (instance == null) {
            instance = new BD();
        }
        return instance;
    }

    public void save(Blog blog) {
        blogs.put(blog.obterTitulo(), blog);
    }

}
