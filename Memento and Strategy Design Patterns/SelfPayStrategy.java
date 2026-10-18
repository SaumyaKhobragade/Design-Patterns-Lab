import java.util.List;

public class SelfPayStrategy implements BillingStrategy {
    @Override
    public double calculateBill(Patient patient, List<Service> services) {
        double total = 0.0;
        if (services != null) {
            for (Service s : services) {
                if (s != null) {
                    total += s.getAmount();
                }
            }
        }
        return total * 1.0;
    }
}
