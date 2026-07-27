public class LeaveManagementSystem {
    private static LeaveManagementSystem instance = null;
    private static LeaveApprover entryPoint;

    public static LeaveManagementSystem getInstance() {
        if(instance == null) {

            instance = new LeaveManagementSystem();
            formChain();
            return instance;

        }
        System.out.println("Returning existing instance.");
        return instance;
    }

    public static void setEntryPoint(LeaveApprover l) {
        LeaveManagementSystem.entryPoint = l;
    }

    public static void approve(Leave l) {
        entryPoint.approveLeave(l);
    }
    public static void formChain() {
        LeaveApprover hod= new HOD();
        LeaveApprover principal= new Principal();
        LeaveApprover director = new Director();

        hod.nextApprover = principal;
        principal.nextApprover = director;
        LeaveManagementSystem.setEntryPoint(hod);

    }
}
