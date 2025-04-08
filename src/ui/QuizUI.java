package ui;

import methods.QuizMethods;
import models.Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void quizMenu() {
        while (true) {
            displayQuizMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addQuiz();
                    break;
                case 2:
                    viewQuizzesByCourse();
                    break;
                case 3:
                    viewAllQuizzes();
                    break;
                case 4:
                    viewQuizDetails();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayQuizMenu() {
        System.out.println("Quiz Management Menu:");
        System.out.println("1. Add Quiz");
        System.out.println("2. View Quizzes by Course");
        System.out.println("3. View All Quizzes");
        System.out.println("4. View Quiz Details");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void addQuiz() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter quiz title: ");
        String quizTitle = scanner.nextLine();
        System.out.print("Enter total marks: ");
        int totalMarks = scanner.nextInt();

        boolean success = QuizMethods.addQuiz(courseId, quizTitle, totalMarks);
        if (success) {
            System.out.println("Quiz added successfully!");
        } else {
            System.out.println("Failed to add quiz.");
        }
    }

    private static void viewQuizzesByCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        List<Quiz> quizzes = QuizMethods.getQuizzesByCourse(courseId);
        if (quizzes != null && !quizzes.isEmpty()) {
            System.out.printf("%-10s %-10s %-30s %-12s%n", "Quiz ID", "Course ID", "Title", "Total Marks");
            System.out.println("---------------------------------------------------------------------");
            for (Quiz quiz : quizzes) {
                System.out.printf("%-10d %-10d %-30s %-12d%n",
                        quiz.getQuizID(),
                        quiz.getCourseID(),
                        quiz.getQuizTitle(),
                        quiz.getTotalMarks());
            }
        } else {
            System.out.println("No quizzes found for this course.");
        }
    }

    private static void viewAllQuizzes() {
        List<Quiz> quizzes = QuizMethods.getQuizzes();
        if (quizzes != null && !quizzes.isEmpty()) {
            System.out.printf("%-10s %-10s %-30s %-12s%n", "Quiz ID", "Course ID", "Title", "Total Marks");
            System.out.println("---------------------------------------------------------------------");
            for (Quiz quiz : quizzes) {
                System.out.printf("%-10d %-10d %-30s %-12d%n",
                        quiz.getQuizID(),
                        quiz.getCourseID(),
                        quiz.getQuizTitle(),
                        quiz.getTotalMarks());
            }
        } else {
            System.out.println("No quizzes found.");
        }
    }

    private static void viewQuizDetails() {
        System.out.print("Enter quiz ID: ");
        int quizID = scanner.nextInt();

        String quizDetails = QuizMethods.getQuizDetails(quizID);
        if (quizDetails != null) {
            System.out.println(quizDetails);
        } else {
            System.out.println("No details found for this quiz.");
        }
    }
}
