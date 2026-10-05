public abstract class AbstractPatientTreatment {
    protected Patient patient;

    public AbstractPatientTreatment(Patient patient) {
        this.patient = patient;
    }

    void registerPatient() {
        System.out.println("Patient registered successfully.");
    }

    void consultDoctor() {
        System.out.println("Consulting with the doctor.");
    }

    abstract void performTests();

    protected void generatePrescription() {
        System.out.println("Generating prescription.");
    }
    
    abstract void processBillingAndDischarge();

    public final void processTreatment() {
        registerPatient();
        consultDoctor();
        performTests();
        generatePrescription();
        processBillingAndDischarge();
    }
}
