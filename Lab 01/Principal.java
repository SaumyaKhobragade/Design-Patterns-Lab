public class Principal extends LeaveApprover {
    public void approveLeave(Leave i) {
        if (i.getDays() <= 7)
            System.out.println("Leave of " + i.getDays() + " approved by the Principal");
        else
            nextApprover.approveLeave(i);
    }
}
