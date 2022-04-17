package com.jean;

public class StudentCourse extends Course {
    private int midterm1; // first midterm grade
    private int midterm2; // second midterm grade
    private int finalExam; // final exam grade
    private String letterGrade;

    public StudentCourse(int courseId, String courseName, int pM1, int pM2, int pFinal, int midterm1, int midterm2, int finalExam) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.pM1 = pM1;
        this.pM2 = pM2;
        this.pFinal = pFinal;
        this.midterm1 = midterm1;
        this.midterm2 = midterm2;
        this.finalExam = finalExam;
    }
}
