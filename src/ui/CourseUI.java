package ui;

import methods.CourseMethods;
import models.Course;

import java.util.List;
import java.util.Scanner;

public class CourseUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void courseMenu() {
        while (true) {
            displayCourseMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    updateCoursePrice();
                    break;
                case 3:
                    displayAllCourses();
                    break;
                case 4:
                    viewCourseDetails();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCourseMenu() {
        System.out.println("Course Management Menu:");
        System.out.println("1. Add a Course");
        System.out.println("2. Update Course Price");
        System.out.println("3. Display All Courses");
        System.out.println("4. View Course Details");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void addCourse() {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter instructor ID: ");
        int instructorID = scanner.nextInt();
        System.out.print("Enter course price: ");
        double price = scanner.nextDouble();

        boolean success = CourseMethods.addCourse(name, desc, instructorID, price);
        if (success) {
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Failed to add course.");
        }
    }

    private static void updateCoursePrice() {
        System.out.print("Enter course ID: ");
        int courseID = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();

        boolean success = CourseMethods.updatePrice(courseID, newPrice);
        if (success) {
            System.out.println("Course price updated successfully!");
        } else {
            System.out.println("Failed to update course price.");
        }
    }

    private static void displayAllCourses() {
        List<Course> courses = CourseMethods.getCourses();
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found.");
        }
    }

    private static void viewCourseDetails() {
        System.out.print("Enter course ID: ");
        int courseID = scanner.nextInt();

        String details = CourseMethods.getCourseDetails(courseID);
        if (details != null) {
            System.out.println("Course Details: " + details);
        } else {
            System.out.println("Course not found.");
        }
    }
}
