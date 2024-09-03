import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu {
    private JFrame frame;

    public void showAdminMenu() {
        frame = new JFrame("Admin Functions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setLayout(null);

        JButton resetButton = new JButton("Create/Reset");
        resetButton.setBounds(10, 10, 120, 25);
        frame.add(resetButton);

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(150, 10, 120, 25);
        frame.add(viewBooksButton);

        JButton viewUsersButton = new JButton("View Users");
        viewUsersButton.setBounds(10, 50, 120, 25);
        frame.add(viewUsersButton);

        JButton viewIssuedBooksButton = new JButton("View Issued Books");
        viewIssuedBooksButton.setBounds(150, 50, 120, 25);
        frame.add(viewIssuedBooksButton);

        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(10, 90, 120, 25);
        frame.add(addUserButton);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.setBounds(150, 90, 120, 25);
        frame.add(addBookButton);

        JButton issueBookButton = new JButton("Issue Book");
        issueBookButton.setBounds(10, 130, 120, 25);
        frame.add(issueBookButton);

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(150, 130, 120, 25);
        frame.add(returnBookButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Create create = new Create();
                create.create();
                JOptionPane.showMessageDialog(frame, "Database created/reset successfully.");
            }
        });

        // Add similar action listeners for other buttons

        frame.setVisible(true);
    }
}
