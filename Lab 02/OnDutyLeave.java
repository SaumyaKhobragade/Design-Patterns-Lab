public class OnDutyLeave extends Leave {
    public OnDutyLeave(String leaveType, String facultyName, int days) {
        super("OnDuty", facultyName, days);
    }
    
    public void leave() {
        System.out.println("On Duty Leave Granted!");
    }
}
