public class OnDutyLeave extends Leave {
    public OnDutyLeave(String leaveType, Faculty faculty, int days) {
        super("OnDutyLeave", faculty, days);
    }

    @Override
    public void leave() {
        System.out.println("On Duty Leave Granted!");
    }
}
