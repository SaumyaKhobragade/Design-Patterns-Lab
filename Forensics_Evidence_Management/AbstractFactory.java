// ============================================================
// FILE: AbstractFactory.java
// PATTERN: Abstract Factory Pattern
// ROLE: Abstract Factory Interface
// PURPOSE: Defines the family of evidence products a factory must create.
//          SeniorInvestigator and JuniorInvestigator both implement this.
// ============================================================
public interface AbstractFactory {
    Evidence createDiskImage(int riskScore);
    Evidence createMobileBackup(int riskScore); // JuniorInvestigator returns null
    Evidence createNetworkCapture(int riskScore);
}
