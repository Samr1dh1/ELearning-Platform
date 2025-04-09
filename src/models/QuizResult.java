package models;

public class QuizResult {
    private int resultID;
    private int studentID;
    private int quizID;
    private int score;

    public QuizResult(int resultID, int studentID, int quizID, int score) {
        this.resultID = resultID;
        this.studentID = studentID;
        this.quizID = quizID;
        this.score = score;
    }

    public int getResultID() { return resultID; }
    public void setResultID(int resultID) { this.resultID = resultID; }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public int getQuizID() { return quizID; }
    public void setQuizID(int quizID) { this.quizID = quizID; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return  "\n ID=" + resultID +
                ",\n Student ID=" + studentID +
                ",\n Quiz ID=" + quizID +
                ",\n Score=" + score;
    }
}
