// ============================================================
// FILE: EvidenceApprover.java
// PATTERN: Chain of Responsibility
// ROLE: Abstract Base Class — structure every approver must follow
// ============================================================
public abstract class EvidenceApprover {
    protected EvidenceApprover nextApprover; // next in chain
    protected EvidenceCoordinator coordinator; // to trigger observer notifications

    public EvidenceApprover(EvidenceCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void SetNextApprover(EvidenceApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void ApproveEvidence(Evidence evidence, String investigatorId);
}
