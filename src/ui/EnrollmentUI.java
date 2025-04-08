package ui;

import methods.EnrollmentMethods;
import models.Course;
import models.Student;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EnrollmentUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void enrollmentMenu() {
        while (true) {
            displayEnrollmentMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    enrollStudentInCourse();
                    break;
                case 2:
                    deleteEnrollment();
                    break;
                case 3:
                    displayAllEnrollments();
                    break;
                case 4:
                    viewCoursesByStudent();
                    break;
                case 5:
                    viewStudentsInCourse();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayEnrollmentMenu() {
        System.out.println("Enrollment Management Menu:");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. Delete Enrollment");
        System.out.println("3. Display All Enrollments");
        System.out.println("4. View Courses by Student");
        System.out.println("5. View Students in Course");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void enrollStudentInCourse() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        boolean success = EnrollmentMethods.enrollStudent(studentId, courseId);
        if (success) {
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Failed to enroll student.");
        }
    }

    private static void deleteEnrollment() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        boolean success = EnrollmentMethods.deleteEnrollment(studentId, courseId);
        if (success) {
            System.out.println("Enrollment deleted successfully!");
        } else {
            System.out.println("Failed to delete enrollment.");
        }
    }

    private static void displayAllEnrollments() {
        List<Map<String, Object>> enrollments = EnrollmentMethods.getEnrollments();
        if (enrollments != null && !enrollments.isEmpty()) {
            System.out.println("\n----------------------------------------------------------");
            System.out.printf("%-12s %-12s %-15s\n", "Student ID", "Course ID", "Enrollment Date");
            System.out.println("----------------------------------------------------------");

            for (Map<String, Object> enrollment : enrollments) {
                System.out.printf("%-12d %-12d %-15s\n",
                        (int) enrollment.get("StudentID"),
                        (int) enrollment.get("CourseID"),
                        enrollment.get("EnrollmentDate").toString());
            }
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("No enrollments found.");
        }
    }

    private static void viewCoursesByStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        List<Course> courses = EnrollmentMethods.getStudentCourses(studentId);
        if (courses != null && !courses.isEmpty()) {
            System.out.println("\n----------------------------------------------------------");
            System.out.printf("%-10s %-25s %-15s\n", "Course ID", "Course Name", "Price");
            System.out.println("----------------------------------------------------------");

            for (Course course : courses) {
                System.out.printf("%-10d %-25s %-15.2f\n",
                        course.getCourseID(), course.getCourseName(), course.getPrice());
            }
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("No courses found for this student.");
        }
    }

    private static void viewStudentsInCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        List<Student> students = EnrollmentMethods.getStudentsEnrolledInCourse(courseId);
        if (students != null && !students.isEmpty()) {
            System.out.println("\n-----------------------------------------------------");
            System.out.printf("%-12s %-20s %-20s\n", "Student ID", "Name", "Email");
            System.out.println("-----------------------------------------------------");

            for (Student student : students) {
                System.out.printf("%-12d %-20s %-20s\n",
                        student.getStudentID(), student.getName(), student.getEmail());
            }
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("No students enrolled in this course.");
        }
    }
}
