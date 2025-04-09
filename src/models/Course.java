package models;

public class Course {
    private int courseID;
    private String courseName;
    private String description;
    private int instructorID;
    private double price;

    public Course(int courseID, String courseName, String description, int instructorID, double price) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.instructorID = instructorID;
        this.price = price;
    }

    public int getCourseID() { return courseID; }
    public void setCourseID(int courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getInstructorID() { return instructorID; }
    public void setInstructorID(int instructorID) { this.instructorID = instructorID; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return  "\n ID = " + courseID +
                ",\n Name = '" + courseName + '\'' +
                ",\n Description = '" + description + '\'' +
                ",\n Instructor ID = " + instructorID +
                ",\n Price = " + price;
    }
}
