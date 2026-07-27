
public abstract class LeaveApprover {
    LeaveApprover nextApprover;
    
    public void SetNextApprover(LeaveApprover nextApprover){
        this.nextApprover = nextApprover;
    }
    
    public abstract void approveLeave(Leave i);
}
