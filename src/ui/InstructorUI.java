package ui;

import methods.InstructorMethods;
import models.Instructor;

import java.util.List;
import java.util.Scanner;

public class InstructorUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void instructorMenu() {
        while (true) {
            displayInstructorMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addInstructor();
                    break;
                case 2:
                    displayAllInstructors();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayInstructorMenu() {
        System.out.println("\nInstructor Management Menu:");
        System.out.println("1. Add an Instructor");
        System.out.println("2. Display All Instructors");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void addInstructor() {
        System.out.print("Enter instructor's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter instructor's email: ");
        String email = scanner.nextLine();
        System.out.print("Enter instructor's contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter instructor's specialization: ");
        String specialization = scanner.nextLine();

        boolean success = InstructorMethods.addInstructor(name, email, contact, specialization);
        if (success) {
            System.out.println("Instructor added successfully!");
        } else {
            System.out.println("Failed to add instructor.");
        }
    }

    private static void displayAllInstructors() {
        List<Instructor> instructors = InstructorMethods.getInstructors();
        if (instructors != null && !instructors.isEmpty()) {
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-25s %-15s %-20s\n", "ID", "Name", "Email", "Contact", "Specialization");
            System.out.println("---------------------------------------------------------------------------------");

            for (Instructor instructor : instructors) {
                System.out.printf("%-10d %-20s %-25s %-15s %-20s\n",
                        instructor.getInstructorID(),
                        instructor.getName(),
                        instructor.getEmail(),
                        instructor.getContact(),
                        instructor.getSpecialization());
            }
            System.out.println("---------------------------------------------------------------------------------");
        } else {
            System.out.println("No instructors found.");
        }
    }
}
