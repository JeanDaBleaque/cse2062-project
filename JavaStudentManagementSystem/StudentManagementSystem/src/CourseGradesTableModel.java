import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CourseGradesTableModel extends AbstractTableModel {

    private static final int COURSE_ID_COL = 0;
    private static final int STUDENT_ID_COL = 1;
    private static final int STUDENT_NAME_COL = 2;
    private static final int STUDENT_SURNAME_COL = 3;
    private static final int STUDENT_MIDTERM1_COL = 4;
    private static final int STUDENT_MIDTERM2_COL = 5;
    private static final int STUDENT_FINAL_COL = 6;

    private String[] columnNames = {"Course ID", "Student ID", "Name", "Surname", "Midterm 1", "Midterm 2", "Final"};
    private ArrayList<CourseGradesTableModelObject> objects;
    private Instructor instructor;

    public CourseGradesTableModel(Instructor instructor, ArrayList<CourseGradesTableModelObject> students) {
        this.instructor = instructor;
        this.objects = students;
    }

    @Override
    public int getRowCount() {
        return objects.size();
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
        CourseGradesTableModelObject object = objects.get(rowIndex);
        switch (columnIndex) {
            case COURSE_ID_COL:
                return object.getStudentCourse().getCourseId();
            case STUDENT_ID_COL:
                return object.getStudent().getId();
            case STUDENT_NAME_COL:
                return object.getStudent().getName();
            case STUDENT_SURNAME_COL:
                return object.getStudent().getSurname();
            case STUDENT_MIDTERM1_COL:
                return object.getStudentCourse().getMidterm1();
            case STUDENT_MIDTERM2_COL:
                return object.getStudentCourse().getMidterm2();
            case STUDENT_FINAL_COL:
                return object.getStudentCourse().getFinalExam();
            default:
                return object.getStudentCourse().getCourseId();
        }
    }
}
