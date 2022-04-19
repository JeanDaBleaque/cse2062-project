import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginForm extends JFrame{
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
    private JLabel lbWarning;
    private Color sideBarColorHover = new Color(70, 70, 70);
    private Color sideBarColorNormal = new Color(52, 52, 52);
    private Color errorEnter = new Color(205, 24, 48);
    private Color errorCorrection = new Color(170, 170, 170);
    private CardLayout c1 = (CardLayout)enterCardPane.getLayout();

    public loginForm() {

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
                String s="";
                if(!s.equals(tfLogUser.getText()) && !s.equals(pfLogPassword.getText())){
                    tfLogUser.setText("");
                    pfLogPassword.setText("");
                    lbLogUser.setForeground(errorCorrection);
                    lbLogPassword.setForeground(errorCorrection);
                    loginForm.this.dispose();
                    new mainForm();
                }else if(!s.equals(tfLogUser.getText())){
                    lbLogUser.setForeground(errorEnter);
                }else if(!s.equals(pfLogPassword.getText())){
                    lbLogPassword.setForeground(errorEnter);
                }else{
                    lbLogPassword.setForeground(errorEnter);
                    lbLogUser.setForeground(errorEnter);
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
    }

    /*public static void main(String[] args) {

        new loginForm();
    }*/
}
