// ============================================================
// FILE: ForensicSystemProxy.java
// PATTERN: Proxy Pattern
// ROLE: Proxy — guards access to the real ForensicManagerSystem
//   - authenticateUser() queries Investigator_Info table (CRUD READ)
//   - insertEvidence() inserts into EvidenceRecord table (CRUD CREATE)
// ============================================================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForensicSystemProxy implements IForensicSystem {
    private final ForensicManagerSystem realSystem;

    public ForensicSystemProxy() {
        this.realSystem = new ForensicManagerSystem();
    }

    // CRUD READ: Database Authentication
    public boolean authenticateUser(String investigatorId, String name, int password) {
        System.out.println("Proxy: Verifying credentials from database...");
        String sql = "SELECT * FROM Investigator_Info WHERE InvestigatorID = ? AND Name = ? AND Password = ?";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, investigatorId);
                pstmt.setString(2, name);
                pstmt.setInt(3, password);
                ResultSet rs = pstmt.executeQuery();
                boolean found = rs.next();
                rs.close();
                pstmt.close();
                return found;
            } catch (Exception e) {
                System.out.println("Proxy DB Auth Error: " + e.getMessage());
            }
        }
        return false;
    }

    // CRUD CREATE: Insert an evidence request row
    public void insertEvidence(String investigatorId, String evidenceType, int riskScore,
                               String status, String notification) {
        String sql = "INSERT INTO EvidenceRecord (InvestigatorID, EvidenceType, RiskScore, Status, Notification) " +
                     "VALUES (?, ?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, investigatorId);
                pstmt.setString(2, evidenceType);
                pstmt.setInt(3, riskScore);
                pstmt.setString(4, status);
                pstmt.setString(5, notification);
                pstmt.executeUpdate();
                pstmt.close();
                System.out.println("DB: Evidence request recorded with status '" + status + "'.");
            } catch (Exception e) {
                System.out.println("Proxy DB Insert Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void submitEvidence(Evidence evidence) {
        realSystem.submitEvidence(evidence); // Delegation to real system
    }
}
