public class HRDepartment implements Observer {
    private final LeaveDAO leaveDAO;

    public HRDepartment(LeaveDAO leaveDAO) {
        this.leaveDAO = leaveDAO;
    }

    @Override
    public void update(Leave leave) {
        System.out.println("HR Department notified: Updating leave records.");
        leaveDAO.updateLeaveStatus(leave.getLeaveId(), "APPROVED");
    }
}
