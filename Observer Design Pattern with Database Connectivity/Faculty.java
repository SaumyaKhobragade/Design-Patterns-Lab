public abstract class Faculty {
    private final int facultyId;
    private final String facultyType;
    private final String facultyName;

    public Faculty(int facultyId, String facultyType, String facultyName) {
        this.facultyId = facultyId;
        this.facultyType = facultyType;
        this.facultyName = facultyName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyType() {
        return facultyType;
    }

    public String getFacultyName() {
        return facultyName;
    }
}
