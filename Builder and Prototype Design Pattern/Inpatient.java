public class Inpatient extends Patient {
    private String roomType;
    private String admissionDate;

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        super.setRoomType(roomType);
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public String toString() {
        return "INPATIENT\n"
                + super.toString()
                + "\nAdmission Date: " + admissionDate;
    }
}
