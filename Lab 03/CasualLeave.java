public class CasualLeave extends Leave {
    public CasualLeave(String leaveType, Faculty faculty, int days) {
        super("CasualLeave", faculty, days);
    }

    public void leave() {
        System.out.println("Casual Leave Granted!");
    }
}
