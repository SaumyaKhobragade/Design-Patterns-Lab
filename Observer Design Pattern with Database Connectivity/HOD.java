public class HOD extends LeaveApprover {
    public void approveLeave(Leave leave) {
        if (leave.getDays() <= 2) {
            System.out.println("Leave of " + leave.getDays() + " approved by the HOD");
            leave.notifyFaculty();
            LeaveManagementSystem.getCoordinator().leaveApproved(leave);
        } else {
            System.out.println("Passed to Principal.");
            nextApprover.approveLeave(leave);
        }
    }
}
