package methods;
import database.DBConnection;
import java.sql.*;

public class QuizResultMethods {
    public static boolean saveQuizResult(int studentId, int quizId, int score) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO QuizResults (StudentID, QuizID, Score) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setInt(2, quizId);
            stmt.setInt(3, score);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void displayStudentQuizResults(int studentId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT qr.Score, q.QuizTitle FROM QuizResults qr, Quizzes q WHERE qr.QuizID = q.QuizID AND qr.StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Quiz Title: " + rs.getString(2) + ", Score: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
