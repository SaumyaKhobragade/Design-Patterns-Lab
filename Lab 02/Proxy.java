public class Proxy {
    public void submitLeaveRequest(String username,String password,String lType,int days) {
        if(!ProxyStore.authenticate(username, password)) {
            System.out.println("Access denied.");
        } else {
            System.out.println("Authenticated - Proxy.");
            LeaveManagementSystem.getInstance();
            LeaveManagementSystem.approve(LeaveFactory.getLeave(lType, username, days));
        }
    }
}
