public class OutpatientTreatment extends AbstractPatientTreatment implements PatientTreatement {
    public OutpatientTreatment(Patient patient) {
        super(patient);
    }

    @Override
    void performTests() {
        System.out.println("Performing outpatient tests.");
    }

    @Override
    void processBillingAndDischarge() {
        System.out.println("Processing billing and discharge for outpatient treatment.");
    }
}
