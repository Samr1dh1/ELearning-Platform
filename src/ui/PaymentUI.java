package ui;

import methods.PaymentMethods;
import models.Payment;

import java.util.List;
import java.util.Scanner;

public class PaymentUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void paymentMenu() {
        while (true) {
            displayPaymentMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    processPayment();
                    break;
                case 2:
                    addPayment();
                    break;
                case 3:
                    viewPayments();
                    break;
                case 4:
                    viewStudentPayments();
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayPaymentMenu() {
        System.out.println("Payment Management Menu:");
        System.out.println("1. Process Payment");
        System.out.println("2. Add Payment");
        System.out.println("3. View All Payments");
        System.out.println("4. View Student Payments");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void processPayment() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        boolean success = PaymentMethods.processPayment(studentId, amount);
        if (success) {
            System.out.println("Payment processed successfully!");
        } else {
            System.out.println("Failed to process payment.");
        }
    }

    private static void addPayment() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter payment date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();
        System.out.print("Enter payment status: ");
        String status = scanner.nextLine();

        boolean success = PaymentMethods.addPayment(studentId, amount, paymentDate, status);
        if (success) {
            System.out.println("Payment added successfully!");
        } else {
            System.out.println("Failed to add payment.");
        }
    }

    private static void viewPayments() {
        List<Payment> payments = PaymentMethods.getPayments();
        if (payments != null && !payments.isEmpty()) {
            for (Payment payment : payments) {
                System.out.println(payment);
            }
        } else {
            System.out.println("No payments found.");
        }
    }

    private static void viewStudentPayments() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        List<Payment> payments = PaymentMethods.getStudentPayments(studentId);
        if (payments != null && !payments.isEmpty()) {
            for (Payment payment : payments) {
                System.out.println(payment);
            }
        } else {
            System.out.println("No payments found for this student.");
        }
    }
}
