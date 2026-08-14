import java.util.ArrayList;

public class LeaveCoordinator {
    private final ArrayList<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Leave leave) {
        for (Observer observer : observers) {
            observer.update(leave);
        }
    }

    public void leaveApproved(Leave leave) {
        System.out.println("\nLeave Coordinator: Leave approved.");
        notifyObservers(leave);
    }
}
