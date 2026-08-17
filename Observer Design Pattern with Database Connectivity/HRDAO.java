import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HRDAO {
    public int getLeaveBalance(int facultyId) {
        String sql = "SELECT LeaveBalance " + "FROM HR " + "WHERE FacultyID = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getInt("LeaveBalance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void reduceLeaveBalance(int facultyId, int days) {
        String sql = "UPDATE HR " + "SET LeaveBalance = LeaveBalance - ? " + "WHERE FacultyID = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, days);
            statement.setInt(2, facultyId);
            statement.executeUpdate();

            System.out.println("HR: Leave balance reduced by " + days + " day(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
