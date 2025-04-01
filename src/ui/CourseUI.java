package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import models.Lesson;
import models.Quiz;
import models.Student;
import methods.LessonMethods;
import methods.QuizMethods;
import methods.EnrollmentMethods;

public class CourseUI extends JFrame {

    private final int courseId = 1; // For demo purposes

    public CourseUI() {
        setTitle("Course UI");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: Lessons
        JTable lessonsTable = new JTable();
        DefaultTableModel lessonsModel = new DefaultTableModel(new Object[]{"Lesson ID", "Title"}, 0);
        List<Lesson> lessons = LessonMethods.getLessonsByCourse(courseId);
        for (Lesson l : lessons) {
            lessonsModel.addRow(new Object[]{l.getLessonID(), l.getLessonTitle()});
        }
        lessonsTable.setModel(lessonsModel);
        JPanel lessonsPanel = new JPanel(new BorderLayout());
        lessonsPanel.add(new JScrollPane(lessonsTable), BorderLayout.CENTER);
        tabbedPane.addTab("Lessons", lessonsPanel);

        // Tab 2: Quizzes
        JTable quizzesTable = new JTable();
        DefaultTableModel quizzesModel = new DefaultTableModel(new Object[]{"Quiz ID", "Quiz Title"}, 0);
        List<Quiz> quizzes = QuizMethods.getQuizzesByCourse(courseId);
        for (Quiz q : quizzes) {
            quizzesModel.addRow(new Object[]{q.getQuizID(), q.getQuizTitle()});
        }
        quizzesTable.setModel(quizzesModel);
        JPanel quizzesPanel = new JPanel(new BorderLayout());
        quizzesPanel.add(new JScrollPane(quizzesTable), BorderLayout.CENTER);
        tabbedPane.addTab("Quizzes", quizzesPanel);

        // Tab 3: Enrolled Students
        JTable studentsTable = new JTable();
        DefaultTableModel studentsModel = new DefaultTableModel(new Object[]{"Student ID", "Name"}, 0);
        // This method should return the list of students enrolled in this course.
        List<Student> enrolledStudents = EnrollmentMethods.getStudentsEnrolledInCourse(courseId);
        for (Student s : enrolledStudents) {
            studentsModel.addRow(new Object[]{s.getStudentID(), s.getName()});
        }
        studentsTable.setModel(studentsModel);
        JPanel studentsPanel = new JPanel(new BorderLayout());
        studentsPanel.add(new JScrollPane(studentsTable), BorderLayout.CENTER);
        tabbedPane.addTab("Enrolled Students", studentsPanel);

        // Optionally, add another tab to show all courses/instructors if needed.

        add(tabbedPane);
    }
}
