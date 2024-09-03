import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public void showLoginScreen() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 10, 160, 25);
        frame.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(10, 40, 80, 25);
        frame.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 40, 160, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter both username and password.");
                } else {
                    if (authenticate(username, password)) {
                        frame.dispose();
                        // Redirect to admin or user menu
                        if (isAdmin(username)) {
                            AdminMenu adminMenu = new AdminMenu();
                            adminMenu.showAdminMenu();
                        } else {
                            UserMenu userMenu = new UserMenu();
                            userMenu.showUserMenu();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid credentials.");
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        try {
            Connection conn = Connect.connect();
            if (conn != null) {
                String query = "SELECT * FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAdmin(String username) {
        try {
            Connection conn = Connect.connect();
            if (conn != null) {
                String query = "SELECT ISADMIN FROM USERS WHERE USERNAME = '" + username + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    return rs.getBoolean("ISADMIN");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
