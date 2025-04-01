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
            System.out.println("2. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayStudentQuizResults();
                    break;
                case 2:
                    return; // Return to Main Menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
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
                System.out.println("Quiz ID: " + result.getQuizID());  // ✅ Use Quiz ID instead of Quiz Title
                System.out.println("Score: " + result.getScore());
                System.out.println("-------------------------------------");
            }
        }
    }
}
