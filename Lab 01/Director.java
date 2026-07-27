public class Director extends LeaveApprover {
    public void approveLeave(Leave i) {
        System.out.println("Leave of " + i.getDays() + " approved by the Director");
    }
}
