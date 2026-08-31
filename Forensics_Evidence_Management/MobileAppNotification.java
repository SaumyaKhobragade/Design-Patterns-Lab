// ============================================================
// FILE: MobileAppNotification.java
// PATTERN: Bridge Pattern
// ROLE: Concrete Implementation — sends notification via Mobile App
// ============================================================
public class MobileAppNotification implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Mobile App Notification: " + message);
    }
}
