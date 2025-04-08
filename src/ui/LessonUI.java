package ui;

import java.util.List;
import java.util.Scanner;

import models.Lesson;
import methods.LessonMethods;

public class LessonUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void lessonMenu() {
        while (true) {
            displayLessonMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addLesson();
                    break;
                case 2:
                    updateLesson();
                    break;
                case 3:
                    deleteLesson();
                    break;
                case 4:
                    viewLessonsByCourse();
                    break;
                case 5:
                    viewAllLessons();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayLessonMenu() {
        System.out.println("Lesson Management Menu:");
        System.out.println("1. Add Lesson");
        System.out.println("2. Update Lesson");
        System.out.println("3. Delete Lesson");
        System.out.println("4. View Lessons by Course");
        System.out.println("5. View All Lessons");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void addLesson() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter lesson title: ");
        String lessonTitle = scanner.nextLine();
        System.out.print("Enter lesson content: ");
        String content = scanner.nextLine();
        System.out.print("Enter video URL: ");
        String videoURL = scanner.nextLine();

        boolean success = LessonMethods.addLesson(courseId, lessonTitle, content, videoURL);
        if (success) {
            System.out.println("Lesson added successfully!");
        } else {
            System.out.println("Failed to add lesson.");
        }
    }

    private static void updateLesson() {
        System.out.print("Enter lesson ID: ");
        int lessonID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new lesson title: ");
        String lessonTitle = scanner.nextLine();
        System.out.print("Enter new lesson content: ");
        String content = scanner.nextLine();
        System.out.print("Enter new video URL: ");
        String videoURL = scanner.nextLine();

        boolean success = LessonMethods.updateLesson(lessonID, lessonTitle, content, videoURL);
        if (success) {
            System.out.println("Lesson updated successfully!");
        } else {
            System.out.println("Failed to update lesson.");
        }
    }

    private static void deleteLesson() {
        System.out.print("Enter lesson ID: ");
        int lessonID = scanner.nextInt();

        boolean success = LessonMethods.deleteLesson(lessonID);
        if (success) {
            System.out.println("Lesson deleted successfully!");
        } else {
            System.out.println("Failed to delete lesson.");
        }
    }

    private static void viewLessonsByCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        List<Lesson> lessons = LessonMethods.getLessonsByCourse(courseId);
        if (lessons != null && !lessons.isEmpty()) {
            System.out.printf("%-10s %-25s %-50s %-30s%n", "Lesson ID", "Title", "Content", "Video URL");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            for (Lesson lesson : lessons) {
                System.out.printf("%-10d %-25s %-50s %-30s%n",
                        lesson.getLessonID(), lesson.getLessonTitle(), lesson.getContent(), lesson.getVideoURL());
            }
        } else {
            System.out.println("No lessons found for this course.");
        }
    }

    private static void viewAllLessons() {
        List<Lesson> lessons = LessonMethods.getAllLessons();
        if (lessons != null && !lessons.isEmpty()) {
            System.out.printf("%-10s %-25s %-50s %-30s%n", "Lesson ID", "Title", "Content", "Video URL");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            for (Lesson lesson : lessons) {
                System.out.printf("%-10d %-25s %-50s %-30s%n",
                        lesson.getLessonID(), lesson.getLessonTitle(), lesson.getContent(), lesson.getVideoURL());
            }
        } else {
            System.out.println("No lessons found.");
        }
    }
}