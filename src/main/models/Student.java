package main.models;

public class Student {
    private int studentID;
    private String name;
    private String email;
    private String contact;
    private String enrollmentDate;

    public Student(int studentID, String name, String email, String contact, String enrollmentDate) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.enrollmentDate = enrollmentDate;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + studentID +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Contact='" + contact + '\'' +
                ", Enrollment Date='" + enrollmentDate + '\'' +
                '}';
    }
}
