import java.util.List;

public interface BillingStrategy {
    double calculateBill(Patient patient, List<Service> services);
}
