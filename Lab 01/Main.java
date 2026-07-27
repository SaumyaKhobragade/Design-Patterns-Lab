public class Main {
    public static void main(String[] args) {
        
        LeaveManagement leaveManagement = LeaveManagement.getInstance();
        
        LeaveApprover a = new HOD();
        LeaveApprover b = new Principal();
        LeaveApprover c = new Director();
        a.SetNextApprover(b);
        b.SetNextApprover(c);
        
        a.approveLeave(new Leave(1));
        a.approveLeave(new Leave(6));
        a.approveLeave(new Leave(15));
        
        leaveManagement.setApprover(a);
        
        leaveManagement.approveLeave(new Leave(1));
        leaveManagement.approveLeave(new Leave(6));
        leaveManagement.approveLeave(new Leave(15));
    }
}
