// ============================================================
// FILE: JuniorInvestigator.java
// PATTERN: Abstract Factory Pattern
// ROLE: Concrete Factory #2 — creates evidence objects for Junior Investigator
// NOTE: Junior Investigator CANNOT acquire Mobile Backups -> returns null.
// ============================================================
public class JuniorInvestigator implements AbstractFactory {
    @Override
    public Evidence createDiskImage(int riskScore) {
        return new DiskImage(riskScore);
    }

    @Override
    public Evidence createMobileBackup(int riskScore) {
        System.out.println("Junior Investigator is not authorized to acquire Mobile Backup evidence.");
        return null; // InvestigatorClient checks for null and records 'Rejected'
    }

    @Override
    public Evidence createNetworkCapture(int riskScore) {
        return new NetworkCapture(riskScore);
    }
}
