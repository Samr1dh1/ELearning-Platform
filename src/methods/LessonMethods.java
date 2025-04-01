package methods;
import database.DBConnection;
import models.Lesson;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonMethods {
    public static List<Lesson> getLessonsByCourse(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Lessons WHERE CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson(rs.getInt("LessonID"), rs.getInt("CourseID"), rs.getString("LessonTitle"), rs.getString("Content"), rs.getString("VideoURL"));
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }


    public static boolean addLesson(int courseId, String lessonTitle, String content, String videoURL) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Lessons (CourseID, LessonTitle, Content, VideoURL) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.setString(2, lessonTitle);
            stmt.setString(3, content);
            stmt.setString(4, videoURL);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean updateLesson(int lessonID, String lessonTitle, String content, String videoURL) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Lessons SET LessonTitle = ?, Content = ?, VideoURL = ? WHERE LessonID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lessonTitle);
            stmt.setString(2, content);
            stmt.setString(3, videoURL);
            stmt.setInt(4, lessonID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteLesson(int lessonID) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Lessons WHERE LessonID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lessonID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Lessons";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson(rs.getInt("LessonID"), rs.getInt("CourseID"), rs.getString("LessonTitle"), rs.getString("Content"), rs.getString("VideoURL"));
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }


}
