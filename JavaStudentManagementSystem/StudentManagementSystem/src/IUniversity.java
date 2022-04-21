import java.util.ArrayList;

public interface IUniversity {
    public void setInstructors(ArrayList<Instructor> instructors);
    public void setStudents(ArrayList<Student> students);
    public void setCourses(ArrayList<Course> courses);
    public void setDepartments(ArrayList<Department> departments);
    public ArrayList<Instructor> getInstructors();
    public ArrayList<Student> getStudents();
    public ArrayList<Course> getCourses();
    public ArrayList<Department> getDepartments();
}
