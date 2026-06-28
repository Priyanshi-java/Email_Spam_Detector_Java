import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    JTextField username;
    JPasswordField password;

    public LoginGUI() {

        setTitle("Email Spam Detector Login");
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel title = new JLabel("EMAIL SPAM DETECTOR");
        title.setFont(new Font("Arial",Font.BOLD,20));
        title.setBounds(90,20,300,30);
        add(title);

        JLabel user = new JLabel("Username");
        user.setBounds(50,80,100,25);
        add(user);

        username = new JTextField();
        username.setBounds(150,80,200,25);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(50,130,100,25);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150,130,200,25);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(160,190,120,35);
        add(login);

        login.addActionListener(e -> {

            String u = username.getText();
            String p = new String(password.getPassword());

            if(u.equals("admin") && p.equals("1234")){

                dispose();

                new SpamDetectorGUI();

            }

            else{

                JOptionPane.showMessageDialog(null,
                        "Invalid Username or Password");

            }

        });

        setVisible(true);

    }

}