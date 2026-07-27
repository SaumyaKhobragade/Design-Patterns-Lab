public abstract class Faculty {
    private final String facultyType;
    private final String facultyName;

    public Faculty(String facultyType, String facultyName) {
        this.facultyType = facultyType;
        this.facultyName = facultyName;
    }

    public String getFacultyType() {
        return facultyType;
    }

    public String getFacultyName() {
        return facultyName;
    }
}
