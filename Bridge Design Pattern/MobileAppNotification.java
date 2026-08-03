public class MobileAppNotification implements Notification{
    @Override
    public void sendNotification(Faculty faculty, Leave leave){
        System.out.println(
            "MOBILE APP : Dear " + faculty.getFacultyName() + ", your " + leave.getLeaveType() + " has been approved."
        );
    }
}
