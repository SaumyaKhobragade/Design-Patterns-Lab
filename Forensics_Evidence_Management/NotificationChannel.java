// ============================================================
// FILE: NotificationChannel.java
// PATTERN: Bridge Pattern
// ROLE: Implementation Interface (the "how to send" contract)
// PURPOSE: Decouples Evidence class from notification delivery mechanism.
// ============================================================
public interface NotificationChannel {
    void sendNotification(String message);
}
