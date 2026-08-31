// ============================================================
// FILE: SMSNotification.java
// PATTERN: Bridge Pattern
// ROLE: Concrete Implementation — sends notification via SMS
// ============================================================
public class SMSNotification implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS Notification: " + message);
    }
}
