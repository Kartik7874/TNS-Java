import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    private static String url = "jdbc:mysql://localhost:3306/student";
    private static String userName = "root";
    private static String password = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
