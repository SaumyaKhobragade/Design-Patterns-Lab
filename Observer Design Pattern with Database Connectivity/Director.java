public class Director extends LeaveApprover {
    public void approveLeave(Leave leave) {
        System.out.println("Leave of " + leave.getDays() + " approved by the Director");
        leave.notifyFaculty();

        LeaveManagementSystem.getCoordinator().leaveApproved(leave);
    }
}
