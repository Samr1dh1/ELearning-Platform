package main.models;

public class Quiz {
    private int quizID;
    private int courseID;
    private String quizTitle;
    private int totalMarks;

    public Quiz(int quizID, int courseID, String quizTitle, int totalMarks) {
        this.quizID = quizID;
        this.courseID = courseID;
        this.quizTitle = quizTitle;
        this.totalMarks = totalMarks;
    }

    public int getQuizID() { return quizID; }
    public void setQuizID(int quizID) { this.quizID = quizID; }

    public int getCourseID() { return courseID; }
    public void setCourseID(int courseID) { this.courseID = courseID; }

    public String getQuizTitle() { return quizTitle; }
    public void setQuizTitle(String quizTitle) { this.quizTitle = quizTitle; }

    public int getTotalMarks() { return totalMarks; }
    public void setTotalMarks(int totalMarks) { this.totalMarks = totalMarks; }

    @Override
    public String toString() {
        return "Quiz{" +
                "ID=" + quizID +
                ", Course ID=" + courseID +
                ", Title='" + quizTitle + '\'' +
                ", Total Marks=" + totalMarks +
                '}';
    }
}
