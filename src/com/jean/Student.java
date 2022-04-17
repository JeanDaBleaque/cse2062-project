package com.jean;

import java.util.ArrayList;

public class Student extends User {

    private float gpa;
    private int totalCredits;
    private String major;
    private String expireAt;
    private ArrayList<StudentCourse> courses;

    public Student(String name, String surname, String email, String phone, String address, String password, boolean status, String createdAt, String updatedAt, String role, long id, float gpa, int totalCredits, String major, String expireAt) {
        super(name, surname, email, phone, address, password, status, createdAt, updatedAt, role, id);
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.major = major;
        this.expireAt = expireAt;
    }

    public void addCourse(StudentCourse course){
        courses.add(course);
    }
}
