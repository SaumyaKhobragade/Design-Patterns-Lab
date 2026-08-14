public class EmailNotification implements Notification{

    @Override
    public void sendNotification(Faculty faculty, Leave leave){
        System.out.println(
            "EMAIL : Dear " + faculty.getFacultyName() + ", your " + leave.getLeaveType() + " has been approved."
        );
    }
}
