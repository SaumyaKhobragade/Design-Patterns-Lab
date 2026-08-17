public class PermanentFactory extends LeaveFactory {
    @Override
    public Leave getLeave(String leaveType, Faculty faculty, int days) {
        if (leaveType == null) {
            return null;
        }

        if (leaveType.equalsIgnoreCase("CasualLeave")) {
            return new CasualLeave(leaveType, faculty, days);
        }

        if (leaveType.equalsIgnoreCase("MedicalLeave")) {
            return new MedicalLeave(leaveType, faculty, days);
        }

        if (leaveType.equalsIgnoreCase("OnDutyLeave")) {
            return new OnDutyLeave(leaveType, faculty, days);
        }

        return null;
    }
}
