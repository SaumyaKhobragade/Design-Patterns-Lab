public class LeaveFactory {
    public static Leave getLeave(String leaveType, String facultyName, int days) {
        if (leaveType == null) {
            return null;
        } else if (leaveType.equalsIgnoreCase("CasualLeave")) {
            return new CasualLeave(leaveType, facultyName, days);
        } else if (leaveType.equalsIgnoreCase("MedicalLeave")) {
            return new MedicalLeave(leaveType, facultyName, days);
        } else if (leaveType.equalsIgnoreCase("OnDutyLeave")) {
            return new OnDutyLeave(leaveType, facultyName, days);
        } else {
            return null;
        }
    }
}
