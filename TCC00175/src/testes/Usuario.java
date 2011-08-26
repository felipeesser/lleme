package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario extends ObjetoNegocio{

    public int id;
    public String nome;
    public long cpf;
    public Endereco endereco;

    public Usuario(int id) throws ClassNotFoundException, SQLException, Exception {
        this.id = id;
        ResultSet resultSet = getConnection().createStatement().executeQuery("select * from Usuario where id=" + id);
        if (resultSet.next()) {
            nome = resultSet.getString("nome");
            cpf = resultSet.getLong("cpf");
//            endereco = new Endereco();
//            endereco.logradouro = resultSet.getString("logradouro");
//            endereco.bairro = resultSet.getString("bairro");
        } else
            throw new Exception("objeto não existe");
    }

    public Endereco getEndereco() throws ClassNotFoundException, SQLException, Exception {
        if (endereco == null)
            endereco = new Endereco(id);
        return endereco;

    }
}
