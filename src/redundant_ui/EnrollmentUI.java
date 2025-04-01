package redundant_ui;

import javax.swing.*;
import java.awt.*;
import methods.EnrollmentMethods;

public class EnrollmentUI extends JFrame {
    private JTextField studentIdField, courseIdField, paymentIdField, dateField;
    private JButton addButton, viewButton;

    public EnrollmentUI() {
        setTitle("Enrollment Management");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        setLocationRelativeTo(null);

        JLabel studentLabel = new JLabel("Student ID:");
        studentIdField = new JTextField();
        JLabel courseLabel = new JLabel("Course ID:");
        courseIdField = new JTextField();
        JLabel paymentLabel = new JLabel("Payment ID:");
        paymentIdField = new JTextField();
        JLabel dateLabel = new JLabel("Enrollment Date (YYYY-MM-DD):");
        dateField = new JTextField();

        addButton = new JButton("Add Enrollment");
        viewButton = new JButton("View Enrollments");

        add(studentLabel);
        add(studentIdField);
        add(courseLabel);
        add(courseIdField);
        add(paymentLabel);
        add(paymentIdField);
        add(dateLabel);
        add(dateField);
        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> {
            int studentId = Integer.parseInt(studentIdField.getText());
            int courseId = Integer.parseInt(courseIdField.getText());
            int paymentId = Integer.parseInt(paymentIdField.getText());
            String enrollmentDate = dateField.getText();
            EnrollmentMethods.addEnrollment(studentId, courseId, enrollmentDate, paymentId);
        });

        viewButton.addActionListener(e -> JOptionPane.showMessageDialog(this, EnrollmentMethods.getEnrollments()));

        setVisible(true);
    }
}
