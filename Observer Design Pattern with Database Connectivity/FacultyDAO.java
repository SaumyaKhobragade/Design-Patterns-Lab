import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyDAO {
    public Faculty getFacultyById(int facultyId) {
        String sql = "SELECT FacultyID, Name, Type " + "FROM Faculty " + "WHERE FacultyID = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facultyId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return FacultyFactory.getFaculty(result.getInt("FacultyID"), result.getString("Type"), result.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void displayAllFaculty() {
        String sql = "SELECT FacultyID, Name, Type " + "FROM Faculty";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet result = statement.executeQuery()) {
            System.out.println("\n--- Faculty Records ---");
            while (result.next()) {
                System.out.println(result.getInt("FacultyID") + " | " + result.getString("Name") + " | " + result.getString("Type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
