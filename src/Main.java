import redundant_ui.EnrollmentUI;
import redundant_ui.LessonUI;
import redundant_ui.PaymentUI;
import redundant_ui.QuizUI;
import ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Show main menu when the application starts
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            String[] options = {
                    "Manage Students",
                    "Manage Instructors",
                    "Manage Courses",
                    "Manage Enrollments",
                    "Manage Payments",
                    "Manage Lessons",
                    "Manage Quizzes",
                    "Exit"
            };

            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an option:",
                    "E-Learning Management System",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == null || choice.equals("Exit")) {
                JOptionPane.showMessageDialog(null, "Exiting the application.");
                System.exit(0);
            }

            switch (choice) {
                case "Manage Students":
                    new StudentUI().setVisible(true);
                    break;
                case "Manage Instructors":
                    new InstructorUI().setVisible(true);
                    break;
                case "Manage Courses":
                    new CourseUI().setVisible(true);
                    break;
                case "Manage Enrollments":
                    new EnrollmentUI().setVisible(true);
                    break;
                case "Manage Payments":
                    new PaymentUI().setVisible(true);
                    break;
                case "Manage Lessons":
                    new LessonUI().setVisible(true);
                    break;
                case "Manage Quizzes":
                    new QuizUI().setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }
}
