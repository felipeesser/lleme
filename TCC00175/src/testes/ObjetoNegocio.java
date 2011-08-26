package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ObjetoNegocio {

    private static Connection con;

    public ObjetoNegocio() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Blog", "", "");
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void close() throws SQLException {
        con.close();
    }
}
