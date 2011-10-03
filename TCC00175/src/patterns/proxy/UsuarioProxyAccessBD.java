package patterns.proxy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.omg.CORBA.UserException;

public class UsuarioProxyAccessBD extends ObjetoAccessBD implements Usuario {

    private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private UsuarioReal usuarioReal;
    private UsuarioReal usuarioLocal;

    private UsuarioProxyAccessBD(UsuarioReal usuarioReal, UsuarioReal usuarioLocal)
            throws ClassNotFoundException, SQLException {
        this.usuarioReal = usuarioReal;
        this.usuarioLocal = usuarioLocal;
    }

    public static Usuario getUsuario(int id) throws SQLException, Exception {
        if (!usuarios.containsKey(id)) {
            ResultSet resultSet = getConnection().createStatement().
                    executeQuery("select * from Usuario where id=" + id);
            UsuarioReal usuario = new UsuarioReal();
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getLong("cpf"));
                Endereco endereco = new Endereco(resultSet.getString("logradouro"),
                        resultSet.getString("bairro"));
                usuario.setEndereco(endereco);
                usuario.setTimestamp(resultSet.getTimestamp("timestamp"));

                UsuarioProxyAccessBD proxy = new UsuarioProxyAccessBD(usuario, (UsuarioReal) usuario.clone());
                usuarios.put(id, proxy);

                return proxy;

            } else
                throw new Exception("objeto não existe");
        } else
            return usuarios.get(id);
    }

    public static Usuario removeUsuario(Integer key) {
        return usuarios.remove(key);
    }

    public long getCpf() {
        return usuarioLocal.getCpf();
    }

    public Endereco getEndereco() {
        return usuarioLocal.getEndereco();
    }

    public int getId() {
        return usuarioLocal.getId();
    }

    public String getNome() {
        return usuarioLocal.getNome();
    }

    public void setCpf(long cpf) {
        usuarioLocal.setCpf(cpf);
    }

    public void setEndereco(Endereco endereco) {
        usuarioLocal.setEndereco(endereco);
    }

    public void setId(int id) {
        usuarioLocal.setId(id);
    }

    public void setNome(String nome) {
        usuarioLocal.setNome(nome);
    }

    public Timestamp getTimestamp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTimestamp(Timestamp date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void parsistir() throws ClassNotFoundException, SQLException, UserException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        String updateStr = "update usuario set "
                + " id=" + usuarioLocal.getId()
                + ", nome='" + usuarioLocal.getNome() + "'"
                + ", cpf=" + usuarioLocal.getCpf()
                + ", logradouro='" + usuarioLocal.getEndereco().logradouro + "'"
                + ", bairro='" + usuarioLocal.getEndereco().bairro + "'"
                + " where id=" + usuarioReal.getId() + " and timestamp=#"
                + sdf.format(usuarioReal.getTimestamp()) + "#";
        int resultSet = getConnection().createStatement().
                executeUpdate(updateStr);
        if (resultSet == 0)
            throw new UserException("Usuario modificado anteriormente") {
            };
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
