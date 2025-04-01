package methods;
import database.DBConnection;
import models.Course;
import models.Student;

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


    public static void addEnrollment(int studentId, int courseId, String enrollmentDate, int paymentId) {

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate, PaymentID) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setString(3, enrollmentDate);
            stmt.setInt(4, paymentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getEnrollments() {
        List<Map<String, Object>> enrollments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Enrollments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Map<String, Object> enrollment = new HashMap<>();
                enrollment.put("EnrollmentID", rs.getInt("EnrollmentID"));
                enrollment.put("StudentID", rs.getInt("StudentID"));
                enrollment.put("CourseID", rs.getInt("CourseID"));
                enrollment.put("EnrollmentDate", rs.getString("EnrollmentDate"));
                enrollment.put("PaymentID", rs.getInt("PaymentID"));
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
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

    public static List<Student> getStudentsEnrolledInCourse(int courseId) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT s.* FROM Students s, Enrollments e WHERE s.StudentID = e.StudentID AND e.CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt("StudentID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("EnrollmentDate"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
