import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = System.getenv("MYSQL_URL");
            if (url == null || url.isEmpty()) {
                url = "jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true";
            }
            String user = System.getenv("MYSQL_USER");
            if (user == null || user.isEmpty()) {
                user = "root";
            }
            String pass = System.getenv("MYSQL_PASSWORD");
            if (pass == null) {
                pass = "";
            }
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
