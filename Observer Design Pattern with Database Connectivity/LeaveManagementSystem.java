public class LeaveManagementSystem {
    private static LeaveManagementSystem instance = null;
    private static LeaveApprover entryPoint;
    private static LeaveCoordinator coordinator;

    private LeaveManagementSystem() {

    }

    public static LeaveManagementSystem getInstance() {
        if (instance == null) {
            instance = new LeaveManagementSystem();
            formChain();
            setupCoordinator();
            System.out.println("Leave Management System created.");
        } else {
            System.out.println("Returning existing instance.");
        }

        return instance;
    }

    public static void setEntryPoint(LeaveApprover leaveApprover) {
        entryPoint = leaveApprover;
    }

    public static void setCoordinator(LeaveCoordinator leaveCoordinator) {
        coordinator = leaveCoordinator;
    }

    public static LeaveCoordinator getCoordinator() {
        return coordinator;
    }

    public static void approve(Leave leave) {
        if (leave == null) {
            System.out.println("Invalid leave request.");
            return;
        }
        entryPoint.approveLeave(leave);
    }

    private static void formChain() {
        LeaveApprover hod = new HOD();
        LeaveApprover principal = new Principal();
        LeaveApprover director = new Director();
        hod.SetNextApprover(principal);
        principal.SetNextApprover(director);
        setEntryPoint(hod);
    }

    private static void setupCoordinator() {
        LeaveDAO leaveDAO = new LeaveDAO();
        LeaveCoordinator leaveCoordinator = new LeaveCoordinator();
        HRDepartment hr = new HRDepartment(leaveDAO);
        AccountsDepartment accounts = new AccountsDepartment();
        leaveCoordinator.registerObserver(hr);
        leaveCoordinator.registerObserver(accounts);
        setCoordinator(leaveCoordinator);
    }
}
