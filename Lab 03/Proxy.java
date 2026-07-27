public class Proxy {
    public void submitLeaveRequest(Faculty faculty, String password, String lType, int days) {
        if(!ProxyStore.authenticate(faculty, password)) {
            System.out.println("Access denied.");
        } else {
            System.out.println("Authenticated - Proxy.");
            LeaveManagementSystem.getInstance();
            Leave leave =
                LeaveAbstractFactory.getLeave(
                    lType,
                    faculty,
                    days
            );

            LeaveManagementSystem.approve(leave);
        }
    }
}
