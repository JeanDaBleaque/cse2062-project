package com.jean;

public class Main {

    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        Student s1 = manager.checkUser(150720521, "111111");
        if (s1.getStatus()) {
            System.out.println("Welcome " + s1.getName());
        } else {
            System.out.println("Your account is not activated or expired!");
        }
    }
}
