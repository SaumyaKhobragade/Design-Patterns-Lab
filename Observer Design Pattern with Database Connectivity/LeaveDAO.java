import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveDAO {
    public int createLeave(Leave leave) {
        String sql = "INSERT INTO LeaveRequest " + "(FacultyID, Days, LeaveType, Status) " + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        java.sql.Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, leave.getFaculty().getFacultyId());
            statement.setInt(2, leave.getDays());
            statement.setString(3, leave.getLeaveType());
            statement.setString(4, "PENDING");

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                int leaveId = keys.getInt(1);
                leave.setLeaveId(leaveId);

                System.out.println("Leave created. Leave ID: " + leaveId);
                return leaveId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void getLeave(int leaveId) {
        String sql = "SELECT * FROM LeaveRequest " + "WHERE LeaveID = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, leaveId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("\n--- Leave Details ---");
                System.out.println("Leave ID: " + result.getInt("LeaveID"));
                System.out.println("Faculty ID: " + result.getInt("FacultyID"));
                System.out.println("Days: " + result.getInt("Days"));
                System.out.println("Leave Type: " + result.getString("LeaveType"));
                System.out.println("Status: " + result.getString("Status"));
            } else {
                System.out.println("Leave request not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLeaveStatus(int leaveId, String status) {
        String sql = "UPDATE LeaveRequest " + "SET Status = ? " + "WHERE LeaveID = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, leaveId);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Database updated: Leave " + leaveId + " → " + status);
            } else {
                System.out.println("Leave request not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLeave(int leaveId) {
        String sql = "DELETE FROM LeaveRequest " + "WHERE LeaveID = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, leaveId);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Leave request " + leaveId + " deleted.");
            } else {
                System.out.println("Leave request not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllLeaves() {
        String sql = "SELECT * FROM LeaveRequest";
    
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet result = statement.executeQuery()) {
            System.out.println("\n--- All Leave Requests ---");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("LeaveID") + " | Faculty: " + result.getInt("FacultyID") + " | Type: " + result.getString("LeaveType") + " | Days: " + result.getInt("Days") + " | Status: " + result.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
