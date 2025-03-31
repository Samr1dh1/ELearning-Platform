package methods;
import database.DBConnection;
import models.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethods {
    public static boolean processPayment(int studentId, double amount) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Payments (StudentID, Amount, PaymentDate, Status) VALUES (?, ?, CURDATE(), 'Completed')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setDouble(2, amount);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Payment> getStudentPayments(int studentId) {
        List<Payment> payments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT p.* FROM Payments p, Enrollments e WHERE p.StudentID = e.StudentID AND e.StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("PaymentID"),
                        rs.getInt("StudentID"),
                        rs.getDouble("Amount"),
                        rs.getString("PaymentDate"),
                        rs.getString("Status")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
