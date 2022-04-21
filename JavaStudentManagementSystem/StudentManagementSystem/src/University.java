import java.lang.reflect.Array;
import java.util.ArrayList;

public class University implements IUniversity {

    private String name;
    private long id;
    private String studentPostFix;
    private String instructorPostFix;
    private ArrayList<Student> students;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> departments;

    public University(String name, long id, String studentPostFix, String instructorPostFix) {
        this.name = name;
        this.id = id;
        this.studentPostFix = studentPostFix;
        this.instructorPostFix = instructorPostFix;
    }

    @Override
    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    @Override
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    @Override
    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public ArrayList<Department> getDepartments() {
        return departments;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentPostFix() {
        return studentPostFix;
    }

    public void setStudentPostFix(String studentPostFix) {
        this.studentPostFix = studentPostFix;
    }

    public String getInstructorPostFix() {
        return instructorPostFix;
    }

    public void setInstructorPostFix(String instructorPostFix) {
        this.instructorPostFix = instructorPostFix;
    }

    @Override
    public String toString() {
        return getName();
    }

}
