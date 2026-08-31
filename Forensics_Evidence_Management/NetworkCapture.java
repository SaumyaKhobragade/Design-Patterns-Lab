// ============================================================
// FILE: NetworkCapture.java
// PATTERN: Factory Method + Abstract Factory
// ROLE: Concrete Product — represents a Network PCAP Capture
// NOTE: Available to both Senior and Junior Investigators.
// ============================================================
public class NetworkCapture extends Evidence {
    public NetworkCapture(int riskScore) {
        super("Network Capture (NETWORK)", riskScore, "Packet stream dump of network traffic.");
    }

    @Override
    public void displayEvidenceDetails() {
        System.out.println("Evidence Type: " + evidenceType);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Description: " + description + " Method displayEvidenceDetails() - overridden");
    }
}
