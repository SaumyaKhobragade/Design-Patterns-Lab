public abstract class Leave {
    private final String leaveType;
    private final Faculty faculty;
    private final int days;

    public Leave(String leaveType, Faculty faculty, int days) {
        this.leaveType = leaveType;
        this.faculty = faculty;
        this.days = days;
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
