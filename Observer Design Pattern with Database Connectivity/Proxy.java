public class Proxy {
    private final ProxyStore proxyStore;

    public Proxy() {
        proxyStore = new ProxyStore();
    }

    public void submitLeaveRequest(Faculty faculty, String password, Leave leave) {
        if (!proxyStore.authenticate(faculty, password)) {
            System.out.println("Access denied.");
            return;
        }

        System.out.println("Authenticated - Proxy.");
        LeaveManagementSystem.getInstance();
        LeaveManagementSystem.approve(leave);
    }
}
