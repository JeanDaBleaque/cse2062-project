public class CourseGradesTableModelObject {

    private Student student;
    private StudentCourse studentCourse;

    public CourseGradesTableModelObject(Student student, StudentCourse studentCourse) {
        this.student = student;
        this.studentCourse = studentCourse;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }
}
