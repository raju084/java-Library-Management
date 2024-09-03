import java.sql.Connection;
import java.sql.Statement;

public class Create {
    public void create() {
        try {
            Connection conn = Connect.connect();
            if (conn != null) {
                Statement stmt = conn.createStatement();

                // Drop the library database if it exists
                stmt.executeUpdate("DROP DATABASE IF EXISTS LIBRARY");

                // Create a new library database
                stmt.executeUpdate("CREATE DATABASE LIBRARY");
                stmt.executeUpdate("USE LIBRARY");

                // Create USERS table
                stmt.executeUpdate("CREATE TABLE USERS (UID INT PRIMARY KEY AUTO_INCREMENT, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), ISADMIN BOOLEAN)");

                // Insert initial admin user
                stmt.executeUpdate("INSERT INTO USERS (USERNAME, PASSWORD, ISADMIN) VALUES ('admin', 'admin', TRUE)");

                // Create BOOKS table
                stmt.executeUpdate("CREATE TABLE BOOKS (BID INT PRIMARY KEY AUTO_INCREMENT, BOOKNAME VARCHAR(100), GENRE VARCHAR(50), PRICE DECIMAL(10, 2))");

                // Create ISSUED table
                stmt.executeUpdate("CREATE TABLE ISSUED (IID INT PRIMARY KEY AUTO_INCREMENT, UID INT, BID INT, ISSUEDATE DATE, RETURNDATE DATE, PERIOD INT, FINE DECIMAL(10, 2))");

                // Insert initial books
                stmt.executeUpdate("INSERT INTO BOOKS (BOOKNAME, GENRE, PRICE) VALUES ('Book1', 'Fiction', 19.99)");
                stmt.executeUpdate("INSERT INTO BOOKS (BOOKNAME, GENRE, PRICE) VALUES ('Book2', 'Science', 29.99)");

                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
