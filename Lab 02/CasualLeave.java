public class CasualLeave extends Leave {
    public CasualLeave(String leaveType, String facultyName, int days) {
        super("CasualLeave", facultyName, days);
    }

    public void leave() {
        System.out.println("Casual Leave Granted!");
    }
}
