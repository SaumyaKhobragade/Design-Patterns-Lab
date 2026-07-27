public abstract class LeaveFactory {
    public abstract Leave getLeave(
        String leaveType,
        Faculty faculty,
        int days
    );
}