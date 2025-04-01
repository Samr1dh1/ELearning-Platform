package ui;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    public MainUI() {
        setTitle("E-Learning Main UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton studentButton = new JButton("Student");
        JButton courseButton = new JButton("Course");
        JButton instructorButton = new JButton("Instructor");

        studentButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new StudentUI().setVisible(true));
        });
        courseButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new CourseUI().setVisible(true));
        });
        instructorButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new InstructorUI().setVisible(true));
        });

        add(studentButton);
        add(courseButton);
        add(instructorButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}
