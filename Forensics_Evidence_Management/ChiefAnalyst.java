// ============================================================
// FILE: ChiefAnalyst.java
// PATTERN: Chain of Responsibility
// ROLE: Concrete Handler #3 — final approver, handles high risk (8+ score)
// NOTE: No condition check — ChiefAnalyst always approves what reaches them.
// ============================================================
public class ChiefAnalyst extends EvidenceApprover {
    public ChiefAnalyst(EvidenceCoordinator coordinator) {
        super(coordinator);
    }

    @Override
    public void ApproveEvidence(Evidence evidence, String investigatorId) {
        System.out.println("Evidence approved with risk score " + evidence.getRiskScore() + " by ChiefAnalyst");
        evidence.notifyStatus("Approved by ChiefAnalyst"); // Bridge Pattern
        EvidenceRequest request = new EvidenceRequest(investigatorId, evidence.getEvidenceType(), evidence.getRiskScore());
        coordinator.onEvidenceApproved(request); // Observer Pattern
    }
}
