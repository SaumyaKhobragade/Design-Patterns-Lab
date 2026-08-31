// ============================================================
// FILE: IForensicSystem.java
// PATTERN: Proxy Pattern
// ROLE: Interface (the shared contract for Proxy and Real System)
// ============================================================
public interface IForensicSystem {
    void submitEvidence(Evidence evidence);
}
