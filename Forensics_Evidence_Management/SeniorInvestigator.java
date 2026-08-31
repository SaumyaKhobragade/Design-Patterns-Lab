// ============================================================
// FILE: SeniorInvestigator.java
// PATTERN: Abstract Factory Pattern
// ROLE: Concrete Factory #1 — creates evidence objects for Senior Investigator
// NOTE: Senior Investigator can create ALL three evidence types.
// ============================================================
public class SeniorInvestigator implements AbstractFactory {
    @Override
    public Evidence createDiskImage(int riskScore) {
        return new DiskImage(riskScore);
    }

    @Override
    public Evidence createMobileBackup(int riskScore) {
        return new MobileBackup(riskScore); // Senior Investigator IS eligible
    }

    @Override
    public Evidence createNetworkCapture(int riskScore) {
        return new NetworkCapture(riskScore);
    }
}
