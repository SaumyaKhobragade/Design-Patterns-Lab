// ============================================================
// FILE: HashVerifier.java
// PATTERN: Chain of Responsibility
// ROLE: Concrete Handler #1 — verifies low-risk evidence (risk score 1 to 2)
// ============================================================
public class HashVerifier extends EvidenceApprover {
    public HashVerifier(EvidenceCoordinator coordinator) {
        super(coordinator);
    }

    @Override
    public void ApproveEvidence(Evidence evidence, String investigatorId) {
        if (evidence.getRiskScore() <= 2) {
            System.out.println("Evidence approved with risk score " + evidence.getRiskScore() + " by HashVerifier");
            evidence.notifyStatus("Approved by HashVerifier"); // Bridge Pattern
            EvidenceRequest request = new EvidenceRequest(investigatorId, evidence.getEvidenceType(), evidence.getRiskScore());
            coordinator.onEvidenceApproved(request); // Observer Pattern
        } else if (nextApprover != null) {
            nextApprover.ApproveEvidence(evidence, investigatorId); // pass to IntegrityChecker
        }
    }
}
