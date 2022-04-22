import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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
    private JButton addStudentButton;
    private JButton clearButton;
    private JTextField tfStEditName;
    private JTextField tfStEditSurname;
    private JTextField tfStEditMail;
    private JTextField tfStEditPhone;
    private JTextField tfStEditAddress;
    private JTextField tfStEditPassword;
    private JButton commitChangesButton;
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
    private JButton btnAddCourse;
    private JButton btnCourseAddclear;
    private JTextField tfEditCourseID;
    private JTextField tfEditCourseName;
    private JTextField tfEditInstructor;
    private JTextField tfEditCourseCredit;
    private JTextField tfEditCourseM1P;
    private JTextField tfEditCourseM2P;
    private JLabel lbEditCourseFP;
    private JPanel pnlStudentGrades;
    private JPanel pageStudentGrades;
    private JComboBox comboBoxGradeCourse;
    private JComboBox comboBoxGradeStudent;
    private JFormattedTextField tfGradeM1;
    private JFormattedTextField tfGradeM2;
    private JFormattedTextField tfGradeFinal;
    private JTextField tfGradeLetter;
    private JButton btnGradeChange;
    private JLabel imgPhoto;
    private JTable courseListTable;
    private JTextField tfCourseNameList;
    private JLabel lbCourseNameList;
    private JTable courseDeleteTable;
    private JLabel lbDelCourseName;
    private JTextField tfDelCourseName;
    private JButton btnDelCourse;
    private JComboBox comboBoxEditCourse;
    private JComboBox comboBoxEditCourseInstructor;
    private JTextField tfEditCourseFP;
    private JButton btnEditCourseCommit;
    private JLabel lbMajor;
    private JTextField tfAddStMajor;
    private JPasswordField tfAddStPassword;
    private JLabel lbStudentPostFix;
    private JComboBox comboBoxDepartment;
    private JTable tableStudentList;
    private JTextField tfStudentListName;
    private JButton btnStDelete;
    private JTable tableStudentDeleteList;
    private JTextField tfStudentDeleteName;
    private JLabel lbEditStudentMail;
    private JComboBox comboBoxStEditDepartment;
    private JTextField tfStEditMajor;
    private JPanel pnlStudentEnroll;
    private JPanel pnlStudentCourseGrades;
    private JLabel lbStudentCourseStatus;
    private JPanel pageCourseGrades;
    private JTextField tfCourseGradesStudentName;
    private JComboBox comboBoxCourseGrades;
    private JTable tableCourseGrades;
    private JPanel sidePnlPrefix;
    private JPanel pnlCourseListSearch;
    private JScrollPane pnlScrollCourseList;
    private JScrollPane pnlScrollCourseDel;
    private JPanel pnlCourseDelSearch;
    private JPanel pnlBtnDelCourseDel;
    private JScrollPane pnlScrollStudentList;
    private JPanel pnlStudentListSearch;
    private JScrollPane pnlScrollStudentDel;
    private JPanel pnlStudentDelSearch;
    private JPanel pnlBtnStuDel;
    private JScrollPane pnlScrollCourseGradeSt;
    private JPanel pnlCourseGradeSearch;
    private JPanel pnlCourseGradeCourse;
    private JScrollPane table;
    private Color sideBarColorHover = new Color(96, 96, 96);
    private Color sideBarColorNormal = new Color(72, 72, 72);
    private Color errorEnter = new Color(205, 24, 48);
    private Color errorCorrection = new Color(170, 170, 170);
    private CardLayout c1 = (CardLayout) pnlMain.getLayout();
    private CardLayout c2 = (CardLayout) pnlCourseMain.getLayout();
    private CardLayout c3 = (CardLayout) pnlStudentMain.getLayout();

    public mainForm(User u1) {
        Instructor instructor = (Instructor) u1;
        DatabaseManager manager = DatabaseManager.getInstance();
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
        lbPrefix.setText(((Instructor) u1).getPrefix());
        lbNameSide.setText(u1.getName() + " " + u1.getSurname());
        System.out.println(u1.getId());
        try {
            imgPhoto.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(u1.getId() + ".png"))).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            imgPhoto.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("user.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
        }
        setContentPane(pnlSplitMain);
        setSize(1200, 700);
        setTitle("Student Management System");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(850, 550));
        setLocationRelativeTo(null);
        pnlSplitMain.setDividerSize(2);

        sidePnlCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c1.show(pnlMain, "Card2");
                c2.show(pnlCourseMain, "Card1");
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
                c1.show(pnlMain, "Card3");
                c3.show(pnlStudentMain, "Card2");
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
                c2.show(pnlCourseMain, "Card3");
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
                manager.getCourses(instructor);
                CourseTableModel ctm = new CourseTableModel(instructor, instructor.getCourses());
                courseListTable.setModel(ctm);
                c2.show(pnlCourseMain, "Card2");
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
                manager.getCourses(instructor);
                CourseTableModel ctm = new CourseTableModel(instructor, instructor.getCourses());
                courseDeleteTable.setModel(ctm);
                c2.show(pnlCourseMain, "Card4");
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
                University university = instructor.getUniversity();
                ArrayList<Instructor> instructors = manager.getInstructors(university.getId());
                manager.getCourses(instructor);
                comboBoxEditCourse.removeAllItems();
                comboBoxEditCourseInstructor.removeAllItems();
                for (Course c : instructor.getCourses()) {
                    comboBoxEditCourse.addItem(c);
                }
                for (Instructor i : instructors) {
                    comboBoxEditCourseInstructor.addItem(i);
                }

                for (int i = 0; i < comboBoxEditCourseInstructor.getItemCount(); i++) {
                    if (((Instructor) comboBoxEditCourseInstructor.getItemAt(i)).getId() == instructor.getId()) {
                        comboBoxEditCourseInstructor.setSelectedIndex(i);
                    }
                }

                c2.show(pnlCourseMain, "Card5");
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
                lbStudentPostFix.setText("@" + instructor.getUniversity().getStudentPostFix());
                University university = instructor.getUniversity();
                university.setDepartments(manager.getDepartments(university.getId()));
                ArrayList<Department> departments = university.getDepartments();
                comboBoxDepartment.removeAllItems();
                for (Department d : departments) {
                    comboBoxDepartment.addItem(d);
                }
                c3.show(pnlStudentMain, "Card1");
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
                ArrayList<Student> students = manager.getStudents(instructor.getUniversity().getId());
                StudentTableModel stm = new StudentTableModel(instructor, students);
                tableStudentList.setModel(stm);
                c3.show(pnlStudentMain, "Card3");
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
                ArrayList<Student> students = manager.getStudents(instructor.getUniversity().getId());
                StudentTableModel stm = new StudentTableModel(instructor, students);
                tableStudentDeleteList.setModel(stm);
                c3.show(pnlStudentMain, "Card4");
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
        pnlStudentCourseGrades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manager.getCourses(instructor);
                ArrayList<Course> courses = instructor.getCourses();

                for (Course c : courses) {
                    comboBoxCourseGrades.addItem(c);
                }

                setCourseGradeList(instructor, "");
                c3.show(pnlStudentMain, "Card7");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pnlStudentCourseGrades.setBackground(sideBarColorHover);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                pnlStudentCourseGrades.setBackground(sideBarColorNormal);

            }
        });
        pnlStudentEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                University university = instructor.getUniversity();
                university.setDepartments(manager.getDepartments(university.getId()));
                ArrayList<Department> departments = university.getDepartments();
                ArrayList<Student> students = manager.getStudents(instructor.getUniversity().getId());
                lbEditStudentMail.setText("@" + instructor.getUniversity().getStudentPostFix());
                comboBoxStEdit.removeAllItems();
                comboBoxStEditDepartment.removeAllItems();
                for (Student s : students) {
                    comboBoxStEdit.addItem(s);
                }
                for (Department d : departments) {
                    comboBoxStEditDepartment.addItem(d);
                }
                c3.show(pnlStudentMain, "Card5");
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
                ArrayList<Student> students = manager.getStudents(instructor.getUniversity().getId());
                manager.getCourses(instructor);

                comboBoxGradeStudent.removeAllItems();
                comboBoxGradeCourse.removeAllItems();

                for (Student s : students) {
                    comboBoxGradeStudent.addItem(s);
                }
                for (Course c : instructor.getCourses()) {
                    comboBoxGradeCourse.addItem(c);
                }

                NumberFormat format = NumberFormat.getInstance();
                NumberFormatter formatter = new NumberFormatter(format);
                formatter.setValueClass(Integer.class);
                formatter.setMinimum(0);
                formatter.setMaximum(100);
                DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);

                tfGradeM1.setFormatterFactory(factory);
                tfGradeM2.setFormatterFactory(factory);
                tfGradeFinal.setFormatterFactory(factory);

                setData();

                c3.show(pnlStudentMain, "Card6");
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

        tfCourseNameList.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String courseName = tfCourseNameList.getText();
                courseName = courseName.toLowerCase();
                ArrayList<Course> courses = null;

                if (courseName != null && courseName.trim().length() > 0) {
                    courses = instructor.findCoursesByName(courseName);
                } else {
                    courses = instructor.getCourses();
                }
                CourseTableModel curModel = new CourseTableModel(instructor, courses);
                courseListTable.setModel(curModel);
            }
        });

        btnAddCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfAddCourseID.getText().equals("") || tfAddCourseName.getText().equals("") || tfAddCourseCredit.getText().equals("") || tfAddCourseM1P.getText().equals("") || tfAddCourseM2P.getText().equals("") || tfAddCourseFinalP.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    try {
                        int credit = Integer.parseInt(tfAddCourseCredit.getText());
                        float m1p = Float.parseFloat(tfAddCourseM1P.getText());
                        float m2p = Float.parseFloat(tfAddCourseM2P.getText());
                        float finalp = Float.parseFloat(tfAddCourseFinalP.getText());
                        if (credit < 0 || m1p < 0 || m2p < 0 || finalp < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter positive numbers!");
                        } else if (m1p + m2p + finalp != 1f) {
                            JOptionPane.showMessageDialog(null, "Please enter valid percentages!");
                        } else {
                            Course courseToAdd = new Course(tfAddCourseID.getText(), tfAddCourseName.getText(), credit, m1p, m2p, finalp, instructor);
                            boolean added = manager.addCourse(courseToAdd);
                            if (added) {
                                tfAddCourseID.setText("");
                                tfAddCourseName.setText("");
                                tfAddCourseCredit.setText("");
                                tfAddCourseM1P.setText("");
                                tfAddCourseM2P.setText("");
                                tfAddCourseFinalP.setText("");
                                JOptionPane.showMessageDialog(null, "Course added successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Course addition failed!");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter integers for credits and float for percentages!");
                    }
                }
            }
        });
        btnCourseAddclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAddCourseID.setText("");
                tfAddCourseName.setText("");
                tfAddCourseCredit.setText("");
                tfAddCourseM1P.setText("");
                tfAddCourseM2P.setText("");
                tfAddCourseFinalP.setText("");
            }
        });

        tfDelCourseName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String courseName = tfDelCourseName.getText();
                courseName = courseName.toLowerCase();
                ArrayList<Course> courses = null;
                if (courseName != null && courseName.trim().length() > 0) {
                    courses = instructor.findCoursesByName(courseName);
                } else {
                    courses = instructor.getCourses();
                }
                CourseTableModel curModel = new CourseTableModel(instructor, courses);
                courseDeleteTable.setModel(curModel);
            }
        });
        btnDelCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = courseDeleteTable.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(null, "Please select a course to delete!");
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this course?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        String courseToDelId = (String) courseDeleteTable.getValueAt(selectedRow, 0);
                        Course courseToDel = null;
                        for (Course course : instructor.getCourses()) {
                            if (course.getCourseId().equalsIgnoreCase(courseToDelId)) {
                                courseToDel = course;
                                break;
                            }
                        }
                        boolean deleted = manager.deleteCourse(courseToDel);
                        if (deleted) {
                            JOptionPane.showMessageDialog(null, "Course deleted successfully!");
                            tfDelCourseName.setText("");
                            manager.getCourses(instructor);
                            CourseTableModel curModel = new CourseTableModel(instructor, instructor.getCourses());
                            courseDeleteTable.setModel(curModel);
                        } else {
                            JOptionPane.showMessageDialog(null, "Course deletion failed!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Course deletion cancelled!");
                    }
                }
            }
        });
        comboBoxEditCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course selectedCourse = (Course) comboBoxEditCourse.getSelectedItem();
                if (selectedCourse != null) {
                    tfEditCourseID.setText(selectedCourse.getCourseId());
                    tfEditCourseName.setText(selectedCourse.getCourseName());
                    for (int i = 0; i < comboBoxEditCourseInstructor.getItemCount(); i++) {
                        if (((Instructor) comboBoxEditCourseInstructor.getItemAt(i)).getId() == instructor.getId()) {
                            comboBoxEditCourseInstructor.setSelectedIndex(i);
                        }
                    }
                    tfEditCourseCredit.setText(String.valueOf(selectedCourse.getCredit()));
                    tfEditCourseM1P.setText(String.valueOf(selectedCourse.getpM1()));
                    tfEditCourseM2P.setText(String.valueOf(selectedCourse.getpM2()));
                    tfEditCourseFP.setText(String.valueOf(selectedCourse.getpFinal()));
                }
            }
        });
        btnEditCourseCommit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfEditCourseID.getText().equals("") || tfEditCourseName.getText().equals("") || tfEditCourseCredit.getText().equals("") || tfEditCourseM1P.getText().equals("") || tfEditCourseM2P.getText().equals("") || tfEditCourseFP.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    try {
                        int credit = Integer.parseInt(tfEditCourseCredit.getText());
                        float m1p = Float.parseFloat(tfEditCourseM1P.getText());
                        float m2p = Float.parseFloat(tfEditCourseM2P.getText());
                        float finalp = Float.parseFloat(tfEditCourseFP.getText());
                        if (credit < 0 || m1p < 0 || m2p < 0 || finalp < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter positive numbers!");
                        } else if (m1p + m2p + finalp != 1f) {
                            JOptionPane.showMessageDialog(null, "Please enter valid percentages!");
                        } else {
                            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to commit the changes?", "Confirm", JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                Course courseToEdit = new Course(tfEditCourseID.getText(), tfEditCourseName.getText(), credit, m1p, m2p, finalp, (Instructor) comboBoxEditCourseInstructor.getSelectedItem());
                                boolean updated = manager.editCourses(courseToEdit, ((Course) comboBoxEditCourse.getSelectedItem()).getCourseId());
                                if (updated) {
                                    JOptionPane.showMessageDialog(null, "Course updated successfully!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Course update failed!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Course editing cancelled!");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter integers for credits and float for percentages!");
                    }
                }
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfAddStName.getText().equals("") || tfAddStSurname.getText().equals("") || tfAddStMail.getText().equals("") || tfAddStPhone.getText().equals("") || tfAddStAddress.getText().equals("") || tfAddStPassword.getText().equals("") || tfAddStMajor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    try {
                        long phone = Long.parseLong(tfAddStPhone.getText());
                        if (phone < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter valid phone number!");
                        } else {
                            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to add the student?", "Confirm", JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                String pattern = "MM-dd-yyyy";
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                Date currentDate = new Date();
                                String created_at = simpleDateFormat.format(currentDate);
                                long id = currentDate.getTime();
                                currentDate.setYear(currentDate.getYear() + 7);
                                String expire_at = simpleDateFormat.format(currentDate);
                                Student studentToAdd = new Student(tfAddStName.getText(), tfAddStSurname.getText(), tfAddStMail.getText() + "@" + instructor.getUniversity().getStudentPostFix(),
                                        tfAddStPhone.getText(), tfAddStAddress.getText(), tfAddStPassword.getText(), true, created_at,
                                        created_at, "student", id, 0, 0, tfAddStMajor.getText(), expire_at,
                                        instructor.getUniversity(), ((Department) comboBoxDepartment.getSelectedItem()).getDepartmentName());
                                boolean added = manager.addStudent(studentToAdd);
                                if (added) {
                                    tfAddStName.setText("");
                                    tfAddStSurname.setText("");
                                    tfAddStMail.setText("");
                                    tfAddStPhone.setText("");
                                    tfAddStAddress.setText("");
                                    tfAddStPassword.setText("");
                                    tfAddStMajor.setText("");
                                    JOptionPane.showMessageDialog(null, "Student added successfully!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Student adding failed!");
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid phone number!");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAddStName.setText("");
                tfAddStSurname.setText("");
                tfAddStMail.setText("");
                tfAddStPhone.setText("");
                tfAddStAddress.setText("");
                tfAddStPassword.setText("");
                tfAddStMajor.setText("");
            }
        });

        tfStudentListName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String studentName = tfStudentListName.getText();
                studentName = studentName.toLowerCase();
                ArrayList<Student> students = null;

                if (studentName != null && studentName.trim().length() > 0) {
                    students = manager.findStudentsByName(studentName, manager.getStudents(instructor.getUniversity().getId()));
                } else {
                    students = manager.getStudents(instructor.getUniversity().getId());
                }

                StudentTableModel curModel = new StudentTableModel(instructor, students);
                tableStudentList.setModel(curModel);
            }
        });

        tfStudentDeleteName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String studentName = tfStudentDeleteName.getText();
                studentName = studentName.toLowerCase();
                ArrayList<Student> students = null;

                if (studentName != null && studentName.trim().length() > 0) {
                    students = manager.findStudentsByName(studentName, manager.getStudents(instructor.getUniversity().getId()));
                } else {
                    students = manager.getStudents(instructor.getUniversity().getId());
                }

                StudentTableModel curModel = new StudentTableModel(instructor, students);
                tableStudentDeleteList.setModel(curModel);
            }
        });


        comboBoxStEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) comboBoxStEdit.getSelectedItem();
                if (selectedStudent != null) {
                    tfStEditName.setText(selectedStudent.getName());
                    tfStEditSurname.setText(selectedStudent.getSurname());
                    String[] mail = selectedStudent.getEmail().split("@");
                    tfStEditMail.setText(mail[0]);
                    tfStEditPhone.setText(selectedStudent.getPhone());
                    tfStEditAddress.setText(selectedStudent.getAddress());
                    tfStEditPassword.setText(selectedStudent.getPassword());
                    tfStEditMajor.setText(selectedStudent.getMajor());
                    for (int i = 0; i < comboBoxStEditDepartment.getItemCount(); i++) {
                        if (comboBoxStEditDepartment.getItemAt(i).equals(selectedStudent)) {
                            if (((Student) comboBoxStEditDepartment.getItemAt(i)).getDepartment().equalsIgnoreCase(selectedStudent.getDepartment())) {
                                comboBoxStEditDepartment.setSelectedIndex(i);
                            }
                        }
                    }
                }
            }
        });
        commitChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfStEditName.getText().equals("") || tfStEditSurname.getText().equals("") || tfStEditMail.getText().equals("") || tfStEditPhone.getText().equals("") || tfStEditAddress.getText().equals("") || tfStEditPassword.getText().equals("") || tfStEditMajor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    try {
                        long phone = Long.parseLong(tfStEditPhone.getText());
                        if (phone < 0) {
                            JOptionPane.showMessageDialog(null, "Please enter valid phone number!");
                        } else {
                            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to commit changes?");
                            if (result == JOptionPane.YES_OPTION) {
                                String pattern = "MM-dd-yyyy";
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                Date currentDate = new Date();
                                String updated_at = simpleDateFormat.format(currentDate);
                                Student selectedStudent = (Student) comboBoxStEdit.getSelectedItem();
                                Student updateStudent = new Student(tfStEditName.getText(), tfStEditSurname.getText(),
                                        tfStEditMail.getText() + "@" + instructor.getUniversity().getStudentPostFix(),
                                        tfStEditPhone.getText(), tfStEditAddress.getText(), tfStEditPassword.getText(),
                                        true, selectedStudent.getCreatedAt(), updated_at, "student", selectedStudent.getId(),
                                        selectedStudent.getGpa(), selectedStudent.getTotalCredits(), tfStEditMajor.getText(), selectedStudent.getExpireAt(),
                                        instructor.getUniversity(), ((Department) comboBoxStEditDepartment.getSelectedItem()).getDepartmentName());
                                boolean updated = manager.updateStudent(updateStudent);
                                if (updated) {
                                    JOptionPane.showMessageDialog(null, "Changes committed!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Changes not committed!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Changes not committed!");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid phone number!");
                    }
                }
            }
        });
        btnStDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableStudentDeleteList.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(null, "Please select a student!");
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?");
                    if (result == JOptionPane.YES_OPTION) {
                        Long studentToDeleteId = (Long) tableStudentDeleteList.getValueAt(selectedRow, 0);
                        Student studentToDelete = null;
                        for (Student student : manager.getStudents(instructor.getUniversity().getId())) {
                            if (student.getId() == studentToDeleteId) {
                                studentToDelete = student;
                                break;
                            }
                        }
                        boolean deleted = manager.deleteStudent(studentToDelete);
                        if (deleted) {
                            JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                            tfStudentDeleteName.setText("");
                            StudentTableModel studentTableModel = new StudentTableModel(instructor, manager.getStudents(instructor.getUniversity().getId()));
                            tableStudentDeleteList.setModel(studentTableModel);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student deletion failed!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not deleted!");
                    }
                }
            }
        });

        comboBoxGradeStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData();
            }
        });
        comboBoxGradeCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData();
            }
        });

        tfGradeM1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                setTfGradeLetter();
            }
        });

        tfGradeM2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                setTfGradeLetter();
            }
        });

        tfGradeFinal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                setTfGradeLetter();
            }
        });

        btnGradeChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfGradeM1.getText().equals("") || tfGradeM2.getText().equals("") || tfGradeFinal.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the grades!");
                } else {
                    Student selectedStudent = (Student) comboBoxGradeStudent.getSelectedItem();
                    Course selectedCourse = (Course) comboBoxGradeCourse.getSelectedItem();
                    StudentCourse selectedStudentCourse = null;
                    for (StudentCourse studentCourse : selectedStudent.getCourses()) {
                        if (studentCourse.getCourseId().equalsIgnoreCase(selectedCourse.getCourseId())) {
                            selectedStudentCourse = studentCourse;
                            break;
                        }
                    }
                    if (selectedStudentCourse != null) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to change grade for " + selectedStudent.getName() + " in " + selectedCourse.getCourseName() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            selectedStudentCourse.setMidterm1(Integer.parseInt(tfGradeM1.getText()));
                            selectedStudentCourse.setMidterm2(Integer.parseInt(tfGradeM2.getText()));
                            selectedStudentCourse.setFinalExam(Integer.parseInt(tfGradeFinal.getText()));
                            selectedStudentCourse.setLetterGrade(tfGradeLetter.getText());
                            boolean updated = manager.updateStudentCourse(selectedStudent, selectedStudentCourse);
                            if (updated) {
                                JOptionPane.showMessageDialog(null, "Grade changed!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error occurred!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Grade not changed!");
                        }
                    } else {
                        int result = JOptionPane.showConfirmDialog(null, "Student is not enrolled this course. Are you sure you want to add this student to this course?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            StudentCourse studentCourse = new StudentCourse(selectedCourse.getCourseId(), Integer.parseInt(tfGradeM1.getText()), Integer.parseInt(tfGradeM2.getText()), Integer.parseInt(tfGradeFinal.getText()));
                            boolean added = manager.addStudentToCourse(selectedStudent, studentCourse);
                            if (added) {
                                JOptionPane.showMessageDialog(null, "Student enrolled!");
                                lbStudentCourseStatus.setText("Student is already enrolled in this course!");
                                lbStudentCourseStatus.setForeground(Color.green);
                            } else {
                                JOptionPane.showMessageDialog(null, "Error occurred!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Grade not changed!");
                        }
                    }
                }
            }
        });

        comboBoxCourseGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCourseGradeList(instructor, "");
            }
        });

        tfCourseGradesStudentName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                setCourseGradeList(instructor, tfCourseGradesStudentName.getText());
            }
        });
    }

    public void setData() {
        tfGradeM1.setText("");
        tfGradeM2.setText("");
        tfGradeFinal.setText("");
        tfGradeLetter.setText("");
        Student selectedStudent = (Student) comboBoxGradeStudent.getSelectedItem();
        Course selectedCourse = (Course) comboBoxGradeCourse.getSelectedItem();
        DatabaseManager manager = DatabaseManager.getInstance();
        manager.getStudentCourses(selectedStudent);
        if (selectedStudent != null && selectedCourse != null) {
            for (StudentCourse studentCourse : selectedStudent.getCourses()) {
                if (studentCourse.getCourseId().equalsIgnoreCase(selectedCourse.getCourseId())) {
                    lbStudentCourseStatus.setText("Student is already enrolled in this course!");
                    lbStudentCourseStatus.setForeground(Color.green);
                    tfGradeM1.setText(String.valueOf(studentCourse.getMidterm1()));
                    tfGradeM2.setText(String.valueOf(studentCourse.getMidterm2()));
                    tfGradeFinal.setText(String.valueOf(studentCourse.getFinalExam()));
                    if (tfGradeM1.getText().equals("") || tfGradeM2.getText().equals("") || tfGradeFinal.getText().equals("")) {
                        tfGradeLetter.setText("");
                    } else {
                        try {
                            int midterm1 = Integer.parseInt(tfGradeM1.getText());
                            int midterm2 = Integer.parseInt(tfGradeM2.getText());
                            int finalExam = Integer.parseInt(tfGradeFinal.getText());
                            studentCourse.setMidterm1(midterm1);
                            studentCourse.setMidterm2(midterm2);
                            studentCourse.setFinalExam(finalExam);
                            studentCourse.calculateGrade(selectedCourse);
                            tfGradeLetter.setText(studentCourse.getLetterGrade());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Please enter valid exam results!");
                        }
                    }
                    break;
                } else {
                    lbStudentCourseStatus.setText("Student is not enrolled in this course!");
                    lbStudentCourseStatus.setForeground(Color.red);
                }
            }
            if (selectedStudent.getCourses().size() == 0) {
                lbStudentCourseStatus.setText("Student is not enrolled in any course!");
                lbStudentCourseStatus.setForeground(Color.blue);
            }
        } else {
            System.out.println("Please select a student and a course!");
        }
    }

    public void setTfGradeLetter() {
        if (tfGradeM1.getText().equals("") || tfGradeM2.getText().equals("") || tfGradeFinal.getText().equals("")) {
            tfGradeLetter.setText("");
        } else {
            int midterm1 = Integer.parseInt(tfGradeM1.getText());
            int midterm2 = Integer.parseInt(tfGradeM2.getText());
            int finalGrade = Integer.parseInt(tfGradeFinal.getText());
            Course selectedCourse = (Course) comboBoxGradeCourse.getSelectedItem();
            tfGradeLetter.setText(StudentCourse.calculateGrade(selectedCourse, midterm1, midterm2, finalGrade));
        }
    }

    public void setCourseGradeList(Instructor instructor, String searchName) {
        DatabaseManager manager = DatabaseManager.getInstance();
        ArrayList<Student> students = manager.getStudents(instructor.getUniversity().getId());
        ArrayList<CourseGradesTableModelObject> objectsToAdd = new ArrayList<>();
        Course selectedCourse = (Course) comboBoxCourseGrades.getSelectedItem();
        for (Student s : students) {
            manager.getStudentCourses(s);
            for (StudentCourse sc : s.getCourses()) {
                if (sc.getCourseId().equalsIgnoreCase(selectedCourse.getCourseId()) && s.getName().toLowerCase().contains(searchName.toLowerCase())) {
                    sc.calculateGrade(selectedCourse);
                    objectsToAdd.add(new CourseGradesTableModelObject(s, sc));
                }
            }
        }

        CourseGradesTableModel cgtm = new CourseGradesTableModel(instructor, objectsToAdd);
        tableCourseGrades.setModel(cgtm);
    }
}
