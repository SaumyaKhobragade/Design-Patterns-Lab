public class ContractFactory extends LeaveFactory {

    @Override
    public Leave getLeave(Leave leave, Faculty faculty, int days) {
        String leaveType = leave.getLeaveType();

        if (leaveType.equalsIgnoreCase("CasualLeave"))
            return new CasualLeave(leaveType, faculty, days);

        if (leaveType.equalsIgnoreCase("OnDutyLeave"))
            return new OnDutyLeave(leaveType, faculty, days);

        if (leaveType.equalsIgnoreCase("MedicalLeave")) {
            System.out.println("Medical Leave not allowed for Contract Faculty.");
            return null;
        }

        return null;
    }
}