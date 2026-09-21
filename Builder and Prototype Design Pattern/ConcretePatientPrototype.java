public class ConcretePatientPrototype implements Prototype {
    private Patient patient;

    public ConcretePatientPrototype(Patient patient) {
        this.patient = patient;
    }

    @Override
    public Patient clone() {
        Patient clonedPatient = new Patient();

        clonedPatient.setPatientId(patient.patientId);
        clonedPatient.setName(patient.name);
        clonedPatient.setAge(patient.age);

        clonedPatient.setInsuranceDetails(
                patient.insuranceDetails);

        clonedPatient.setRoomType(
                patient.roomType);

        clonedPatient.setBloodGroup(
                patient.bloodGroup);

        clonedPatient.setAllergies(
                patient.allergies);

        clonedPatient.setEmergencyContact(
                patient.emergencyContact);

        clonedPatient.setMedicalHistory(
                patient.medicalHistory);

        return clonedPatient;
    }
}
