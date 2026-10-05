import java.util.ArrayList;
import java.util.List;

public class HospitalCoordinator implements HospitalMediator {
    private List<Department> departments = new ArrayList<>();

    @Override
    public void registerDepartment(Department dept) {
        departments.add(dept);
        dept.setMediator(this);
    }

    @Override
    public void sendMessage(Department from, Department to, String message) {
        System.out.println(from.getName() + " -> " + to.getName() + ": " + message);
        to.receiveMessage(message);
    }

    @Override
    public void notify(String message) {
        for (Department dept : departments) {
            dept.receiveMessage(message);
        }
    }
}
