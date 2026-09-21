public class ConcretePatientBuilder implements PatientBuilder {
    private Patient patient;

    public ConcretePatientBuilder() {
        reset();
    }

    @Override
    public void reset() {
        patient = new Patient();
    }

    @Override
    public void setPatientId(String patientId) {
        patient.setPatientId(patientId);
    }

    @Override
    public void setName(String name) {
        patient.setName(name);
    }

    @Override
    public void setAge(int age) {
        patient.setAge(age);
    }

    @Override
    public void setInsuranceDetails(String insuranceDetails) {
        patient.setInsuranceDetails(insuranceDetails);
    }

    @Override
    public void setRoomType(String roomType) {
        patient.setRoomType(roomType);
    }

    @Override
    public void setBloodGroup(String bloodGroup) {
        patient.setBloodGroup(bloodGroup);
    }

    @Override
    public void setAllergies(String allergies) {
        patient.setAllergies(allergies);
    }

    @Override
    public void setEmergencyContact(String emergencyContact) {
        patient.setEmergencyContact(emergencyContact);
    }

    @Override
    public void setMedicalHistory(String medicalHistory) {
        patient.setMedicalHistory(medicalHistory);
    }

    @Override
    public Patient getPatient() {
        return patient;
    }
}
