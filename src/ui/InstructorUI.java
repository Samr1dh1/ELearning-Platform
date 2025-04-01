package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import models.Course;
import models.Enrollment;
import methods.CourseMethods;
import methods.EnrollmentMethods;

public class InstructorUI extends JFrame {

    private final int instructorId = 1; // For demo purposes

    public InstructorUI() {
        setTitle("Instructor UI");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: My Courses
        JTable coursesTable = new JTable();
        DefaultTableModel coursesModel = new DefaultTableModel(new Object[]{"Course ID", "Course Name"}, 0);
        List<Course> courses = CourseMethods.getCoursesByInstructor(instructorId);
        for (Course c : courses) {
            coursesModel.addRow(new Object[]{c.getCourseID(), c.getCourseName()});
        }
        coursesTable.setModel(coursesModel);
        JPanel coursesPanel = new JPanel(new BorderLayout());
        coursesPanel.add(new JScrollPane(coursesTable), BorderLayout.CENTER);
        tabbedPane.addTab("My Courses", coursesPanel);

        add(tabbedPane);
    }
}