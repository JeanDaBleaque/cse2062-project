package com.jean;

import java.util.ArrayList;

public class Student extends User {

    private float gpa;
    private int totalCredits;
    private String major;
    private String expire_at;
    private ArrayList<String> courses;
    private ArrayList<String> grades;
    public Student(String name, String surname, String email, String phone, String address, String password, boolean status, String created_at, String updated_at, String role, long id, String expire_at) {
        super(name, surname, email, phone, address, password, status, created_at, updated_at, role, id);
        this.expire_at = expire_at;
    }

}
