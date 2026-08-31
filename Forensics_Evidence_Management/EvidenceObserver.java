// ============================================================
// FILE: EvidenceObserver.java
// PATTERN: Observer Pattern
// ROLE: Observer Interface (the "Subscriber" contract)
// ============================================================
public interface EvidenceObserver {
    void update(EvidenceRequest request);
}
