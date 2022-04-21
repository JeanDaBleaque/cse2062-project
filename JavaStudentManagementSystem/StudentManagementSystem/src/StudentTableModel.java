import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentTableModel extends AbstractTableModel {

    private static final int STUDENT_ID_COL = 0;
    private static final int STUDENT_NAME_COL = 1;
    private static final int STUDENT_SURNAME_COL = 2;
    private static final int STUDENT_GPA_COL = 3;
    private static final int STUDENT_TOTAL_CREDITS_COL = 4;
    private static final int STUDENT_MAJOR_COL = 5;
    private static final int STUDENT_DEPARTMENT_COL = 6;
    private static final int STUDENT_EMAIL_COL = 7;
    private static final int STUDENT_PHONE_COL = 8;
    private static final int STUDENT_ADDRESS_COL = 9;
    private static final int STUDENT_CREATED_AT_COL = 10;
    private static final int STUDENT_UPDATED_AT_COL = 11;
    private static final int STUDENT_EXPIRE_AT_COL = 12;
    private static final int STUDENT_STATUS_COL = 13;

    private String[] columnNames = {"ID", "Name", "Surname", "GPA", "Total Credits", "Major", "Department", "Mail", "Phone", "Address", "Created At", "Updated At", "Expire At", "Status"};
    private ArrayList<Student> students;
    private Instructor instructor;

    public StudentTableModel(Instructor instructor, ArrayList<Student> students) {
        this.instructor = instructor;
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
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
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case STUDENT_ID_COL:
                return student.getId();
            case STUDENT_NAME_COL:
                return student.getName();
            case STUDENT_SURNAME_COL:
                return student.getSurname();
            case STUDENT_GPA_COL:
                return student.getGpa();
            case STUDENT_TOTAL_CREDITS_COL:
                return student.getTotalCredits();
            case STUDENT_MAJOR_COL:
                return student.getMajor();
            case STUDENT_DEPARTMENT_COL:
                return student.getDepartment();
            case STUDENT_EMAIL_COL:
                return student.getEmail();
            case STUDENT_PHONE_COL:
                return student.getPhone();
            case STUDENT_ADDRESS_COL:
                return student.getAddress();
            case STUDENT_CREATED_AT_COL:
                return student.getCreatedAt();
            case STUDENT_UPDATED_AT_COL:
                return student.getUpdatedAt();
            case STUDENT_EXPIRE_AT_COL:
                return student.getExpireAt();
            case STUDENT_STATUS_COL:
                return student.getStatus();
        }
        return null;
    }
}
