public class FacultyFactory {
    public static Faculty getFaculty(int facultyId, String facultyType, String facultyName) {
        if (facultyType == null) {
            return null;
        }

        if (facultyType.equalsIgnoreCase("Permanent")) {
            return new PermanentFaculty(facultyId, facultyType, facultyName);
        }

        if (facultyType.equalsIgnoreCase("Contract")) {
            return new ContractFaculty(facultyId, facultyType, facultyName);
        }

        return null;
    }
}
