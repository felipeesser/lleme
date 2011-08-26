package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {

    public String logradouro;
    public String bairro;

    public Endereco(int id) throws ClassNotFoundException, SQLException, Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Blog", "", "");
        ResultSet resultSet = con.createStatement().executeQuery("select * from Endereco where usuario=" + id);
        if (resultSet.next()) {
            logradouro = resultSet.getString("logradouro");
            bairro = resultSet.getString("bairro");
        } else
            throw new Exception("objeto não existe");
        con.close();
    }
}
