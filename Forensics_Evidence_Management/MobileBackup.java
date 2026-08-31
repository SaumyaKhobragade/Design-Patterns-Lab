// ============================================================
// FILE: MobileBackup.java
// PATTERN: Factory Method + Abstract Factory
// ROLE: Concrete Product — represents a Mobile Backup evidence item
// NOTE: Only available to Senior Investigators.
// ============================================================
public class MobileBackup extends Evidence {
    public MobileBackup(int riskScore) {
        super("Mobile Backup (MOBILE)", riskScore, "Physical & logical extraction of smartphone data.");
    }

    @Override
    public void displayEvidenceDetails() {
        System.out.println("Evidence Type: " + evidenceType);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Description: " + description + " Method displayEvidenceDetails() - overridden");
    }
}
