package com.jean;

public class Instructor extends User {

    private String prefix;
    private String office;

    public Instructor(String name, String surname, String email, String phone, String address, String password, boolean status, String created_at, String updated_at, String role, long id) {
        super(name, surname, email, phone, address, password, status, created_at, updated_at, role, id);
    }
}
