package methods;

import database.DBConnection;
import models.Student;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentMethods {
    public static Student getStudent(int studentID) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Students WHERE StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Student student = new Student(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                );
                return student;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Students";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
                );
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addStudent(String name, String email, String contact) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Students (Name, Email, Contact) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, contact);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteStudent(int studentID) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Students WHERE StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}