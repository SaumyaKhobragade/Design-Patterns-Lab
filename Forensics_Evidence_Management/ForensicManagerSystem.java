// ============================================================
// FILE: ForensicManagerSystem.java
// PATTERN: Proxy Pattern
// ROLE: Real Subject — the actual system that processes evidence submissions
// ============================================================
public class ForensicManagerSystem implements IForensicSystem {
    @Override
    public void submitEvidence(Evidence evidence) {
        System.out.println("Interface Forensic System Overridden method called");
        evidence.displayEvidenceDetails(); // Polymorphism: calls DiskImage / MobileBackup / NetworkCapture version
        System.out.println("Evidence registered and submitted successfully!");
        System.out.println("------------------------------------------------");
    }
}
