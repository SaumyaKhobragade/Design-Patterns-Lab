public class InpatientTreatment extends AbstractPatientTreatment implements PatientTreatement {
    public InpatientTreatment(Patient patient) {
        super(patient);
    }

    @Override
    void performTests() {
        System.out.println("Performing inpatient tests.");
    }

    @Override
    void processBillingAndDischarge() {
        System.out.println("Processing billing and discharge for inpatient treatment.");
    }
}
