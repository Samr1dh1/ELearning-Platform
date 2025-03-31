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


}
