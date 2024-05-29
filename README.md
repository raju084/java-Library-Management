# java-Library-Management
MAIN CLASS
This Java code appears to be a simple application with graphical user interface (GUI) components, likely developed using Swing framework for building desktop applications. Here's a summary:
Imports: The code imports various Java libraries for GUI components, database connectivity, and date manipulation.
Class Declaration: There's a main class defined, which contains the main method, indicating the starting point of the application.
Inner Class Definition (ex): Inside the main class, there's an inner class named ex. It contains a static variable days, initialized to 0. However, this inner class doesn't seem to be utilized elsewhere in the provided code snippet.
main Method: The main method initializes the application by calling the login method. It's commented out after the call, suggesting that perhaps during development, the create method was being tested.
login Method (Assumed): Not provided in the code snippet, but presumably, it's a method that handles the login functionality of the application.

LOGIN CLASS
This login() method defines a graphical user interface (GUI) for a login screen in a Java Swing application. Here's a summary:
It creates a JFrame titled "Login" to serve as the window for the login interface.
Labels (JLabel) for "Username" and "Password" are created and positioned within the frame.
Text fields (JTextField for username and JPasswordField for password) are created and positioned to allow users to input their credentials.
A login button (JButton) is created with an action listener to handle user authentication.
Inside the action listener, it retrieves the username and password entered by the user and checks if they are empty. If either is empty, it displays a message prompting the user to enter both username and password.
If both fields are filled, it attempts to connect to a database using a connect() method (not provided in the snippet) and executes a SQL query to validate the user's credentials.
If the user is authenticated successfully, it disposes of the login frame and redirects the user to either an admin menu or a user menu based on the user's role (admin or regular user).
The GUI components are added to the frame, and the frame's size and layout are set before making it visible to the user.

CONNECT
This connect() method establishes a connection to a MySQL database. Here's a summary:
It attempts to load the MySQL JDBC driver using Class.forName("com.mysql.cj.jdbc.Driver").
It establishes a connection to the MySQL database using DriverManager.getConnection(). The connection URL specifies the database server (localhost), the database name (mysql), and the credentials (username as root and password as edureka).
If the connection is successful, it returns the Connection object.
If an exception occurs during the connection process, it prints the stack trace of the exception and returns null.

CREATE
This create() method is responsible for setting up the database schema and initial data for the application. Here's a summary:
It establishes a connection to the database by calling the connect() method.
It retrieves the list of catalogs (databases) using connection.getMetaData().getCatalogs() and iterates over them.
If a database named "library" already exists, it drops it to reset the database completely.
It creates a new database named "LIBRARY" using CREATE DATABASE SQL statement and selects this database using USE LIBRARY.
It creates a table named "USERS" with columns for user ID (UID), username, password, and admin status.
It inserts an initial admin user into the "USERS" table.
It creates a table named "BOOKS" with columns for book ID (BID), book name, genre, and price.
It creates a table named "ISSUED" for tracking issued books, with columns for issue ID (IID), user ID (UID), book ID (BID), issue date, return date, loan period, and fine.
It inserts initial book records into the "BOOKS" table.
Finally, it closes the result set and handles any exceptions by printing the stack trace.

USER MENU
This user_menu() method creates a graphical user interface (GUI) for user functions in a Java Swing application. Here's a summary:
It creates a JFrame titled "User Functions" to serve as the window for the user menu.
It defines two buttons: "View Books" and "My Books" for accessing available books and books issued by the user, respectively.
Each button has an action listener that performs specific actions when clicked.
When the "View Books" button is clicked, it retrieves data about available books from the database and displays them in a new frame.
When the "My Books" button is clicked, it retrieves data about books issued by the current user from the database and displays them in a new frame.
Both buttons utilize DbUtils.resultSetToTableModel(rs) to display the retrieved data in a table format.
The frames for displaying book information have scroll bars enabled to handle large datasets.
The method adds the buttons to the frame, sets the frame size and layout, and makes it visible to the user.

ADMIN MENU
The admin_menu() method creates a graphical user interface (GUI) for admin functions in a Java Swing application. Here's a summary:
It creates a JFrame titled "Admin Functions" to serve as the window for the admin menu.
It defines several buttons for various admin tasks, such as creating/resetting the database, viewing books, viewing users, viewing issued books, adding users, adding books, issuing books, and returning books.
Each button has an action listener that performs specific actions when clicked.
The "Create/Reset" button calls the create() method to initialize or reset the database schema and displays a message dialog upon completion.
The "View Books" button retrieves and displays available books in a new frame.
The "View Users" button retrieves and displays user information in a new frame.
The "View Issued Books" button retrieves and displays issued book information in a new frame.
The "Add User" button allows the admin to add a new user by providing username, password, and admin status.
The "Add Book" button allows the admin to add a new book by providing book name, genre, and price.
The "Issue Book" button allows the admin to issue a book to a user by providing book ID, user ID, issue date, and period.
The "Return Book" button allows the admin to mark a book as returned by providing issue ID and return date. It calculates and displays fines, if applicable.
Each button action handles database interactions using SQL queries, such as insertion, retrieval, and update operations.
The method adds all the buttons to the frame, sets the frame size and layout, and makes it visible to the admin user.
