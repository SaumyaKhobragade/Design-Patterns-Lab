public class Outpatient extends Patient {
    private String doctorName;

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "OUTPATIENT\n"
                + super.toString()
                + "\nDoctor Name: " + doctorName;
    }
}
