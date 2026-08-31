// ============================================================
// FILE: DatabaseConnection.java
// PATTERN: Singleton Pattern (applied to DB connection)
// ROLE: Provides a single shared JDBC connection to the SQLite database.
// ============================================================
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection instance = null;
    private static final String URL = "jdbc:sqlite:database/ForensicManagementDatabase.db";

    private DatabaseConnection() {}

    public static Connection getInstance() {
        try {
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(URL);
                System.out.println("Successfully connected to the SQLite Database!");
                initTables(instance);
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return instance;
    }

    private static void initTables(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // Table 1: Investigator_Info
            stmt.execute("CREATE TABLE IF NOT EXISTS Investigator_Info (" +
                    "InvestigatorID TEXT PRIMARY KEY, " +
                    "Name TEXT, " +
                    "Password INTEGER, " +
                    "Investigator_Type TEXT)");

            // Table 2: EvidenceRecord
            stmt.execute("CREATE TABLE IF NOT EXISTS EvidenceRecord (" +
                    "InvestigatorID TEXT, " +
                    "EvidenceType TEXT, " +
                    "RiskScore INTEGER, " +
                    "Status TEXT, " +
                    "Notification TEXT)");

            // Table 3: Audit_Dept
            stmt.execute("CREATE TABLE IF NOT EXISTS Audit_Dept (" +
                    "InvestigatorID TEXT, " +
                    "PendingCases INTEGER)");

            // Table 4: Lab_Records
            stmt.execute("CREATE TABLE IF NOT EXISTS Lab_Records (" +
                    "InvestigatorID TEXT, " +
                    "AllocatedHours INTEGER)");

            // Seed sample data if table is empty
            stmt.execute("INSERT OR IGNORE INTO Investigator_Info VALUES " +
                    "('INV01', 'Rahul Sharma', 1234, 'Senior Investigator'), " +
                    "('INV02', 'Anita Roy', 1234, 'Junior Investigator')");

            stmt.execute("INSERT OR IGNORE INTO Audit_Dept VALUES " +
                    "('INV01', 10), " +
                    "('INV02', 5)");

            stmt.execute("INSERT OR IGNORE INTO Lab_Records VALUES " +
                    "('INV01', 100), " +
                    "('INV02', 40)");

        } catch (SQLException e) {
            System.out.println("Error initializing tables: " + e.getMessage());
        }
    }
}
