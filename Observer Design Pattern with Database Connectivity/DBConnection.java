import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/LEAVE_MANAGEMENT_SYSTEM";
    private static final String USERNAME = "root";
    private static final String PASSWORD = loadSecret("DB_PASSWORD");

    private static String loadSecret(String key) {
        Map<String, String> env = loadDotEnv(".env");
        if (env.containsKey(key)) {
            return env.get(key);
        }
        String value = System.getenv(key);
        if (value != null && !value.isEmpty()) {
            return value;
        }
        throw new IllegalStateException(
                "'" + key + "' not found in .env file or environment. " +
                        "Copy .env.example to .env and set the value.");
    }

    private static Map<String, String> loadDotEnv(String path) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;
                int eq = line.indexOf('=');
                if (eq < 1)
                    continue;
                String k = line.substring(0, eq).trim();
                String v = line.substring(eq + 1).trim();
                if (v.length() >= 2 &&
                        ((v.startsWith("\"") && v.endsWith("\"")) ||
                                (v.startsWith("'") && v.endsWith("'")))) {
                    v = v.substring(1, v.length() - 1);
                }
                map.put(k, v);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return map;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
