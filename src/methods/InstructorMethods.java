package methods;

import database.DBConnection;
import models.Instructor;
import java.sql.*;

public class InstructorMethods {
    public static boolean registerInstructor(Instructor instructor) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Instructors (Name, Email, Contact, Specialization) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, instructor.getName());
            stmt.setString(2, instructor.getEmail());
            stmt.setString(3, instructor.getContact());
            stmt.setString(4, instructor.getSpecialization());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
