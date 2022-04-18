package com.jean;
import java.sql.*;

public class DatabaseManager {
    private static final String userName = "root";
    private static final String password = "669445";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/cse2062";
    private Connection connection = null;
    private static DatabaseManager instance;
    private boolean isConnected = false;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            if (connection.isValid(5)) {
                isConnected = true;
                System.out.println("Connected to database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        instance = this;
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public User checkUser(long id, String password) {
        try {
            PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
            userStatement.setLong(1, id);
            userStatement.setString(2, password);
            ResultSet userResult = userStatement.executeQuery();
            if (userResult.next()) {
                boolean isStudent = userResult.getString("role").equalsIgnoreCase("student");
                boolean isInstructor = userResult.getString("role").equalsIgnoreCase("instructor");
                if (isStudent) {
                    long studentID;
                    studentID = userResult.getLong("id");
                    PreparedStatement studentStatement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
                    studentStatement.setLong(1, studentID);
                    ResultSet studentResult = studentStatement.executeQuery();
                    if (studentResult.next()) {
                        return new Student(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                userResult.getString("role"), userResult.getLong("id"), studentResult.getFloat("gpa"),
                                studentResult.getInt("totalCredits"), studentResult.getString("major"), studentResult.getString("expire_at"));
                    }
                } else if (isInstructor) {
                    long instructorID;
                    instructorID = userResult.getLong("id");
                    PreparedStatement instructorStatement = connection.prepareStatement("SELECT * FROM instructors WHERE id = ?");
                    instructorStatement.setLong(1, instructorID);
                    ResultSet instructorResult = instructorStatement.executeQuery();
                    if (instructorResult.next()) {
                        return new Instructor(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                userResult.getString("role"), userResult.getLong("id"), instructorResult.getString("prefix"), instructorResult.getString("office_no"), instructorResult.getString("department"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
