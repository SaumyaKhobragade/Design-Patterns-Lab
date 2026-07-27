public class Principal extends LeaveApprover {
    public void approveLeave(Leave i) {
        if (i.days <= 7)
            System.out.println("Leave of " + i.days + " approved by the Principal");
        else {
            System.out.println("Passed to Director.");
            nextApprover.approveLeave(i);
        }
    }
}
