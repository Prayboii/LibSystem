
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prayboi
 */
public class Books {
    
    private String bookName;
    private int isbn;
    private String bookAuthor;
    private String bookLocation;
    private String bookBorrower;
    private double price;
    private java.util.Date returnDate;
    private java.util.Date borrowDate;
    private String isBorrowed;
    
    
    public Books (String bookName, int isbn, String bookAuthor, String bookLocation, double price){
        
        this.bookName = bookName;
        this.isbn = isbn;
        this.bookAuthor = bookAuthor;
        this.bookLocation = bookLocation;
        this.price = price;
    }
     
    public Books(String selected) {
        this.bookLocation = selected;
    }

    public Books(int bn, String bookBorrower, String borrowed, Date borrowDate, Date returnDate) {
        try
            {
              // create a mysql database connection
              String myDriver = "com.mysql.cj.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
              Class.forName(myDriver);
              Connection conn = DriverManager.getConnection(myUrl, "root", "1234");

              String query = "INSERT INTO borrowedBooks (isbn, borrowedDate, returnDate, borrowerBook, isBorrowed)"
                + " values (?, ?, ?, ?, ?)";

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setInt (1, bn);
              preparedStmt.setDate (2, borrowDate);
              preparedStmt.setDate (3, returnDate);
              preparedStmt.setString (4, bookBorrower);
              preparedStmt.setString (5, borrowed);


              // execute the preparedstatement
              preparedStmt.execute();




              conn.close();

            }
    catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
            }
          
    }

    Books(int selected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getbookName(){
        return bookName;
    }
    
    public int getisbn(){
        return isbn;
    }
    public String getbookAuthor(){
        return bookAuthor;
    }
    public String getbookLocation(){
        return bookLocation;
    }
    public double getprice(){
        return price;
    }
    
    
    public void addBook(String bookName, int isbn, String bookAuthor, String bookLocation, double price){
		   try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
   
      String query = "INSERT INTO libbooks (isbn, libBookName, libBookAuthor, libBookPrice, libBookLocation)"
        + " values (?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, isbn);
      preparedStmt.setString (2, bookName);
      preparedStmt.setString (3, bookAuthor);
      preparedStmt.setDouble (4, price);
      preparedStmt.setString (5, bookLocation);
      

      // execute the preparedstatement
      preparedStmt.execute();
      
      
      
      
      conn.close();
      JOptionPane.showMessageDialog(null,"Book has been added.");
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
      JOptionPane.showMessageDialog(null,e.getMessage());
    }
          
	}
    
    
    
    
    
     public void borrowBook(int isbn, String bookBorrower, String isBorrowed, java.sql.Date borrowDate, java.sql.Date returnDate){
        try
            {
              // create a mysql database connection
              String myDriver = "com.mysql.cj.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
              Class.forName(myDriver);
              Connection conn = DriverManager.getConnection(myUrl, "root", "1234");

              String query = "INSERT INTO borrowedBooks (isbn, borrowedDate, returnDate, borrowerBook, isBorrowed)"
                + " values (?, ?, ?, ?, ?)";

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setInt (1, isbn);
              preparedStmt.setDate (2, borrowDate);
              preparedStmt.setDate (3, returnDate);
              preparedStmt.setString (4, bookBorrower);
              preparedStmt.setString (5, isBorrowed);


              // execute the preparedstatement
              preparedStmt.execute();




              conn.close();
              JOptionPane.showMessageDialog(null,"Book has been borrowed.");

            }
    catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
               JOptionPane.showMessageDialog(null,e.getMessage());
            }
          
     }

   public void returnBook(int selected){
    try
            {
              // create a mysql database connection
              String myDriver = "com.mysql.cj.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
              Class.forName(myDriver);
              Connection conn = DriverManager.getConnection(myUrl, "root", "1234");

              String query = "DELETE FROM borrowedBooks WHERE isbn = " + selected;

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
                            // execute the preparedstatement
              preparedStmt.execute();




              conn.close();
              JOptionPane.showMessageDialog(null,"Book has been returned.");
              

            }
    catch (Exception e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
          
     }

    public void updateBook(String bookName, int isbn, String bookAuthor, String bookLocation, double price) {
        try
            {
              // create a mysql database connection
              String myDriver = "com.mysql.cj.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
              Class.forName(myDriver);
            try (Connection conn = DriverManager.getConnection(myUrl, "root", "1234")) {
                String query = "UPDATE libbooks SET libBookName= '" + bookName +"', libBookAuthor = '" + bookAuthor + "', " +
                        "libBookPrice = " +  price + ", libBookLocation = '" + bookLocation + "' WHERE isbn = " + isbn;
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                
                // execute the preparedstatement
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null,"Book has been updated.");
            }

            }
    catch (ClassNotFoundException | SQLException e)
            {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
              JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }
}
