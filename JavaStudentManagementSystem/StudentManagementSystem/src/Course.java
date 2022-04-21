import java.util.ArrayList;

public class Course {

    private String courseId;
    private String courseName;
    private int credit;
    private float pM1; // Midterm1 percentage
    private float pM2; // Midterm2 percentage
    private float pFinal; // Final percentage
    private Instructor instructor;

    public Course (String courseId, String courseName, int credit, float pM1, float pM2, float pFinal, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.pM1 = pM1;
        this.pM2 = pM2;
        this.pFinal = pFinal;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public float getpM1() {
        return pM1;
    }

    public void setpM1(int pM1) {
        this.pM1 = pM1;
    }

    public float getpM2() {
        return pM2;
    }

    public void setpM2(int pM2) {
        this.pM2 = pM2;
    }

    public float getpFinal() {
        return pFinal;
    }

    public void setpFinal(int pFinal) {
        this.pFinal = pFinal;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return courseId + " - " + courseName;
    }
}
