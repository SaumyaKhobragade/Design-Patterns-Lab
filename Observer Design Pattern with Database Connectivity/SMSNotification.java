public class SMSNotification implements Notification{
    @Override
    public void sendNotification(Faculty faculty, Leave leave){
        System.out.println(
            "SMS : Dear " + faculty.getFacultyName() + ", your " + leave.getLeaveType() + " has been approved."
        );
    }
}
