package com.jean;

public class Course {
    protected int courseId;
    protected String courseName;
    protected int credit;
    protected int instructorId;
    protected int pM1; // Midterm1 percentage
    protected int pM2; // Midterm2 percentage
    protected int pFinal; // Final percentage

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getpM1() {
        return pM1;
    }

    public void setpM1(int pM1) {
        this.pM1 = pM1;
    }

    public int getpM2() {
        return pM2;
    }

    public void setpM2(int pM2) {
        this.pM2 = pM2;
    }

    public int getpFinal() {
        return pFinal;
    }

    public void setpFinal(int pGinal) {
        this.pFinal = pGinal;
    }
}
