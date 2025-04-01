package methods;
import database.DBConnection;
import models.Quiz;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizMethods {
    public static List<Quiz> getQuizzesByCourse(int courseId) {
        List<Quiz> quizzes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Quizzes WHERE CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt("QuizID"), rs.getInt("CourseID"), rs.getString("QuizTitle"), rs.getInt("TotalMarks"));
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    public static String getQuizDetails(int quizID) {
        Quiz quiz = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Quizzes WHERE QuizID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quizID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                quiz = new Quiz(rs.getInt("QuizID"), rs.getInt("CourseID"), rs.getString("QuizTitle"), rs.getInt("TotalMarks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (quiz == null) return null;
        return quiz.toString();
    }


    public static List<Quiz> getQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Quizzes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt("QuizID"), rs.getInt("CourseID"), rs.getString("QuizTitle"), rs.getInt("TotalMarks"));
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    public static boolean addQuiz(int courseId, String quizTitle, int totalMarks) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Quizzes (CourseID, QuizTitle, TotalMarks) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, courseId);
            stmt.setString(2, quizTitle);
            stmt.setInt(3, totalMarks);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
