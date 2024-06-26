package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class admin_menu {
	public static void admin_menu() {
	     
	     
	    JFrame f=new JFrame("Admin Functions"); //Give dialog box name as admin functions
	    //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
	     
	     
	    JButton create_but=new JButton("Create/Reset");//creating instance of JButton to create or reset database
	    create_but.setBounds(450,60,120,25);//x axis, y axis, width, height 
	    create_but.addActionListener(new ActionListener() { //Perform action
	        @Override
			public void actionPerformed(ActionEvent e){
	             
	            create(); //Call create function
	            JOptionPane.showMessageDialog(null,"Database Created/Reset!"); //Open a dialog box and display the message
	             
	        }
	    });
	     
	     
	    JButton view_but=new JButton("View Books");//creating instance of JButton to view books
	    view_but.setBounds(20,20,120,25);//x axis, y axis, width, height 
	    view_but.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	             
	            JFrame f = new JFrame("Books Available"); 
	            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             
	             
	            Connection connection = connect(); //connect to database
	            String sql="select * from BOOKS"; //select all books 
	            try {
	                Statement stmt = connection.createStatement();
	                 stmt.executeUpdate("USE LIBRARY"); //use database
	                stmt=connection.createStatement();
	                ResultSet rs=stmt.executeQuery(sql);
	                JTable book_list= new JTable(); //view data in table format
	                book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                //mention scroll bar
	                JScrollPane scrollPane = new JScrollPane(book_list); 
	 
	                f.add(scrollPane); //add scrollpane
	                f.setSize(800, 400); //set size for frame
	                f.setVisible(true);
	                f.setLocationRelativeTo(null);
	            } catch (SQLException e1) {
	                // TODO Auto-generated catch block
	                 JOptionPane.showMessageDialog(null, e1);
	            }               
	             
	    }
	    }
	    );
	     
	    JButton users_but=new JButton("View Users");//creating instance of JButton to view users
	    users_but.setBounds(150,20,120,25);//x axis, y axis, width, height 
	    users_but.addActionListener(new ActionListener() { //Perform action on click button
	        @Override
			public void actionPerformed(ActionEvent e){
	                 
	                JFrame f = new JFrame("Users List");
	                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                 
	                 
	                Connection connection = connect();
	                String sql="select * from users"; //retrieve all users
	                try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY"); //use database
	                    stmt=connection.createStatement();
	                    ResultSet rs=stmt.executeQuery(sql);
	                    JTable book_list= new JTable();
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                    //mention scroll bar
	                    JScrollPane scrollPane = new JScrollPane(book_list);
	 
	                    f.add(scrollPane); //add scrollpane
	                    f.setSize(800, 400); //set size for frame
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                     JOptionPane.showMessageDialog(null, e1);
	                }       
	                 
	                 
	    }
	        }
	    );  
	     
	    JButton issued_but=new JButton("View Issued Books");//creating instance of JButton to view the issued books
	    issued_but.setBounds(280,20,160,25);//x axis, y axis, width, height 
	    issued_but.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	                 
	                JFrame f = new JFrame("Users List");
	                //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                 
	                 
	                Connection connection = connect();
	                String sql="select * from issued";
	                try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY");
	                    stmt=connection.createStatement();
	                    ResultSet rs=stmt.executeQuery(sql);
	                    JTable book_list= new JTable();
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                     
	                    JScrollPane scrollPane = new JScrollPane(book_list);
	 
	                    f.add(scrollPane);
	                    f.setSize(800, 400);
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                     JOptionPane.showMessageDialog(null, e1);
	                }       
	                             
	    }
	        }
	    );
	     
	     
	    JButton add_user=new JButton("Add User"); //creating instance of JButton to add users
	    add_user.setBounds(20,60,120,25); //set dimensions for button
	     
	    add_user.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	                 
	                JFrame g = new JFrame("Enter User Details"); //Frame to enter user details
	                //g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                //Create label 
	                JLabel l1,l2;  
	                l1=new JLabel("Username");  //label 1 for username
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("Password");  //label 2 for password
	                l2.setBounds(30,50, 100,30); 
	                 
	                //set text field for username 
	                JTextField F_user = new JTextField();
	                F_user.setBounds(110, 15, 200, 30);
	                 
	                //set text field for password
	                JPasswordField F_pass=new JPasswordField();
	                F_pass.setBounds(110, 50, 200, 30);
	                //set radio button for admin
	                JRadioButton a1 = new JRadioButton("Admin");
	                a1.setBounds(55, 80, 200,30);
	                //set radio button for user
	                JRadioButton a2 = new JRadioButton("User");
	                a2.setBounds(130, 80, 200,30);
	                //add radio buttons
	                ButtonGroup bg=new ButtonGroup();    
	                bg.add(a1);bg.add(a2);  
	                 
	                                 
	                JButton create_but=new JButton("Create");//creating instance of JButton for Create 
	                create_but.setBounds(130,130,80,25);//x axis, y axis, width, height 
	                create_but.addActionListener(new ActionListener() {
	                     
	                    @Override
						public void actionPerformed(ActionEvent e){
	                     
	                    String username = F_user.getText();
	                    String password = F_pass.getText();
	                    Boolean admin = false;
	                     
	                    if(a1.isSelected()) {
	                        admin=true;
	                    }
	                     
	                    Connection connection = connect();
	                     
	                    try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY");
	                     stmt.executeUpdate("INSERT INTO USERS(USERNAME,PASSWORD,ADMIN) VALUES ('"+username+"','"+password+"',"+admin+")");
	                     JOptionPane.showMessageDialog(null,"User added!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        // TODO Auto-generated catch block
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                     
	                 
	                    g.add(create_but);
	                    g.add(a2);
	                    g.add(a1);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_user);
	                    g.add(F_pass);
	                    g.setSize(350,200);//400 width and 500 height  
	                    g.setLayout(null);//using no layout managers  
	                    g.setVisible(true);//making the frame visible 
	                    g.setLocationRelativeTo(null);
	                 
	                 
	    }
	    });
	         
	     
	    JButton add_book=new JButton("Add Book"); //creating instance of JButton for adding books
	    add_book.setBounds(150,60,120,25); 
	     
	    add_book.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	                //set frame wot enter book details
	                JFrame g = new JFrame("Enter Book Details");
	                //g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                // set labels
	                JLabel l1,l2,l3;  
	                l1=new JLabel("Book Name");  //lebel 1 for book name
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("Genre");  //label 2 for genre
	                l2.setBounds(30,53, 100,30); 
	                 
	                l3=new JLabel("Price");  //label 2 for price
	                l3.setBounds(30,90, 100,30); 
	                 
	                //set text field for book name
	                JTextField F_bname = new JTextField();
	                F_bname.setBounds(110, 15, 200, 30);
	                 
	                //set text field for genre 
	                JTextField F_genre=new JTextField();
	                F_genre.setBounds(110, 53, 200, 30);
	                //set text field for price
	                JTextField F_price=new JTextField();
	                F_price.setBounds(110, 90, 200, 30);
	                         
	                 
	                JButton create_but=new JButton("Submit");//creating instance of JButton to submit details  
	                create_but.setBounds(130,130,80,25);//x axis, y axis, width, height 
	                create_but.addActionListener(new ActionListener() {
	                     
	                    @Override
						public void actionPerformed(ActionEvent e){
	                    // assign the book name, genre, price
	                    String bname = F_bname.getText();
	                    String genre = F_genre.getText();
	                    String price = F_price.getText();
	                    //convert price of integer to int
	                    int price_int = Integer.parseInt(price);
	                     
	                    Connection connection = connect();
	                     
	                    try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY");
	                     stmt.executeUpdate("INSERT INTO BOOKS(BNAME,GENRE,PRICE) VALUES ('"+bname+"','"+genre+"',"+price_int+")");
	                     JOptionPane.showMessageDialog(null,"Book added!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        // TODO Auto-generated catch block
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                                 
	                    g.add(l3);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_bname);
	                    g.add(F_genre);
	                    g.add(F_price);
	                    g.setSize(350,200);//400 width and 500 height  
	                    g.setLayout(null);//using no layout managers  
	                    g.setVisible(true);//making the frame visible 
	                    g.setLocationRelativeTo(null);
	                             
	    }
	    });
	     
	     
	    JButton issue_book=new JButton("Issue Book"); //creating instance of JButton to issue books
	    issue_book.setBounds(450,20,120,25); 
	     
	    issue_book.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	                //enter details
	                JFrame g = new JFrame("Enter Details");
	                //g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                //create labels
	                JLabel l1,l2,l3,l4;  
	                l1=new JLabel("Book ID(BID)");  // Label 1 for Book ID
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("User ID(UID)");  //Label 2 for user ID
	                l2.setBounds(30,53, 100,30); 
	                 
	                l3=new JLabel("Period(days)");  //Label 3 for period
	                l3.setBounds(30,90, 100,30); 
	                 
	                l4=new JLabel("Issued Date(DD-MM-YYYY)");  //Label 4 for issue date
	                l4.setBounds(30,127, 150,30); 
	                 
	                JTextField F_bid = new JTextField();
	                F_bid.setBounds(110, 15, 200, 30);
	                 
	                 
	                JTextField F_uid=new JTextField();
	                F_uid.setBounds(110, 53, 200, 30);
	                 
	                JTextField F_period=new JTextField();
	                F_period.setBounds(110, 90, 200, 30);
	                 
	                JTextField F_issue=new JTextField();
	                F_issue.setBounds(180, 130, 130, 30);   
	 
	                 
	                JButton create_but=new JButton("Submit");//creating instance of JButton  
	                create_but.setBounds(130,170,80,25);//x axis, y axis, width, height 
	                create_but.addActionListener(new ActionListener() {
	                     
	                    @Override
						public void actionPerformed(ActionEvent e){
	                     
	                    String uid = F_uid.getText();
	                    String bid = F_bid.getText();
	                    String period = F_period.getText();
	                    String issued_date = F_issue.getText();
	 
	                    int period_int = Integer.parseInt(period);
	                     
	                    Connection connection = connect();
	                     
	                    try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY");
	                     stmt.executeUpdate("INSERT INTO ISSUED(UID,BID,ISSUED_DATE,PERIOD) VALUES ('"+uid+"','"+bid+"','"+issued_date+"',"+period_int+")");
	                     JOptionPane.showMessageDialog(null,"Book Issued!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        // TODO Auto-generated catch block
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                     
	                 
	                    g.add(l3);
	                    g.add(l4);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_uid);
	                    g.add(F_bid);
	                    g.add(F_period);
	                    g.add(F_issue);
	                    g.setSize(350,250);//400 width and 500 height  
	                    g.setLayout(null);//using no layout managers  
	                    g.setVisible(true);//making the frame visible 
	                    g.setLocationRelativeTo(null);
	                 
	                 
	    }
	    });
	     
	     
	    JButton return_book=new JButton("Return Book"); //creating instance of JButton to return books
	    return_book.setBounds(280,60,160,25); 
	     
	    return_book.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e){
	                 
	                JFrame g = new JFrame("Enter Details");
	                //g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                //set labels 
	                JLabel l1,l2,l3,l4;  
	                l1=new JLabel("Issue ID(IID)");  //Label 1 for Issue ID
	                l1.setBounds(30,15, 100,30); 
	                
	                 
	                l4=new JLabel("Return Date(DD-MM-YYYY)");  
	                l4.setBounds(30,50, 150,30); 
	                 
	                JTextField F_iid = new JTextField();
	                F_iid.setBounds(110, 15, 200, 30);
	                 
	                 
	                JTextField F_return=new JTextField();
	                F_return.setBounds(180, 50, 130, 30);
	             
	 
	                JButton create_but=new JButton("Return");//creating instance of JButton to mention return date and calculcate fine
	                create_but.setBounds(130,170,80,25);//x axis, y axis, width, height 
	                create_but.addActionListener(new ActionListener() {
	                     
	                    @Override
						public void actionPerformed(ActionEvent e){                 
	                     
	                    String iid = F_iid.getText();
	                    String return_date = F_return.getText();
	                     
	                    Connection connection = connect();
	                     
	                    try {
	                    Statement stmt = connection.createStatement();
	                     stmt.executeUpdate("USE LIBRARY");
	                     //Intialize date1 with NULL value
	                     String date1=null;
	                     String date2=return_date; //Intialize date2 with return date
	                     
	                     //select issue date
	                     ResultSet rs = stmt.executeQuery("SELECT ISSUED_DATE FROM ISSUED WHERE IID="+iid);
	                     while (rs.next()) {
	                         date1 = rs.getString(1);
	                          
	                       }
	                      
	                     try {
	                            Date date_1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
	                            Date date_2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
	                            //subtract the dates and store in diff
	                            long diff = date_2.getTime() - date_1.getTime();
	                            //Convert diff from milliseconds to days
	                            ex.days=(int)(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	                             
	                             
	                        } catch (ParseException e1) {
	                            // TODO Auto-generated catch block
	                            e1.printStackTrace();
	                        }
	                      
	                     
	                     //update return date
	                     stmt.executeUpdate("UPDATE ISSUED SET RETURN_DATE='"+return_date+"' WHERE IID="+iid);
	                     g.dispose();
	                      
	 
	                     Connection connection1 = connect();
	                     Statement stmt1 = connection1.createStatement();
	                     stmt1.executeUpdate("USE LIBRARY");                
	                    ResultSet rs1 = stmt1.executeQuery("SELECT PERIOD FROM ISSUED WHERE IID="+iid); //set period
	                    String diff=null; 
	                    while (rs1.next()) {
	                         diff = rs1.getString(1);
	                          
	                       }
	                    int diff_int = Integer.parseInt(diff);
	                    if(ex.days&amp;amp;amp;amp;amp;amp;amp;amp;amp;amp;gt;diff_int) { //If number of days are more than the period then calculcate fine
	                         
	                        //System.out.println(ex.days);
	                        int fine = (ex.days-diff_int)*10; //fine for every day after the period is Rs 10.
	                        //update fine in the system
	                        stmt1.executeUpdate("UPDATE ISSUED SET FINE="+fine+" WHERE IID="+iid);  
	                        String fine_str = ("Fine: Rs. "+fine);
	                        JOptionPane.showMessageDialog(null,fine_str);
	                         
	                    }
	 
	                     JOptionPane.showMessageDialog(null,"Book Returned!");
	                      
	                    }
	                             
	                     
	                    catch (SQLException e1) {
	                        // TODO Auto-generated catch block
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                }); 
	                    g.add(l4);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(F_iid);
	                    g.add(F_return);
	                    g.setSize(350,250);//400 width and 500 height  
	                    g.setLayout(null);//using no layout managers  
	                    g.setVisible(true);//making the frame visible 
	                    g.setLocationRelativeTo(null);              
	    }
	    });
	     
	    f.add(create_but);
	    f.add(return_book);
	    f.add(issue_book);
	    f.add(add_book);
	    f.add(issued_but);
	    f.add(users_but);
	    f.add(view_but);
	    f.add(add_user);
	    f.setSize(600,200);//400 width and 500 height  
	    f.setLayout(null);//using no layout managers  
	    f.setVisible(true);//making the frame visible 
	    f.setLocationRelativeTo(null);
	     
	    }
}
