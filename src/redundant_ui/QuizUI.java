package redundant_ui;

import javax.swing.*;
import java.awt.*;
import methods.QuizMethods;

public class QuizUI extends JFrame {
    private JTextField titleField, marksField, courseIdField;
    private JButton addButton, viewButton;

    public QuizUI() {
        setTitle("Quiz Management");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Quiz Title:");
        titleField = new JTextField();
        JLabel marksLabel = new JLabel("Total Marks:");
        marksField = new JTextField();
        JLabel courseLabel = new JLabel("Course ID:");
        courseIdField = new JTextField();

        addButton = new JButton("Add Quiz");
        viewButton = new JButton("View Quizzes");

        add(titleLabel);
        add(titleField);
        add(marksLabel);
        add(marksField);
        add(courseLabel);
        add(courseIdField);
        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> {
            String title = titleField.getText();
            int marks = Integer.parseInt(marksField.getText());
            int courseId = Integer.parseInt(courseIdField.getText());
            QuizMethods.addQuiz(courseId, title, marks);
        });

        viewButton.addActionListener(e -> JOptionPane.showMessageDialog(this, QuizMethods.getQuizzes()));

        setVisible(true);
    }
}
