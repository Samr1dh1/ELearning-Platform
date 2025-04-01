package redundant_ui;

import javax.swing.*;
import java.awt.*;
import methods.PaymentMethods;

public class PaymentUI extends JFrame {
    private JTextField studentIdField, amountField, dateField, statusField;
    private JButton addButton, viewButton;

    public PaymentUI() {
        setTitle("Payment Management");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        setLocationRelativeTo(null);

        JLabel studentLabel = new JLabel("Student ID:");
        studentIdField = new JTextField();
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        JLabel dateLabel = new JLabel("Payment Date (YYYY-MM-DD):");
        dateField = new JTextField();
        JLabel statusLabel = new JLabel("Status (Pending/Completed/Failed):");
        statusField = new JTextField();

        addButton = new JButton("Add Payment");
        viewButton = new JButton("View Payments");

        add(studentLabel);
        add(studentIdField);
        add(amountLabel);
        add(amountField);
        add(dateLabel);
        add(dateField);
        add(statusLabel);
        add(statusField);
        add(addButton);
        add(viewButton);

        addButton.addActionListener(e -> {
            int studentId = Integer.parseInt(studentIdField.getText());
            double amount = Double.parseDouble(amountField.getText());
            String paymentDate = dateField.getText();
            String status = statusField.getText();
            PaymentMethods.addPayment(studentId, amount, paymentDate, status);
        });

        viewButton.addActionListener(e -> JOptionPane.showMessageDialog(this, PaymentMethods.getPayments()));

        setVisible(true);
    }
}
