// ============================================================
// FILE: EvidenceCoordinator.java
// PATTERN: Observer Pattern
// ROLE: Subject (Publisher / Observable)
// PURPOSE: After any approval, updates DB status then notifies Audit & Lab departments.
//          Also handles CRUD DELETE (cancel) and CRUD UPDATE (reject).
// ============================================================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EvidenceCoordinator {
    private List<EvidenceObserver> observers = new ArrayList<>();

    public void registerObserver(EvidenceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EvidenceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(EvidenceRequest request) {
        System.out.println("\n[EvidenceCoordinator] Notifying all departments about the approved evidence...");
        for (EvidenceObserver observer : observers) {
            observer.update(request); // calls AuditDepartment.update() then ForensicsLab.update()
        }
    }

    // Called by HashVerifier / IntegrityChecker / ChiefAnalyst after approval
    public void onEvidenceApproved(EvidenceRequest request) {
        updateEvidenceStatusToApproved(request.getInvestigatorId(), request.getEvidenceType());
        notifyObservers(request);
    }

    // CRUD UPDATE: Set status to 'Approved'
    private void updateEvidenceStatusToApproved(String investigatorId, String evidenceType) {
        String sql = "UPDATE EvidenceRecord SET Status = 'Approved' " +
                     "WHERE InvestigatorID = ? AND EvidenceType = ? AND Status = 'Pending'";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, investigatorId);
                pstmt.setString(2, evidenceType);
                pstmt.executeUpdate();
                pstmt.close();
                System.out.println("[EvidenceCoordinator] DB: Evidence status updated to 'Approved'.");
            } catch (Exception e) {
                System.out.println("[EvidenceCoordinator] DB Update Error: " + e.getMessage());
            }
        }
    }

    // CRUD UPDATE: Set status to 'Rejected'
    public void rejectEvidenceRequest(String investigatorId, String evidenceType) {
        String sql = "UPDATE EvidenceRecord SET Status = 'Rejected' " +
                     "WHERE InvestigatorID = ? AND EvidenceType = ? AND Status = 'Pending'";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, investigatorId);
                pstmt.setString(2, evidenceType);
                pstmt.executeUpdate();
                pstmt.close();
                System.out.println("[EvidenceCoordinator] DB: Evidence status updated to 'Rejected'.");
            } catch (Exception e) {
                System.out.println("[EvidenceCoordinator] DB Reject Error: " + e.getMessage());
            }
        }
    }

    // CRUD DELETE: Remove a Pending evidence record
    public void cancelEvidenceRequest(String investigatorId, String evidenceType) {
        String sql = "DELETE FROM EvidenceRecord " +
                     "WHERE InvestigatorID = ? AND EvidenceType = ? AND Status = 'Pending'";
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, investigatorId);
                pstmt.setString(2, evidenceType);
                int rowsDeleted = pstmt.executeUpdate();
                pstmt.close();
                if (rowsDeleted > 0) {
                    System.out.println("[EvidenceCoordinator] Evidence request cancelled and removed from database.");
                } else {
                    System.out.println("[EvidenceCoordinator] No pending evidence found to cancel for Investigator ID: " + investigatorId);
                }
            } catch (Exception e) {
                System.out.println("[EvidenceCoordinator] DB Delete Error: " + e.getMessage());
            }
        }
    }
}
