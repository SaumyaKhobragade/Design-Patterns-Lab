// ============================================================
// FILE: EmailNotification.java
// PATTERN: Bridge Pattern
// ROLE: Concrete Implementation — sends notification via Email
// ============================================================
public class EmailNotification implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}
