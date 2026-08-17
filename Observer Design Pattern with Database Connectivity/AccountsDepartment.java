public class AccountsDepartment implements Observer {
    private final AccountsDAO accountsDAO;

    public AccountsDepartment(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    @Override
    public void update(Leave leave) {
        System.out.println("Accounts Department notified.");
        int deduction = leave.getSalaryDeduction();

        if (deduction > 0) {
            accountsDAO.deductSalary(leave.getFaculty().getFacultyId(), deduction);
        } else {
            System.out.println("Accounts: No salary deduction.");
        }
    }
}
