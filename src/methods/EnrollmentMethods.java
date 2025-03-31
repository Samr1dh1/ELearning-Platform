package methods;
import database.DBConnection;
import models.Course;

import java.sql.*;
import java.util.*;


public class EnrollmentMethods {
    public static boolean enrollStudent(int studentId, int courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate) VALUES (?, ?, CURDATE())";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteEnrollment(int studentId, int courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Enrollments WHERE StudentID = ? AND CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public static List<Course> getStudentCourses(int studentId) {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT c.* FROM Courses c, Enrollments e WHERE c.CourseID = e.CourseID AND e.StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course(rs.getInt("CourseID"), rs.getString("CourseName"), rs.getString("Description"), rs.getInt("InstructorID"), rs.getDouble("Price"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
