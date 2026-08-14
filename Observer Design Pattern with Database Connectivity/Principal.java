public class Principal extends LeaveApprover {
    public void approveLeave(Leave leave) {
        if (leave.getDays() <= 7) {
            System.out.println("Leave of " + leave.getDays() + " approved by the Principal");
            leave.notifyFaculty();
            LeaveManagementSystem.getCoordinator().leaveApproved(leave);
        } else {
            System.out.println("Passed to Director.");
            nextApprover.approveLeave(leave);
        }
    }
}
