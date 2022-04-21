import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("ALL")
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

    public ArrayList<University> getUniversities() {
        ArrayList<University> universities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM universities");
            while (resultSet.next()) {
                universities.add(new University(resultSet.getString("university_name"), resultSet.getLong("university_id"), resultSet.getString("studentPostFix"), resultSet.getString("instructorPostFix")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return universities;
    }

    public User checkUser(long id, String password, long university_id) {
        try {
            PreparedStatement universityStatement = connection.prepareStatement("SELECT * FROM universities WHERE university_id=?");
            universityStatement.setLong(1, university_id);
            ResultSet universityResult = universityStatement.executeQuery();
            if (universityResult.next()) {
                University curUniversity = new University(universityResult.getString("university_name"), universityResult.getLong("university_id"), universityResult.getString("studentPostFix"), universityResult.getString("instructorPostFix"));
                PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ? AND university_id = ?");
                userStatement.setLong(1, id);
                userStatement.setString(2, password);
                userStatement.setLong(3, university_id);
                ResultSet userResult = userStatement.executeQuery();
                if (userResult.next()) {
                    boolean isStudent = userResult.getString("role").equalsIgnoreCase("student");
                    boolean isInstructor = userResult.getString("role").equalsIgnoreCase("instructor");
                    if (isStudent) {
                        long studentID;
                        studentID = userResult.getLong("id");
                        PreparedStatement studentStatement = connection.prepareStatement("SELECT * FROM students WHERE id = ? AND university_id = ?");
                        studentStatement.setLong(1, studentID);
                        studentStatement.setLong(2, university_id);
                        ResultSet studentResult = studentStatement.executeQuery();
                        if (studentResult.next()) {
                            return new Student(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                    userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                    userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                    userResult.getString("role"), userResult.getLong("id"), studentResult.getFloat("gpa"),
                                    studentResult.getInt("totalCredits"), studentResult.getString("major"), studentResult.getString("expire_at"), curUniversity, studentResult.getString("department"));
                        }
                    } else if (isInstructor) {
                        long instructorID;
                        instructorID = userResult.getLong("id");
                        PreparedStatement instructorStatement = connection.prepareStatement("SELECT * FROM instructors WHERE id = ? AND university_id = ?");
                        instructorStatement.setLong(1, instructorID);
                        instructorStatement.setLong(2, university_id);
                        ResultSet instructorResult = instructorStatement.executeQuery();
                        if (instructorResult.next()) {
                            return new Instructor(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                    userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                    userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                    userResult.getString("role"), userResult.getLong("id"), instructorResult.getString("prefix"), instructorResult.getString("office_no"), instructorResult.getString("department"), curUniversity);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addStudent(Student student) {
        try {
            PreparedStatement userStatement = connection.prepareStatement("INSERT INTO users (name, surname, email, phone, address, password, status, created_at, updated_at, role, id, university_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            userStatement.setLong(11, student.getId());
            userStatement.setLong(12, student.getUniversity().getId());
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
            return false;
        }
        return true;
    }

    public boolean addInstructor(Instructor instructor) {
        try {
            PreparedStatement userStatement = connection.prepareStatement("INSERT INTO users (name, surname, email, phone, address, password, status, created_at, updated_at, role, id, university_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            userStatement.setLong(11, instructor.getId());
            userStatement.setLong(12, instructor.getUniversity().getId());
            userStatement.executeUpdate();
            PreparedStatement instructorStatement = connection.prepareStatement("INSERT INTO instructors (prefix, office_no, department, id) VALUES (?, ?, ?, ?)");
            instructorStatement.setString(1, instructor.getPrefix());
            instructorStatement.setString(2, instructor.getOffice());
            instructorStatement.setString(3, instructor.getDepartment());
            instructorStatement.setLong(4, instructor.getId());
            instructorStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
            instructor.getCourses().clear();
            while (resultSet.next()) {
                String instructorName = instructor.getPrefix() + " " + instructor.getName() + " " + instructor.getSurname();
                Course course = new Course(resultSet.getString("course_id"), resultSet.getString("course_name"), resultSet.getInt("credit"), resultSet.getFloat("percentMidterm1"), resultSet.getFloat("percentMidterm2"), resultSet.getFloat("percentFinal"), instructor);
                instructor.addCourse(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Department> getDepartments(long universityId) {
        ArrayList<Department> departments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM departments WHERE university_id=?");
            statement.setLong(1, universityId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department(resultSet.getLong("overseer_id"), resultSet.getString("department_name"));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean addCourse(Course course) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO courses (course_id, course_name, credit, percentMidterm1, percentMidterm2, percentFinal, instructor_id, university_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getCredit());
            statement.setFloat(4, course.getpM1());
            statement.setFloat(5, course.getpM2());
            statement.setFloat(6, course.getpFinal());
            statement.setLong(7, course.getInstructor().getId());
            statement.setLong(8, course.getInstructor().getUniversity().getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCourse(Course courseToDel) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM courses WHERE course_id=?");
            statement.setString(1, courseToDel.getCourseId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Instructor> getInstructors(long university_id) {
        ArrayList<Instructor> instructors = new ArrayList<>();
        try {
            PreparedStatement universityStatement = connection.prepareStatement("SELECT * FROM universities WHERE university_id=?");
            universityStatement.setLong(1, university_id);
            ResultSet universityResult = universityStatement.executeQuery();
            if (universityResult.next()) {
                University curUniversity = new University(universityResult.getString("university_name"), universityResult.getLong("university_id"), universityResult.getString("studentPostFix"), universityResult.getString("instructorPostFix"));
                PreparedStatement userStatement = connection.prepareStatement("SELECT * FROM users WHERE university_id=? AND role='instructor'");
                userStatement.setLong(1, university_id);
                ResultSet userResult = userStatement.executeQuery();
                while (userResult.next()) {
                    PreparedStatement instructorStatement = connection.prepareStatement("SELECT * FROM instructors WHERE id=?");
                    instructorStatement.setLong(1, userResult.getLong("id"));
                    ResultSet instructorResult = instructorStatement.executeQuery();
                    if (instructorResult.next()) {
                        Instructor instructor = new Instructor(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                userResult.getString("role"), userResult.getLong("id"), instructorResult.getString("prefix"), instructorResult.getString("office_no"), instructorResult.getString("department"), curUniversity);
                        instructors.add(instructor);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructors;
    }

    public boolean editCourses(Course course, String selectedCourse) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE courses SET course_id=?, course_name=?, credit=?, instructor_id=?, percentMidterm1=?, percentMidterm2=?, percentFinal=?, university_id=? WHERE course_id=?");
            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getCredit());
            statement.setLong(4, course.getInstructor().getId());
            statement.setFloat(5, course.getpM1());
            statement.setFloat(6, course.getpM2());
            statement.setFloat(7, course.getpFinal());
            statement.setLong(8, course.getInstructor().getUniversity().getId());
            statement.setString(9, selectedCourse);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Student> getStudents(long university_id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            PreparedStatement universityStatement = connection.prepareStatement("SELECT * FROM universities WHERE university_id=?");
            universityStatement.setLong(1, university_id);
            ResultSet universityResult = universityStatement.executeQuery();
            if (universityResult.next()) {
                University curUniversity = new University(universityResult.getString("university_name"), universityResult.getLong("university_id"), universityResult.getString("studentPostFix"), universityResult.getString("instructorPostFix"));
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE university_id=? AND role='student'");
                statement.setLong(1, university_id);
                ResultSet userResult = statement.executeQuery();
                while (userResult.next()) {
                    PreparedStatement studentStatement = connection.prepareStatement("SELECT * FROM students WHERE id=?");
                    studentStatement.setLong(1, userResult.getLong("id"));
                    ResultSet studentResult = studentStatement.executeQuery();
                    if (studentResult.next()) {
                        Student student = new Student(userResult.getString("name"), userResult.getString("surname"), userResult.getString("email"),
                                userResult.getString("phone"), userResult.getString("address"), userResult.getString("password"),
                                userResult.getBoolean("status"), userResult.getString("created_at"), userResult.getString("updated_at"),
                                userResult.getString("role"), userResult.getLong("id"), studentResult.getFloat("gpa"), studentResult.getInt("totalCredits"), studentResult.getString("major"), studentResult.getString("expire_at"), curUniversity, studentResult.getString("department"));
                        students.add(student);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public ArrayList<Student> findStudentsByName(String name, ArrayList<Student> students) {
        ArrayList<Student> studentsToFind = new ArrayList<>();
        for (Student student : students) {
            String studentName = student.getName();
            studentName = studentName.toLowerCase();
            if (studentName.contains(name)) studentsToFind.add(student);
        }
        return studentsToFind;
    }

    public boolean updateStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET name=?, surname=?, email=?, phone=?, address=?, password=?, status=?, created_at=?, updated_at=?, role=?, university_id=? WHERE id=?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getPassword());
            statement.setBoolean(7, student.getStatus());
            statement.setString(8, student.getCreatedAt());
            statement.setString(9, student.getUpdatedAt());
            statement.setString(10, student.getRole());
            statement.setLong(11, student.getUniversity().getId());
            statement.setLong(12, student.getId());
            statement.executeUpdate();
            PreparedStatement studentStatement = connection.prepareStatement("UPDATE students SET gpa=?, totalCredits=?, major=?, expire_at=?, department=? WHERE id=?");
            studentStatement.setFloat(1, student.getGpa());
            studentStatement.setInt(2, student.getTotalCredits());
            studentStatement.setString(3, student.getMajor());
            studentStatement.setString(4, student.getExpireAt());
            studentStatement.setString(5, student.getDepartment());
            studentStatement.setLong(6, student.getId());
            studentStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            statement.setLong(1, student.getId());
            statement.executeUpdate();
            PreparedStatement studentStatement = connection.prepareStatement("DELETE FROM students WHERE id=?");
            studentStatement.setLong(1, student.getId());
            studentStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
