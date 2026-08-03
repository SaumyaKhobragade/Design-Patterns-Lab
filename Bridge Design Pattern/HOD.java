public class HOD extends LeaveApprover {
    public void approveLeave(Leave i) {
        if (i.getDays() <= 2) {
            System.out.println("Leave of " + i.getDays() + " approved by the HOD");
            i.notifyFaculty();
        }
        else {
            System.out.println("Passed to Principal.");
            nextApprover.approveLeave(i);
        }
    }
}
