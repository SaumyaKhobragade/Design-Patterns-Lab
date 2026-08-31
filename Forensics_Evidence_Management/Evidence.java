// ============================================================
// FILE: Evidence.java
// PATTERN: Factory Method + Bridge Pattern
// ROLE: Abstract Product — base class for all evidence types.
//       Also the ABSTRACTION side of the Bridge pattern (holds NotificationChannel).
// ============================================================
public abstract class Evidence {
    protected String evidenceType;
    protected int riskScore;
    protected String description;
    protected NotificationChannel notificationChannel; // BRIDGE

    public Evidence(String evidenceType, int riskScore, String description) {
        this.evidenceType = evidenceType;
        this.riskScore = riskScore;
        this.description = description;
    }

    // BRIDGE PATTERN: Inject notification channel at runtime
    public void setNotificationChannel(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    // Sends status message through the chosen channel
    public void notifyStatus(String status) {
        if (notificationChannel != null) {
            notificationChannel.sendNotification(
                "Evidence Type: " + evidenceType + ", Risk Score: " + riskScore + ", Status: " + status
            );
        }
    }

    public int getRiskScore() { return riskScore; }
    public String getEvidenceType() { return evidenceType; }
    public abstract void displayEvidenceDetails(); // Overridden by each subclass
}
