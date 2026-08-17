public class LeaveAbstractFactory {
    public static Leave getLeave(String leaveType, Faculty faculty, int days) {
        LeaveFactory factory;

        if (faculty instanceof PermanentFaculty) {
            factory = new PermanentFactory();
        } else if (faculty instanceof ContractFaculty) {
            factory = new ContractFactory();
        } else {
            return null;
        }

        return factory.getLeave(leaveType, faculty, days);
    }
}
