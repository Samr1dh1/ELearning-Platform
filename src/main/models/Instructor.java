package main.models;

public class Instructor {
    private int instructorID;
    private String name;
    private String email;
    private String contact;
    private String specialization;

    public Instructor(int instructorID, String name, String email, String contact, String specialization) {
        this.instructorID = instructorID;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.specialization = specialization;
    }

    public int getInstructorID() { return instructorID; }
    public void setInstructorID(int instructorID) { this.instructorID = instructorID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "Instructor{" +
                "ID=" + instructorID +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Contact='" + contact + '\'' +
                ", Specialization='" + specialization + '\'' +
                '}';
    }
}
