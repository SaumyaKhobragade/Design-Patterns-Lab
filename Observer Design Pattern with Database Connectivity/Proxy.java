public class Proxy {
    public void submitLeaveRequest(Faculty faculty, String password, Leave leave) {
        if (!ProxyStore.authenticate(faculty, password)) {
            System.out.println("Access denied.");
            return;
        }

        System.out.println("Authenticated - Proxy.");

        LeaveManagementSystem.getInstance();

        LeaveManagementSystem.approve(leave);
    }
}
