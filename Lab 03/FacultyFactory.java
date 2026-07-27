public class FacultyFactory {
    public static Faculty getFaculty(String facultyType, String facultyName) {
        if (facultyType == null) {
            return null;
        } else if (facultyType.equalsIgnoreCase("Permanent")) {
            return new PermanentFaculty(facultyType, facultyName);
        } else if (facultyType.equalsIgnoreCase("Contract")) {
            return new ContractFaculty(facultyType, facultyName);
        } else {
            return null;
        }
    }
}
