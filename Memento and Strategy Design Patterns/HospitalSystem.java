import java.util.List;

public class HospitalSystem {
    private BillingContext billingContext;
    private Caretaker caretaker;

    public HospitalSystem() {
        this.billingContext = new BillingContext();
        this.caretaker = new Caretaker();
    }

    public HospitalSystem(BillingContext billingContext, Caretaker caretaker) {
        this.billingContext = (billingContext != null) ? billingContext : new BillingContext();
        this.caretaker = (caretaker != null) ? caretaker : new Caretaker();
    }

    public BillingContext getBillingContext() {
        return billingContext;
    }

    public void setBillingContext(BillingContext billingContext) {
        this.billingContext = billingContext;
    }

    public Caretaker getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void selectBillingStrategy(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Billing strategy type cannot be null.");
        }
        String normalized = type.trim();
        if (normalized.equalsIgnoreCase("Self-Pay") || normalized.equalsIgnoreCase("SelfPay")) {
            billingContext.setStrategy(new SelfPayStrategy());
        } else if (normalized.equalsIgnoreCase("Insurance")) {
            billingContext.setStrategy(new InsuranceStrategy());
        } else if (normalized.equalsIgnoreCase("Corporate")) {
            billingContext.setStrategy(new CorporateStrategy());
        } else if (normalized.equalsIgnoreCase("Senior Citizen") || normalized.equalsIgnoreCase("SeniorCitizen")) {
            billingContext.setStrategy(new SeniorCitizenStrategy());
        } else {
            throw new IllegalArgumentException("Invalid billing strategy: " + type);
        }
    }

    public double generateBill(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        return billingContext.calculateBill(patient, patient.getServices());
    }

    public double generateBill(Patient patient, List<Service> services) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
        return billingContext.calculateBill(patient, services);
    }

    public void updateTreatmentNotes(TreatmentRecord record, String notes) {
        if (record != null) {
            caretaker.saveState(record);
            record.setNotes(notes);
        }
    }

    public void undoTreatmentNote(TreatmentRecord record) {
        if (record != null) {
            caretaker.undo(record);
        }
    }

    public boolean canUndo() {
        return caretaker.canUndo();
    }
}
