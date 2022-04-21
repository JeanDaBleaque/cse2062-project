import java.util.ArrayList;
import java.util.Locale;

public class Instructor extends User {

    private String prefix;
    private String office;
    private String department;
    private ArrayList<Course> courses;

    public Instructor(String name, String surname, String email, String phone, String address, String password, boolean status, String created_at, String updated_at, String role, long id, String prefix, String office, String department, University university) {
        super(name, surname, email, phone, address, password, status, created_at, updated_at, role, id, university);
        this.prefix = prefix;
        this.office = office;
        this.department = department;
        courses = new ArrayList<>();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        if (courses != null) courses.add(course);
        else System.out.println("Courses is null");
    }

    public ArrayList<Course> findCoursesByName(String name) {
        ArrayList<Course> coursesToFind = new ArrayList<>();
        for (Course course : this.courses) {
            String curCourseName = course.getCourseName();
            curCourseName = curCourseName.toLowerCase();
            if (curCourseName.contains(name)) coursesToFind.add(course);
        }
        return coursesToFind;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
