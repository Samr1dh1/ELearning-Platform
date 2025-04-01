package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import models.Course;
import models.Payment;
import models.QuizResult;
import methods.QuizResultMethods;
import methods.EnrollmentMethods;
import methods.PaymentMethods;
// Assume you have a method to get quiz results, e.g., QuizResultMethods.getQuizResultsForStudent(int studentId)

public class StudentUI extends JFrame {

    private final int studentId = 1; // For demo purposes

    public StudentUI() {
        setTitle("Student UI");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: Enrolled Courses
        JTable coursesTable = new JTable();
        DefaultTableModel coursesModel = new DefaultTableModel(new Object[]{"Course ID", "Course Name"}, 0);
        // Retrieve courses enrolled by student
        List<Course> courses = EnrollmentMethods.getStudentCourses(studentId);
        for (Course c : courses) {
            coursesModel.addRow(new Object[]{c.getCourseID(), c.getCourseName()});
        }
        coursesTable.setModel(coursesModel);
        JPanel coursesPanel = new JPanel(new BorderLayout());
        coursesPanel.add(new JScrollPane(coursesTable), BorderLayout.CENTER);
        tabbedPane.addTab("Enrolled Courses", coursesPanel);

        // Tab 2: Payments
        JTable paymentsTable = new JTable();
        DefaultTableModel paymentsModel = new DefaultTableModel(new Object[]{"Payment ID", "Amount", "Status"}, 0);
        List<Payment> payments = PaymentMethods.getStudentPayments(studentId);
        for (Payment p : payments) {
            paymentsModel.addRow(new Object[]{p.getPaymentID(), p.getAmount(), p.getStatus()});
        }
        paymentsTable.setModel(paymentsModel);
        JPanel paymentsPanel = new JPanel(new BorderLayout());
        paymentsPanel.add(new JScrollPane(paymentsTable), BorderLayout.CENTER);
        tabbedPane.addTab("Payments", paymentsPanel);

        // Tab 3: Quiz Results
        JTable quizTable = new JTable();
        DefaultTableModel quizModel = new DefaultTableModel(new Object[]{"Quiz ID", "Quiz Title", "Score"}, 0);
        // Retrieve quiz results for the student – ensure you have a method for this.
        List<QuizResult> quizResults = QuizResultMethods.getStudentQuizResults(studentId);
        for (QuizResult qr : quizResults) {
            // Assuming QuizResult has a getQuizTitle() method, otherwise modify accordingly.
            quizModel.addRow(new Object[]{qr.getQuizID(), "Quiz Title", qr.getScore()});
        }
        quizTable.setModel(quizModel);
        JPanel quizPanel = new JPanel(new BorderLayout());
        quizPanel.add(new JScrollPane(quizTable), BorderLayout.CENTER);
        tabbedPane.addTab("Quiz Results", quizPanel);

        // Optionally, add an additional tab to display all students/instructors/courses
        // For brevity, this example focuses on the main student data.

        add(tabbedPane);
    }
}
