public class MedicalLeave extends Leave {
    public MedicalLeave(String leaveType, String facultyName, int days) {
        super("Medical", facultyName, days);
    }

    public void leave() {
        System.out.println("Medical Leave Granted!");
    }
}
