import java.util.List;

public class BillingContext {
    private BillingStrategy strategy;

    public BillingContext() {
    }

    public BillingContext(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public BillingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateBill(Patient patient, List<Service> services) {
        if (strategy == null) {
            throw new IllegalStateException("Billing strategy has not been set.");
        }
        return strategy.calculateBill(patient, services);
    }
}
