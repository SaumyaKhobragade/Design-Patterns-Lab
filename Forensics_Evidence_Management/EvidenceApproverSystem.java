// ============================================================
// FILE: EvidenceApproverSystem.java
// PATTERN: Singleton + Observer + Chain of Responsibility
// ROLE: Central system that wires all patterns together.
//   - Singleton: only ONE instance ever exists
//   - Creates EvidenceCoordinator and registers observers
//   - Builds the Chain: HashVerifier -> IntegrityChecker -> ChiefAnalyst
// ============================================================
public class EvidenceApproverSystem {
    private static EvidenceApproverSystem instance;
    private final EvidenceApprover approverChain; // first link (HashVerifier)
    private final EvidenceCoordinator coordinator;

    private EvidenceApproverSystem() {
        // Observer Pattern Setup
        coordinator = new EvidenceCoordinator();
        coordinator.registerObserver(new AuditDepartment());
        coordinator.registerObserver(new ForensicsLab());

        // Chain of Responsibility Setup
        EvidenceApprover hashVerifier = new HashVerifier(coordinator);
        EvidenceApprover integrityChecker = new IntegrityChecker(coordinator);
        EvidenceApprover chiefAnalyst = new ChiefAnalyst(coordinator);

        hashVerifier.SetNextApprover(integrityChecker);
        integrityChecker.SetNextApprover(chiefAnalyst);

        this.approverChain = hashVerifier;
    }

    public static EvidenceApproverSystem getInstance() {
        if (instance == null) {
            instance = new EvidenceApproverSystem();
        }
        return instance;
    }

    public EvidenceCoordinator getCoordinator() {
        return coordinator;
    }

    public void processEvidence(Evidence evidence, String investigatorId) {
        System.out.println("Approval chain started...");
        approverChain.ApproveEvidence(evidence, investigatorId); // starts at HashVerifier
        System.out.println("--------------------------------------");
    }
}
