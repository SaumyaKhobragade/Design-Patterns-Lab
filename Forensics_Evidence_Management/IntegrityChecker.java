// ============================================================
// FILE: IntegrityChecker.java
// PATTERN: Chain of Responsibility
// ROLE: Concrete Handler #2 — verifies medium-risk evidence (risk score 3 to 7)
// ============================================================
public class IntegrityChecker extends EvidenceApprover {
    public IntegrityChecker(EvidenceCoordinator coordinator) {
        super(coordinator);
    }

    @Override
    public void ApproveEvidence(Evidence evidence, String investigatorId) {
        if (evidence.getRiskScore() <= 7) {
            System.out.println("Evidence approved with risk score " + evidence.getRiskScore() + " by IntegrityChecker");
            evidence.notifyStatus("Approved by IntegrityChecker"); // Bridge Pattern
            EvidenceRequest request = new EvidenceRequest(investigatorId, evidence.getEvidenceType(), evidence.getRiskScore());
            coordinator.onEvidenceApproved(request); // Observer Pattern
        } else if (nextApprover != null) {
            nextApprover.ApproveEvidence(evidence, investigatorId); // pass to ChiefAnalyst
        }
    }
}
