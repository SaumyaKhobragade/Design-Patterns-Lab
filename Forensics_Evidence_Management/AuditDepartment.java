// ============================================================
// FILE: AuditDepartment.java
// PATTERN: Observer Pattern
// ROLE: Concrete Observer #1
// PURPOSE: Decrements pending cases count in Audit_Dept table after approval.
//          Formula: PendingCases = PendingCases - 1
// ============================================================
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuditDepartment implements EvidenceObserver {
    @Override
    public void update(EvidenceRequest request) {
        System.out.println("Audit Department: Updating case audit records for Investigator ID: " +
                           request.getInvestigatorId());
        String sql = "UPDATE Audit_Dept SET PendingCases = PendingCases - 1 WHERE InvestigatorID = ?";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, request.getInvestigatorId());
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Audit Department: Audit records updated. Decremented 1 pending case.");
                } else {
                    System.out.println("Audit Department: No record found for Investigator ID " +
                                       request.getInvestigatorId());
                }
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Audit Department DB Error: " + e.getMessage());
            }
        }
    }
}
