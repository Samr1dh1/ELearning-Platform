package redundant_ui;

import models.Lesson;
import methods.LessonMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LessonUI extends JFrame {
    private JTextField lessonTitleField, courseIdField, videoUrlField;
    private JTextArea contentArea;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private LessonMethods lessonMethods;

    public LessonUI() {
        lessonMethods = new LessonMethods();

        setTitle("Lesson Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Labels and Input Fields
        add(new JLabel("Course ID:"));
        courseIdField = new JTextField();
        add(courseIdField);

        add(new JLabel("Lesson Title:"));
        lessonTitleField = new JTextField();
        add(lessonTitleField);

        add(new JLabel("Content:"));
        contentArea = new JTextArea(3, 20);
        add(new JScrollPane(contentArea));

        add(new JLabel("Video URL:"));
        videoUrlField = new JTextField();
        add(videoUrlField);

        // Buttons
        addButton = new JButton("Add Lesson");
        updateButton = new JButton("Update Lesson");
        deleteButton = new JButton("Delete Lesson");
        viewButton = new JButton("View Lessons");

        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(viewButton);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLesson();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLesson();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLesson();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewLessons();
            }
        });

        setVisible(true);
    }

    private void addLesson() {
        try {
            int courseId = Integer.parseInt(courseIdField.getText());
            String title = lessonTitleField.getText();
            String content = contentArea.getText();
            String videoUrl = videoUrlField.getText();

            boolean success = lessonMethods.addLesson(courseId, title, content, videoUrl);

            if (success) {
                JOptionPane.showMessageDialog(this, "Lesson added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add lesson.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid course ID.");
        }
    }

    private void updateLesson() {
        try {
            int lessonId = Integer.parseInt(JOptionPane.showInputDialog("Enter Lesson ID to update:"));
            String title = lessonTitleField.getText();
            String content = contentArea.getText();
            String videoUrl = videoUrlField.getText();

            boolean success = lessonMethods.updateLesson(lessonId, title, content, videoUrl);

            if (success) {
                JOptionPane.showMessageDialog(this, "Lesson updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update lesson.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Lesson ID.");
        }
    }

    private void deleteLesson() {
        try {
            int lessonId = Integer.parseInt(JOptionPane.showInputDialog("Enter Lesson ID to delete:"));
            boolean success = lessonMethods.deleteLesson(lessonId);

            if (success) {
                JOptionPane.showMessageDialog(this, "Lesson deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete lesson.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Lesson ID.");
        }
    }

    private void viewLessons() {
        List<Lesson> lessons = lessonMethods.getAllLessons();
        StringBuilder message = new StringBuilder("Lessons:\n");

        for (Lesson lesson : lessons) {
            message.append("ID: ").append(lesson.getLessonID())
                    .append(", Course ID: ").append(lesson.getCourseID())
                    .append(", Title: ").append(lesson.getLessonTitle())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(this, message.toString());
    }
}
