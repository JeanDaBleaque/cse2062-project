import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JTextField tfGradeM1;
    private JTextField tfGradeM2;
    private JTextField tfGradeFinal;
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
        imgPhoto.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(u1.getId() + ".png"))).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));

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
        pnlStudentEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                        } else if (m1p+m2p+finalp != 1f) {
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
                    //iterate combobox
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
                        } else if (m1p+m2p+finalp != 1f) {
                            JOptionPane.showMessageDialog(null, "Please enter valid percentages!");
                        } else {
                            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to commit the changes?", "Confirm", JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                Course courseToEdit = new Course(tfEditCourseID.getText(), tfEditCourseName.getText(), credit, m1p, m2p, finalp, (Instructor) comboBoxEditCourseInstructor.getSelectedItem());
                                boolean updated = manager.editCourses(courseToEdit, ((Course)comboBoxEditCourse.getSelectedItem()).getCourseId());
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
    }
}
