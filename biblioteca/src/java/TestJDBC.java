
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
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "lleme",
                    "lleme");
            Statement stmt = connection.createStatement();
            String query = "select id,nome from Usuario";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println(rs.getLong("id"));
                    System.out.println(rs.getString("nome"));
                }
            }
            
            query = "update Usuario set nome='Luiz Andre' where id=123";
            stmt = connection.createStatement();
            stmt.execute(query);

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
