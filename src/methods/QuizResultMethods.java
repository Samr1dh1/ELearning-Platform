package methods;

import database.DBConnection;
import models.QuizResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<QuizResult> getStudentQuizResults(int studentId) {
        List<QuizResult> results = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT qr.QuizID, qr.Score FROM QuizResults qr WHERE qr.StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                results.add(new QuizResult(0, studentId, rs.getInt("QuizID"), rs.getInt("Score"))); // ✅ Corrected constructor
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
