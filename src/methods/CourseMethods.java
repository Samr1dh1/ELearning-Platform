package methods;

import database.DBConnection;
import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseMethods {
    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Courses";
            PreparedStatement stmt = conn.prepareStatement(sql);
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

    public static boolean updatePrice(int courseID, double newPrice) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Courses SET Price = ? WHERE CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, courseID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Course> getCoursesByInstructor(int instructorID) {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Courses WHERE InstructorID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, instructorID);
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

    public static String getCourseDetails(int courseID) {
        Course course = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Courses WHERE CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                course = new Course(rs.getInt("CourseID"), rs.getString("CourseName"), rs.getString("Description"), rs.getInt("InstructorID"), rs.getDouble("Price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (course == null) return null;
        return course.toString();
    }
}
