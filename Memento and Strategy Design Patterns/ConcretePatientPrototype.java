public class ConcretePatientPrototype implements Prototype {
        private Patient patient;

        public ConcretePatientPrototype(Patient patient) {
                this.patient = patient;
        }

        @Override
        public Patient clone() {
                Patient clonedPatient = new Patient();

                clonedPatient.setId(patient.id);
                clonedPatient.setPatientId(patient.patientId);
                clonedPatient.setName(patient.name);
                clonedPatient.setAge(patient.age);

                clonedPatient.setType(patient.type);

                clonedPatient.setPaymentCategory(patient.paymentCategory);
                clonedPatient.setContactNo(patient.contactNo);
                clonedPatient.setInsuranceDetails(patient.insuranceDetails);
                clonedPatient.setRoomType(patient.roomType);
                clonedPatient.setBloodGroup(patient.bloodGroup);
                clonedPatient.setAllergies(patient.allergies);
                clonedPatient.setEmergencyContact(patient.emergencyContact);
                clonedPatient.setMedicalHistory(patient.medicalHistory);
                if (patient.services != null) {
                    clonedPatient.setServices(new java.util.ArrayList<>(patient.services));
                }

                return clonedPatient;
        }
}
