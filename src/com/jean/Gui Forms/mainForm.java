import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainForm extends JFrame {
    private JPanel pnlFirst;
    private JPanel panel1;
    private JPanel pnlSide;
    private JPanel pnlMain;
    private JSplitPane pnlSplitMain;
    private JPanel pnlMainPage;
    private JPanel sidePnlPic;
    private JPanel sidePnlCourse;
    private JPanel sidePnlStudent;
    private JPanel sidePnlExit;
    private JPanel pnlCourseMain;
    private JPanel pnlStudentMain;
    private JPanel pnlCourseFirst;
    private JPanel pnlCourseAdd;
    private JPanel pnlCourseList;
    private JPanel pnlCourseDelete;
    private JPanel pnlCourseEdit;
    private JPanel pnlStudentAdd;
    private JPanel pnlStudentDelete;
    private JPanel pnlStudentList;
    private JPanel pnlStudentEdit;
    private JPanel pnlStudentFirst;
    private JPanel pageCourseList;
    private JPanel pageStudentAdd;
    private JPanel pageStudentList;
    private JPanel pageStudentDelete;
    private JPanel pageStudentEdit;
    private JLabel lbNameSide;
    private JLabel lbPrefix;
    private JTextField tfAddStName;
    private JTextField tfAddStSurname;
    private JTextField tfAddStMail;
    private JTextField tfAddStPhone;
    private JTextField tfAddStAddress;
    private JTextField tfAddStPassword;
    private JButton addStudentButton;
    private JButton clearButton;
    private JButton btnStDelele;
    private JLabel lbStDelNotification;
    private JTextField tfStEditName;
    private JTextField tfStEditSurname;
    private JTextField tfStEditMail;
    private JTextField tfStEditPhone;
    private JTextField tfStEditAddress;
    private JTextField tfStEditPassword;
    private JButton commitChangesButton;
    private JComboBox comboBoxDelStudent;
    private JComboBox comboBoxStEdit;
    private JPanel pageAddCourse;
    private JPanel pageDelCourse;
    private JPanel pageEditCourse;
    private JTextField tfAddCourseID;
    private JTextField tfAddCourseName;
    private JTextField tfAddInstructorID;
    private JTextField tfAddCourseCredit;
    private JTextField tfAddCourseM1P;
    private JTextField tfAddCourseM2P;
    private JTextField tfAddCourseFinalP;
    private JComboBox comboBoxDelCourse;
    private JButton btnDelCourse;
    private JButton btnAddCourse;
    private JButton btnCourseAddclear;
    private JTextField tfEditCourseID;
    private JTextField tfEditCourseName;
    private JTextField tfEditInstructor;
    private JTextField tfEditCourseCredit;
    private JTextField tfEditCourseM1P;
    private JTextField tfEditCourseM2P;
    private JLabel tfEditCourseFP;
    private JPanel pnlStudentGrades;
    private JPanel pageStudentGrades;
    private JComboBox comboBoxGradeCourse;
    private JComboBox comboBoxGradeStudent;
    private JTextField tfGradeM1;
    private JTextField tfGradeM2;
    private JTextField tfGradeFinal;
    private JTextField tfGradeLetter;
    private JButton btnGradeChange;
    private Color sideBarColorHover = new Color(70, 70, 70);
    private Color sideBarColorNormal = new Color(52, 52, 52);
    private Color errorEnter = new Color(205, 24, 48);
    private Color errorCorrection = new Color(170, 170, 170);
    private CardLayout c1 = (CardLayout)pnlMain.getLayout();
    private CardLayout c2 = (CardLayout)pnlCourseMain.getLayout();
    private CardLayout c3 = (CardLayout)pnlStudentMain.getLayout();

    public mainForm(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setContentPane(pnlSplitMain);
        setSize(1200,700);
        setTitle("Student Management System");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(850, 550));
        setLocationRelativeTo(null);
        pnlSplitMain.setDividerSize(2);

        sidePnlCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    c1.show(pnlMain,"Card2");
                    c2.show(pnlCourseMain,"Card1");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                sidePnlCourse.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                sidePnlCourse.setBackground(sideBarColorNormal);

            }
        });
        sidePnlStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c1.show(pnlMain,"Card3");
                c3.show(pnlStudentMain,"Card2");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                sidePnlStudent.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                sidePnlStudent.setBackground(sideBarColorNormal);

            }
        });
        sidePnlExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainForm.this.dispose();
                new loginForm();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                sidePnlExit.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                sidePnlExit.setBackground(sideBarColorNormal);

            }
        });
        pnlCourseAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c2.show(pnlCourseMain,"Card3");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlCourseAdd.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlCourseAdd.setBackground(sideBarColorNormal);

            }
        });
        pnlCourseList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c2.show(pnlCourseMain,"Card2");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlCourseList.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlCourseList.setBackground(sideBarColorNormal);

            }
        });
        pnlCourseDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c2.show(pnlCourseMain,"Card4");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlCourseDelete.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlCourseDelete.setBackground(sideBarColorNormal);

            }
        });
        pnlCourseEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c2.show(pnlCourseMain,"Card5");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlCourseEdit.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlCourseEdit.setBackground(sideBarColorNormal);

            }
        });
        btnCourseAddclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAddCourseID.setText("");
                tfAddCourseCredit.setText("");
                tfAddCourseFinalP.setText("");
                tfAddCourseM1P.setText("");
                tfAddCourseM2P.setText("");
                tfAddCourseName.setText("");
                tfAddInstructorID.setText("");

            }
        });
        pnlStudentAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                c3.show(pnlStudentMain,"Card1");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentAdd.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentAdd.setBackground(sideBarColorNormal);

            }
        });
        pnlStudentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c3.show(pnlStudentMain,"Card3");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentList.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentList.setBackground(sideBarColorNormal);

            }
        });
        pnlStudentDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c3.show(pnlStudentMain,"Card4");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentDelete.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentDelete.setBackground(sideBarColorNormal);

            }
        });
        pnlStudentEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c3.show(pnlStudentMain,"Card5");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentEdit.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentEdit.setBackground(sideBarColorNormal);

            }
        });
        pnlStudentGrades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c3.show(pnlStudentMain,"Card6");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentGrades.setBackground(sideBarColorHover);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentGrades.setBackground(sideBarColorNormal);

            }
        });


    }

}
