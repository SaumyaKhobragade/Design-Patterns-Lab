import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProxyStore {
    public boolean authenticate(
            Faculty faculty,
            String password) {

        String sql = "SELECT Password " + "FROM Faculty " + "WHERE FacultyID = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, faculty.getFacultyId());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String storedPassword = result.getString("Password");
                return storedPassword.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
