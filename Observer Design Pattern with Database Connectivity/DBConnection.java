import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/LEAVE_MANAGEMENT_SYSTEM";
    private static final String USERNAME = "root";
    // Password is read from the DB_PASSWORD environment variable.
    // Set it before running: set DB_PASSWORD=your_password (Windows)
    //                        export DB_PASSWORD=your_password (Linux/macOS)
    private static final String PASSWORD = System.getenv("DB_PASSWORD") != null
            ? System.getenv("DB_PASSWORD")
            : throwMissingEnvVar();

    private static String throwMissingEnvVar() {
        throw new IllegalStateException(
            "Environment variable DB_PASSWORD is not set. " +
            "Please set it before running the application.");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
