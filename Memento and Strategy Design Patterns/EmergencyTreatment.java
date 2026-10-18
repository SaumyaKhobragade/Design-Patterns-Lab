public class EmergencyTreatment extends AbstractPatientTreatment implements PatientTreatement {
    public EmergencyTreatment(Patient patient) {
        super(patient);
    }
    
    @Override
    void performTests() {
        System.out.println("Performing emergency tests.");
    }

    @Override
    void processBillingAndDischarge() {
        System.out.println("Processing billing and discharge for emergency treatment.");
    }
}
