public class AccountsDepartment implements Observer {
    @Override
    public void update(Leave leave) {

        System.out.println("Accounts Department notified: " + "Processing salary deduction if applicable.");
    }
}
