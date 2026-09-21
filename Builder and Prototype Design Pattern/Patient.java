public class Patient {
    protected String patientId;
    protected String name;
    protected int age;

    protected String insuranceDetails;
    protected String roomType;
    protected String bloodGroup;
    protected String allergies;
    protected String emergencyContact;
    protected String medicalHistory;

    public Patient() {
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInsuranceDetails(String insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId
                + "\nName: " + name
                + "\nAge: " + age
                + "\nInsurance Details: " + insuranceDetails
                + "\nRoom Type: " + roomType
                + "\nBlood Group: " + bloodGroup
                + "\nAllergies: " + allergies
                + "\nEmergency Contact: " + emergencyContact
                + "\nMedical History: " + medicalHistory;
    }
}
