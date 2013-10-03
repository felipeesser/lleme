
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

public class TestJDBC {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "lleme",
                    "lleme");
            Statement stmt = conn.createStatement();
            String query = "select id,nome from Usuario";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println(rs.getLong("id"));
                    System.out.println(rs.getString("nome"));
                }
            }
            
            query = "update Usuario set nome='Luiz' where id=123";
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            stmt.execute(query);
            //stmt.getResultSet();
            //stmt.getMoreResults();
            //stmt.getUpdateCount();
            conn.commit();
            //conn.rollback();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
