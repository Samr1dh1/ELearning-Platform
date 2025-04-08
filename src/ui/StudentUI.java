package ui;

import methods.StudentMethods;
import models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void studentMenu() {
        while (true) {
            displayStudentMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    getStudentDetails();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayStudentMenu() {
        System.out.println("Student Management Menu:");
        System.out.println("1. Add a Student");
        System.out.println("2. Delete a Student");
        System.out.println("3. Display All Students");
        System.out.println("4. Get Student Details by ID");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's email: ");
        String email = scanner.nextLine();
        System.out.print("Enter student's contact: ");
        String contact = scanner.nextLine();

        boolean success = StudentMethods.addStudent(name, email, contact);
        if (success) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean success = StudentMethods.deleteStudent(studentID);
        if (success) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student.");
        }
    }

    private static void displayAllStudents() {
        List<Student> students = StudentMethods.getStudents();
        if (students != null && !students.isEmpty()) {
            System.out.printf("%-10s %-20s %-30s %-15s%n", "Student ID", "Name", "Email", "Contact");
            System.out.println("---------------------------------------------------------------------------");
            for (Student student : students) {
                System.out.printf("%-10d %-20s %-30s %-15s%n",
                        student.getStudentID(),
                        student.getName(),
                        student.getEmail(),
                        student.getContact());
            }
        } else {
            System.out.println("No students found.");
        }
    }

    private static void getStudentDetails() {
        System.out.print("Enter student ID to view details: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student student = StudentMethods.getStudent(studentID);
        if (student != null) {
            System.out.println("Student Details: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }
}
