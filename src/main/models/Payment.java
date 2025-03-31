package main.models;

public class Payment {
    private int paymentID;
    private int studentID;
    private double amount;
    private String paymentDate;
    private String status;

    public Payment(int paymentID, int studentID, double amount, String paymentDate, String status) {
        this.paymentID = paymentID;
        this.studentID = studentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public int getPaymentID() { return paymentID; }
    public void setPaymentID(int paymentID) { this.paymentID = paymentID; }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + paymentID +
                ", Student ID=" + studentID +
                ", Amount=" + amount +
                ", Payment Date='" + paymentDate + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
