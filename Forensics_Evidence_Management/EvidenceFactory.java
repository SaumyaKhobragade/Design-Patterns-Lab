// ============================================================
// FILE: EvidenceFactory.java
// PATTERN: Factory Method Pattern
// ROLE: Concrete Factory — creates evidence objects based on a type string
// ============================================================
public class EvidenceFactory {
    public Evidence getEvidence(String evidenceType, int riskScore) {
        if (evidenceType == null) return null;
        if (evidenceType.equalsIgnoreCase("DISK")) return new DiskImage(riskScore);
        if (evidenceType.equalsIgnoreCase("MOBILE")) return new MobileBackup(riskScore);
        if (evidenceType.equalsIgnoreCase("NETWORK")) return new NetworkCapture(riskScore);
        return null;
    }
}
