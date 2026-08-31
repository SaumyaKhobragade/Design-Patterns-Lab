// ============================================================
// FILE: EvidenceRequest.java
// PATTERN: Observer Pattern
// ROLE: Data Holder / Transfer Object
// PURPOSE: Carries evidence information from approver -> coordinator -> observers.
// ============================================================
public class EvidenceRequest {
    private String investigatorId;
    private String evidenceType;
    private int riskScore;

    public EvidenceRequest(String investigatorId, String evidenceType, int riskScore) {
        this.investigatorId = investigatorId;
        this.evidenceType = evidenceType;
        this.riskScore = riskScore;
    }

    public String getInvestigatorId() { return investigatorId; }
    public String getEvidenceType() { return evidenceType; }
    public int getRiskScore() { return riskScore; }
}
