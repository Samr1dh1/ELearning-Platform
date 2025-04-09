package methods;

import database.DBConnection;
import models.Instructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorMethods {
    public static boolean addInstructor(String name, String email, String contact, String specialization) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Instructors (Name, Email, Contact, Specialization) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, contact);
            stmt.setString(4, specialization);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Instructor> getInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Instructors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Instructor instructor = new Instructor(
                        rs.getInt("InstructorID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Contact"),
                        rs.getString("Specialization")
                );
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }
}
