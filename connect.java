import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "edureka");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
