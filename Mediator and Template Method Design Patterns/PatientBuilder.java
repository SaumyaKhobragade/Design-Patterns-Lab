public interface PatientBuilder {
    void reset();
    void setPatientId(String patientId);
    void setName(String name);
    void setAge(int age);
    void setInsuranceDetails(String insuranceDetails);
    void setRoomType(String roomType);
    void setBloodGroup(String bloodGroup);
    void setAllergies(String allergies);
    void setEmergencyContact(String emergencyContact);
    void setMedicalHistory(String medicalHistory);
    Patient getPatient();
}
