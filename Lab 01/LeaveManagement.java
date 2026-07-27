public class LeaveManagement {
    static LeaveManagement instance;
    LeaveApprover approver;
    
    public static LeaveManagement getInstance(){
        if (instance == null){
            instance = new LeaveManagement();
        }
        return instance;
    }

    public void approveLeave(Leave leave){
        approver.approveLeave(leave);
    }

    public void setApprover(LeaveApprover approver){
        this.approver = approver;
    }
}
