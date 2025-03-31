package models;

public class Lesson {
    private int lessonID;
    private int courseID;
    private String lessonTitle;
    private String content;
    private String videoURL;

    public Lesson(int lessonID, int courseID, String lessonTitle, String content, String videoURL) {
        this.lessonID = lessonID;
        this.courseID = courseID;
        this.lessonTitle = lessonTitle;
        this.content = content;
        this.videoURL = videoURL;
    }

    public int getLessonID() { return lessonID; }
    public void setLessonID(int lessonID) { this.lessonID = lessonID; }

    public int getCourseID() { return courseID; }
    public void setCourseID(int courseID) { this.courseID = courseID; }

    public String getLessonTitle() { return lessonTitle; }
    public void setLessonTitle(String lessonTitle) { this.lessonTitle = lessonTitle; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getVideoURL() { return videoURL; }
    public void setVideoURL(String videoURL) { this.videoURL = videoURL; }

    @Override
    public String toString() {
        return "Lesson{" +
                "ID=" + lessonID +
                ", Course ID=" + courseID +
                ", Title='" + lessonTitle + '\'' +
                ", Content='" + content + '\'' +
                ", Video URL='" + videoURL + '\'' +
                '}';
    }
}
