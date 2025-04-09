package ui;

import methods.QuizResultMethods;
import models.QuizResult;

import java.util.List;
import java.util.Scanner;

public class QuizResultUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void quizResultMenu() {
        while (true) {
            System.out.println("\n--- Quiz Results Menu ---");
            System.out.println("1. View Student Quiz Results");
            System.out.println("2. Take a Quiz");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 2:
                    addQuizResult();
                    break;
                case 1:
                    displayStudentQuizResults();
                    break;
                case 3:
                    return; // Return to Main Menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addQuizResult() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Quiz ID: ");
        int quizId = scanner.nextInt();
        System.out.print("Enter Score: ");
        int courseId = scanner.nextInt();

        boolean success = QuizResultMethods.saveQuizResult(studentId, quizId, courseId);
        if (success) {
            System.out.println("Quiz Result added successfully!");
        } else {
            System.out.println("Failed to add quiz result.");
        }
    }

    private static void displayStudentQuizResults() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        List<QuizResult> results = QuizResultMethods.getStudentQuizResults(studentId);

        if (results.isEmpty()) {
            System.out.println("No quiz results found for Student ID: " + studentId);
        } else {
            System.out.println("\nQuiz Results for Student ID: " + studentId);
            System.out.println("-------------------------------------");
            for (QuizResult result : results) {
                System.out.println("Quiz ID: " + result.getQuizID());
                System.out.println("Score: " + result.getScore());
                System.out.println("-------------------------------------");
            }
        }
    }
}
