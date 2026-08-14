public class PermanentFactory extends LeaveFactory {

    @Override
    public Leave getLeave(Leave leave, Faculty faculty, int days) {
        String leaveType = leave.getLeaveType();

        if (leaveType.equalsIgnoreCase("CasualLeave"))
            return new CasualLeave(leaveType, faculty, days);

        if (leaveType.equalsIgnoreCase("MedicalLeave"))
            return new MedicalLeave(leaveType, faculty, days);

        if (leaveType.equalsIgnoreCase("OnDutyLeave"))
            return new OnDutyLeave(leaveType, faculty, days);

        return null;
    }
}