public class Main {
    public static void main(String[] args) {
        ProxyStore pstore = new ProxyStore();
        Proxy p = new Proxy();

        Faculty f1 = FacultyFactory.getFaculty(
                "Permanent",
                "Saumya");

        Faculty f2 = FacultyFactory.getFaculty(
                "Contract",
                "John");

        // Notification smsNotification = new SMSNotification();
        // Notification emailNotification = new EmailNotification();
        // Notification mobileAppNotification = new MobileAppNotification();

        Leave leave = new MedicalLeave("MedicalLeave", f1, 10);
        leave.setNotification(new SMSNotification());

        pstore.register(f1, "XYZ");

        pstore.register(f2, "ABC");

        // System.out.println(ProxyStore.db.containsKey(f1.getFacultyName()) ? "User exists." : "Does not exist.");
        // p.submitLeaveRequest(f1, "XYZ", "MedicalLeave", 10);

        // System.out.println(ProxyStore.db.containsKey(f2.getFacultyName()) ? "User
        // exists." : "Does not exist.");
        // p.submitLeaveRequest(f2, "ABC", "MedicalLeave", 10);

        // Permanent faculty can apply Medical Leave
        p.submitLeaveRequest(
                f1,
                "XYZ",
                leave);

        // // Contract faculty cannot
        // p.submitLeaveRequest(
        //         f2,
        //         "ABC",
        //         leave,
        //         10);

        // // Contract faculty can apply Casual Leave
        // p.submitLeaveRequest(
        //         f2,
        //         "ABC",
        //         leave,
        //         2);
    }
}
