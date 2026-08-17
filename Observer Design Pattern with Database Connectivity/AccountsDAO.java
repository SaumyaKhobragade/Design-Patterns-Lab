import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsDAO {
    private static final int DEDUCTION_PER_DAY = 1000;

    public int getSalary(int facultyId) {
        String sql = "SELECT Salary " + "FROM ACC " + "WHERE FacultyID = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getInt("Salary");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void deductSalary(int facultyId, int amount) {
        String sql = "UPDATE ACC " + "SET Salary = Salary - ? " + "WHERE FacultyID = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, amount);
            statement.setInt(2, facultyId);

            statement.executeUpdate();

            System.out.println("Accounts: ₹" + amount + " deducted from salary.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getDeductionPerDay() {
        return DEDUCTION_PER_DAY;
    }
}
