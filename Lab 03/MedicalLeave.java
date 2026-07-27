public class MedicalLeave extends Leave {
    public MedicalLeave(String leaveType, Faculty faculty, int days) {
        super("Medical", faculty, days);
    }

    public void leave() {
        System.out.println("Medical Leave Granted!");
    }
}
