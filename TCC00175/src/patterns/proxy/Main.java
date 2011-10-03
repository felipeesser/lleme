package patterns.proxy;

import java.sql.SQLException;

public class Main {
    
    public static void main(String[] args) throws SQLException, Exception {
        
        Usuario usuario = UsuarioProxyAccessBD.getUsuario(1);
        System.out.println(usuario.getNome());
        usuario.setNome("outro nome");
        System.out.println(usuario.getNome());
        usuario.parsistir();
        UsuarioProxyAccessBD.close();
    }
    
}
