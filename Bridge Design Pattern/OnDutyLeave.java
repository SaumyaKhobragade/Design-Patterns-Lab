public class OnDutyLeave extends Leave {
    public OnDutyLeave(String leaveType, Faculty faculty, int days) {
        super("OnDuty", faculty, days);
    }
    
    public void leave() {
        System.out.println("On Duty Leave Granted!");
    }
}
