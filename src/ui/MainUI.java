package ui;

import java.util.Scanner;

public class MainUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    CourseUI.courseMenu();
                    break;
                case 2:
                    InstructorUI.instructorMenu();
                    break;
                case 3:
                    StudentUI.studentMenu();
                    break;
                case 4:
                    EnrollmentUI.enrollmentMenu();
                    break;
                case 5:
                    PaymentUI.paymentMenu();
                    break;
                case 6:
                    QuizUI.quizMenu();
                    break;
                case 7:
                    QuizResultUI.quizResultMenu();
                    break;
                case 8:
                    LessonUI.lessonMenu();
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nWelcome to the E-Learning System");
        System.out.println("1. Manage Courses");
        System.out.println("2. Manage Instructors");
        System.out.println("3. Manage Students");
        System.out.println("4. Manage Enrollments");
        System.out.println("5. Manage Payments");
        System.out.println("6. Manage Quizzes");
        System.out.println("7. Manage Quiz Results");
        System.out.println("8. Manage Lessons");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }
}
