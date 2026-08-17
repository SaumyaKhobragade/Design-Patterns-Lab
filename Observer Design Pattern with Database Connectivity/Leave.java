public abstract class Leave {
    private int leaveId;
    private final String leaveType;
    private final Faculty faculty;
    private final int days;
    private int freeLeaveDays;
    private int unpaidLeaveDays;
    private int salaryDeduction;

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

    public int getFreeLeaveDays() {
        return freeLeaveDays;
    }

    public void setFreeLeaveDays(int freeLeaveDays) {
        this.freeLeaveDays = freeLeaveDays;
    }

    public int getUnpaidLeaveDays() {
        return unpaidLeaveDays;
    }

    public void setUnpaidLeaveDays(int unpaidLeaveDays) {
        this.unpaidLeaveDays = unpaidLeaveDays;
    }

    public int getSalaryDeduction() {
        return salaryDeduction;
    }

    public void setSalaryDeduction(int salaryDeduction) {
        this.salaryDeduction = salaryDeduction;
    }

    abstract void leave();
}
