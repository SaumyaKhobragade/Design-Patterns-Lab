// ============================================================
// FILE: ForensicsLab.java
// PATTERN: Observer Pattern
// ROLE: Concrete Observer #2
// PURPOSE: Deducts allocated analysis lab hours from Lab_Records table after approval.
//          Formula: AllocatedHours = AllocatedHours - (10 * RiskScore)
// ============================================================
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ForensicsLab implements EvidenceObserver {
    @Override
    public void update(EvidenceRequest request) {
        System.out.println("Forensics Lab: Processing lab hours allocation for Investigator ID: "
                           + request.getInvestigatorId());
        String sql = "UPDATE Lab_Records SET AllocatedHours = AllocatedHours - ? WHERE InvestigatorID = ?";
        int deductionHours = 10 * request.getRiskScore();
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, deductionHours);
                pstmt.setString(2, request.getInvestigatorId());
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Forensics Lab: Lab hours allocated. Hours: "
                                       + deductionHours + " hrs");
                } else {
                    System.out.println("Forensics Lab: No record found for Investigator ID "
                                       + request.getInvestigatorId());
                }
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Forensics Lab DB Error: " + e.getMessage());
            }
        }
    }
}
