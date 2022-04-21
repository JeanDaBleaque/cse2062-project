import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class loginForm extends JFrame{
    private static DatabaseManager manager;
    private JPanel mainFirstPane;
    private JPanel enterCardPane;
    private JPanel loginPane;
    private JPanel registerPane;
    private JPanel sideMenuPane;
    private JSplitPane splitLoginPane;
    private JTextField tfLogUser;
    private JPasswordField pfLogPassword;
    private JButton btnLogSignIn;
    private JButton btnClear;
    private JLabel lbLogUser;
    private JLabel lbLogPassword;
    private JTextField tfNameReg;
    private JTextField tfSurnameReg;
    private JTextField tfMailReg;
    private JTextField tfPhoneReg;
    private JTextField tfAddressReg;
    private JPasswordField pfPasswordReg;
    private JPasswordField pfCPassword;
    private JButton signUpButton;
    private JButton clearButton;
    private JLabel lbMessagePlace;
    private JLabel lbTitleRegister;

    private JPanel welcomePane;

    private JPanel loginSideBar;
    private JPanel registerSideBar;
    private JLabel lbLoginSB;
    private JLabel lbRegisterSB;
    private JLabel lbPrefix;
    private JTextField tfPrefix;
    private JTextField tfOffice;
    private JComboBox comboBoxDepartment;
    private JComboBox comboBoxInstructorMail;
    private JComboBox comboBoxUniversity;
    private JButton btnSelectPhoto;
    private JLabel lbWarning;
    private Color sideBarColorHover = new Color(96, 96, 96);
    private Color sideBarColorNormal = new Color(72, 72, 72);
    private Color errorEnter = new Color(205, 24, 48);
    private Color errorCorrection = new Color(170, 170, 170);
    private CardLayout c1 = (CardLayout)enterCardPane.getLayout();
    private String pathPhoto = "";
    public loginForm() {
        ArrayList<University> universities = manager.getUniversities();
        Iterator it1 = universities.iterator();

        while (it1.hasNext()) {
            University university = (University) it1.next();
            university.setDepartments(manager.getDepartments(university.getId()));
            comboBoxInstructorMail.addItem("@" + university.getInstructorPostFix());
            comboBoxUniversity.addItem(university);
            Iterator it2 = university.getDepartments().iterator();
            while (it2.hasNext()) {
                Department department = (Department) it2.next();
                comboBoxDepartment.addItem(department.getDepartmentName());
            }
        }

        setContentPane(mainFirstPane);
        setSize(1200,700);
        setTitle("Student Management System");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(700, 400));
        setLocationRelativeTo(null);
        splitLoginPane.setDividerSize(2);

        tfAddressReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tfMailReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tfNameReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tfPhoneReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tfSurnameReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        tfLogUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        pfLogPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pfCPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pfPasswordReg.setBorder(javax.swing.BorderFactory.createEmptyBorder());


        loginSideBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c1.show(enterCardPane,"Card1");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                loginSideBar.setBackground(sideBarColorHover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                loginSideBar.setBackground(sideBarColorNormal);
            }
        });
        registerSideBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c1.show(enterCardPane,"Card2");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                registerSideBar.setBackground(sideBarColorHover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                registerSideBar.setBackground(sideBarColorNormal);
            }
        });


        btnLogSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfLogUser.getText().equals("") || pfLogPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User u1 = manager.checkUser(Long.parseLong(tfLogUser.getText()), pfLogPassword.getText(), ((University)comboBoxUniversity.getSelectedItem()).getId());
                    if (u1 != null) {
                        if (u1.getStatus()) {
                            loginForm.this.dispose();
                            new mainForm(u1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Your account is not active yet. Please contact the administrator.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Check your id or password.");
                    }
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfLogUser.setText("");
                pfLogPassword.setText("");
                lbLogUser.setForeground(errorCorrection);
                lbLogPassword.setForeground(errorCorrection);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNameReg.getText().equals("") || tfSurnameReg.getText().equals("") || tfMailReg.getText().equals("") || tfPhoneReg.getText().equals("") || tfPrefix.getText().equals("") || tfOffice.getText().equals("") || pfPasswordReg.getText().equals("") || pfCPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String pattern = "MM-dd-yyyy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    Date currentDate = new Date();
                    String created_at = simpleDateFormat.format(currentDate);
                    long id = currentDate.getTime();
                    boolean registration = manager.addInstructor(new Instructor(tfNameReg.getText(), tfSurnameReg.getText(), tfMailReg.getText() + comboBoxInstructorMail.getSelectedItem(), tfPhoneReg.getText(),
                            tfAddressReg.getText(), pfPasswordReg.getText(), true, created_at, created_at, "instructor", id,
                            tfPrefix.getText(), tfOffice.getText(), (String) comboBoxDepartment.getSelectedItem(), universities.get(comboBoxInstructorMail.getSelectedIndex())));
                    if (registration) {
                        tfNameReg.setText("");
                        tfSurnameReg.setText("");
                        tfMailReg.setText("");
                        tfPhoneReg.setText("");
                        tfAddressReg.setText("");
                        pfPasswordReg.setText("");
                        pfCPassword.setText("");
                        tfPrefix.setText("");
                        tfOffice.setText("");
                        comboBoxDepartment.setSelectedIndex(0);
                        File source = new File(pathPhoto);
                        String resourcePath = this.getClass().getResource("").getPath();
                        File destination = new File(resourcePath + id + ".png");
                        try {
                            Files.copy(source.toPath(), destination.toPath());
                        } catch (Exception ex) {
                            System.out.println("Error while copying registration photo!");
                        }

                        JOptionPane.showMessageDialog(null, "You have successfully registered.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed.");
                    }
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNameReg.setText("");
                tfSurnameReg.setText("");
                tfMailReg.setText("");
                tfPhoneReg.setText("");
                tfAddressReg.setText("");
                pfPasswordReg.setText("");
                pfCPassword.setText("");
                tfPrefix.setText("");
                tfOffice.setText("");
                comboBoxDepartment.setSelectedIndex(0);
            }
        });
        comboBoxInstructorMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxDepartment.removeAllItems();
                University curUniversity = universities.get(comboBoxInstructorMail.getSelectedIndex());
                Iterator it3 = curUniversity.getDepartments().iterator();
                while (it3.hasNext()) {
                    Department curDepartment = (Department) it3.next();
                    comboBoxDepartment.addItem(curDepartment.getDepartmentName());
                }
            }
        });
        btnSelectPhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "png");
                fileChooser.addChoosableFileFilter(filter);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pathPhoto = selectedFile.getAbsolutePath();
                }
            }
        });
    }

    public static void main(String[] args) {
        manager = new DatabaseManager();
        new loginForm();
    }
}
