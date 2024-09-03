import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserMenu {
    private JFrame frame;

    public void showUserMenu() {
        frame = new JFrame("User Functions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(10, 10, 120, 25);
        frame.add(viewBooksButton);

        JButton myBooksButton = new JButton("My Books");
        myBooksButton.setBounds(150, 10, 120, 25);
        frame.add(myBooksButton);

        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAvailableBooks();
            }
        });

        myBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMyBooks();
            }
        });

        frame.setVisible(true);
    }

    private void showAvailableBooks() {
        try {
            Connection conn = Connect.connect();
            if (conn != null) {
                String query = "SELECT * FROM BOOKS";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JFrame booksFrame = new JFrame("Available Books");
                JTable table = new JTable(DbUtils.resultSetToTableModel(rs));
                JScrollPane scrollPane = new JScrollPane(table);
                booksFrame.add(scrollPane);
                booksFrame.setSize(400, 200);
                booksFrame.setVisible(true);

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMyBooks() {
        try {
            Connection conn = Connect.connect();
            if (conn != null) {
                String query = "SELECT * FROM ISSUED WHERE UID = " + getCurrentUserId();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                JFrame myBooksFrame = new JFrame("My Books");
                JTable table = new JTable(DbUtils.resultSetToTableModel(rs));
                JScrollPane scrollPane = new JScrollPane(table);
                myBooksFrame.add(scrollPane);
                myBooksFrame.setSize(400, 200);
                myBooksFrame.setVisible(true);

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getCurrentUserId() {
        // Replace this with logic to retrieve the current user's ID
        return 1;
    }
}
