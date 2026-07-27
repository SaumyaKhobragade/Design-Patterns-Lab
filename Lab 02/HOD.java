public class HOD extends LeaveApprover {
    public void approveLeave(Leave i) {
        if (i.days <= 2)
            System.out.println("Leave of " + i.days + " approved by the HOD");
        else {
            System.out.println("Passed to Principal.");
            nextApprover.approveLeave(i);
        }
    }
}
