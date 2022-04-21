import java.util.ArrayList;

public class Student extends User {

    private float gpa;
    private int totalCredits;
    private String major;
    private String expireAt;
    private ArrayList<StudentCourse> courses;
    private String department;

    public Student(String name, String surname, String email, String phone, String address, String password, boolean status, String createdAt, String updatedAt, String role, long id, float gpa, int totalCredits, String major, String expireAt, University university, String department) {
        super(name, surname, email, phone, address, password, status, createdAt, updatedAt, role, id, university);
        this.gpa = gpa;
        this.totalCredits = totalCredits;
        this.major = major;
        this.expireAt = expireAt;
        courses = new ArrayList<>();
        this.department = department;
    }

    public void addCourse(StudentCourse course){
        courses.add(course);
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public ArrayList<StudentCourse> getCourses() {
        return courses;
    }

    public void addStudentCourse(StudentCourse course) {
        if (courses != null) courses.add(course);
        else System.out.println("Courses is null");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + " " + getSurname();
    }
}
