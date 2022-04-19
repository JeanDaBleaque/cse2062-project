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

    public void addStudent(Student student) {
        try {
            PreparedStatement userStatement = connection.prepareStatement("INSERT INTO users (name, surname, email, phone, address, password, status, created_at, updated_at, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            userStatement.setString(1, student.getName());
            userStatement.setString(2, student.getSurname());
            userStatement.setString(3, student.getEmail());
            userStatement.setString(4, student.getPhone());
            userStatement.setString(5, student.getAddress());
            userStatement.setString(6, student.getPassword());
            userStatement.setBoolean(7, student.getStatus());
            userStatement.setString(8, student.getCreatedAt());
            userStatement.setString(9, student.getUpdatedAt());
            userStatement.setString(10, student.getRole());
            userStatement.executeUpdate();
            PreparedStatement studentStatement = connection.prepareStatement("INSERT INTO students (gpa, totalCredits, major, expire_at, id) VALUES (?, ?, ?, ?, ?)");
            studentStatement.setFloat(1, student.getGpa());
            studentStatement.setInt(2, student.getTotalCredits());
            studentStatement.setString(3, student.getMajor());
            studentStatement.setString(4, student.getExpireAt());
            studentStatement.setLong(5, student.getId());
            studentStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addInstructor(Instructor instructor) {
        try {
            PreparedStatement userStatement = connection.prepareStatement("INSERT INTO users (name, surname, email, phone, address, password, status, created_at, updated_at, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            userStatement.setString(1, instructor.getName());
            userStatement.setString(2, instructor.getSurname());
            userStatement.setString(3, instructor.getEmail());
            userStatement.setString(4, instructor.getPhone());
            userStatement.setString(5, instructor.getAddress());
            userStatement.setString(6, instructor.getPassword());
            userStatement.setBoolean(7, instructor.getStatus());
            userStatement.setString(8, instructor.getCreatedAt());
            userStatement.setString(9, instructor.getUpdatedAt());
            userStatement.setString(10, instructor.getRole());
            userStatement.executeUpdate();
            PreparedStatement instructorStatement = connection.prepareStatement("INSERT INTO instructors (prefix, office_no, department, id) VALUES (?, ?, ?, ?)");
            instructorStatement.setString(1, instructor.getPrefix());
            instructorStatement.setString(2, instructor.getOffice());
            instructorStatement.setString(3, instructor.getDepartment());
            instructorStatement.setLong(4, instructor.getId());
            instructorStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentCourses(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM s_courses WHERE student_id=?");
            statement.setLong(1, student.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                StudentCourse studentCourse = new StudentCourse(resultSet.getInt("course_id"), resultSet.getInt("midterm1"), resultSet.getInt("midterm2"), resultSet.getInt("final"));
                student.addStudentCourse(studentCourse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCourses(Instructor instructor) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM courses WHERE instructor_id=?");
            statement.setLong(1, instructor.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt("course_id"), resultSet.getString("course_name"), resultSet.getInt("credit"), resultSet.getFloat("percentMidterm1"), resultSet.getFloat("percentMidterm2"), resultSet.getFloat("percentFinal"));
                instructor.addCourse(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
