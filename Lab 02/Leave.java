public abstract class Leave {
    String leaveType;
    String facultyName;
    int days;

    public Leave(String leaveType, String facultyName, int days) {
        this.leaveType = leaveType;
        this.facultyName = facultyName;
        this.days = days;
    }

    public int getDays(){
       return days;
    }

    abstract void leave();
}
