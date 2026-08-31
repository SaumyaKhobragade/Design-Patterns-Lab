// ============================================================
// FILE: DiskImage.java
// PATTERN: Factory Method + Abstract Factory
// ROLE: Concrete Product — represents a Disk Image evidence item
// ============================================================
public class DiskImage extends Evidence {
    public DiskImage(int riskScore) {
        super("Disk Image (DISK)", riskScore, "Bit-stream forensic copy of physical storage medium.");
    }

    @Override
    public void displayEvidenceDetails() {
        System.out.println("Evidence Type: " + evidenceType);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Description: " + description + " Method displayEvidenceDetails() - overridden");
    }
}
