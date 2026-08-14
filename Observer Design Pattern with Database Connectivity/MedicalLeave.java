public class MedicalLeave extends Leave {
    public MedicalLeave(String leaveType, Faculty faculty, int days) {
        super("MedicalLeave", faculty, days);
    }

    @Override
    public void leave() {
        System.out.println("Medical Leave Granted!");
    }
}
