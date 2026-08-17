public class HRDepartment implements Observer {
    @Override
    public void update(Leave leave) {
        System.out.println("HR Department notified.");
        System.out.println("Free leave used: " + leave.getFreeLeaveDays() + " day(s).");
        System.out.println("Remaining leave balance " + "has been updated.");
    }
}
