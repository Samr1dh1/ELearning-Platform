package main.models;

public class Enrollment {
    private int enrollmentID;
    private int studentID;
    private int courseID;
    private String enrollmentDate;
    private int paymentID;

    public Enrollment(int enrollmentID, int studentID, int courseID, String enrollmentDate, int paymentID) {
        this.enrollmentID = enrollmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrollmentDate = enrollmentDate;
        this.paymentID = paymentID;
    }

    public int getEnrollmentID() { return enrollmentID; }
    public void setEnrollmentID(int enrollmentID) { this.enrollmentID = enrollmentID; }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public int getCourseID() { return courseID; }
    public void setCourseID(int courseID) { this.courseID = courseID; }

    public String getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public int getPaymentID() { return paymentID; }
    public void setPaymentID(int paymentID) { this.paymentID = paymentID; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "ID=" + enrollmentID +
                ", Student ID=" + studentID +
                ", Course ID=" + courseID +
                ", Enrollment Date='" + enrollmentDate + '\'' +
                ", Payment ID=" + paymentID +
                '}';
    }
}
