package com.jean;

public class Main {

    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        User u1 = manager.checkUser(150720520, "111111");
        if (u1.getStatus()) {
            if (u1.getRole().equals("student")) {
                Student s1 = (Student) u1;
                System.out.println(s1.getGpa());
            } else if (u1.getRole().equals("instructor")) {
                Instructor i1 = (Instructor) u1;
                System.out.println(i1.getName());
            }
        } else if (!u1.getStatus()){
            System.out.println("Your account is not activated or expired!");
        } else {
            System.out.println("Your account is not found!");
        }
    }
}
