import java.util.ArrayList;

public class LeaveCoordinator {
    private final ArrayList<Observer> observers = new ArrayList<>();
    private final LeaveDAO leaveDAO;
    private final HRDAO hrDAO;
    private final AccountsDAO accountsDAO;

    public LeaveCoordinator(LeaveDAO leaveDAO, HRDAO hrDAO, AccountsDAO accountsDAO) {
        this.leaveDAO = leaveDAO;
        this.hrDAO = hrDAO;
        this.accountsDAO = accountsDAO;
    }

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
        System.out.println("\nLeave Coordinator: " + "Leave approved.");
        int facultyId = leave.getFaculty().getFacultyId();
        int requestedDays = leave.getDays();
        int availableDays = hrDAO.getLeaveBalance(facultyId);

        if (availableDays < 0) {
            System.out.println("HR record not found.");
            return;
        }

        int freeDays = Math.min(requestedDays, availableDays);
        int unpaidDays = requestedDays - freeDays;

        int deduction = unpaidDays * AccountsDAO.getDeductionPerDay();

        leave.setFreeLeaveDays(freeDays);
        leave.setUnpaidLeaveDays(unpaidDays);
        leave.setSalaryDeduction(deduction);

        if (freeDays > 0) {
            hrDAO.reduceLeaveBalance(facultyId, freeDays);
        }

        leaveDAO.updateLeaveStatus(leave.getLeaveId(), "APPROVED");

        notifyObservers(leave);
    }
}
