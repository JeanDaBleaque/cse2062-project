import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CourseTableModel extends AbstractTableModel {

    private static final int COURSE_ID_COL = 0;
    private static final int COURSE_NAME_COL = 1;
    private static final int COURSE_CREDIT_COL = 2;
    private static final int COURSE_INSTRUCTOR_COL = 3;
    private static final int COURSE_MIDTERM1_PERCENT_COL = 4;
    private static final int COURSE_MIDTERM2_PERCENT_COL = 5;
    private static final int COURSE_FINAL_PERCENT_COL = 6;

    private String[] columnNames = {"Course ID", "Course Name", "Credit", "Instructor", "Midterm 1 Percent", "Midterm 2 Percent", "Final Percent"};
    private ArrayList<Course> courses;
    private Instructor instructor;

    public CourseTableModel(Instructor instructor, ArrayList<Course> courses) {
        this.instructor = instructor;
        this.courses = courses;
    }

    @Override
    public int getRowCount() {
        return courses.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = courses.get(rowIndex);
        switch (columnIndex) {
            case COURSE_ID_COL:
                return course.getCourseId();
            case COURSE_NAME_COL:
                return course.getCourseName();
            case COURSE_CREDIT_COL:
                return course.getCredit();
            case COURSE_INSTRUCTOR_COL:
                return instructor.getName();
            case COURSE_MIDTERM1_PERCENT_COL:
                return course.getpM1();
            case COURSE_MIDTERM2_PERCENT_COL:
                return course.getpM2();
            case COURSE_FINAL_PERCENT_COL:
                return course.getpFinal();
            default:
                return course.getCourseId();
        }
    }
}
