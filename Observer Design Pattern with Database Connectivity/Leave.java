public abstract class Leave {
    private int leaveId;
    private final String leaveType;
    private final Faculty faculty;
    private final int days;

    protected Notification notification;

    public Leave(String leaveType, Faculty faculty, int days) {
        this.leaveType = leaveType;
        this.faculty = faculty;
        this.days = days;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public void notifyFaculty() {
        if (notification != null) {
            notification.sendNotification(faculty, this);
        }
    }

    public String getLeaveType() {
        return leaveType;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getDays() {
        return days;
    }

    abstract void leave();
}
