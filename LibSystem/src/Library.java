
import java.sql.Connection;
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
public class Library{
    

    private String libName;
    private String libAddress;
    private int id;
    private int totalNum;
    
    public Library (int id, String libName, String libAddres){
        this.id = id;
        this.libName = libName;
        this.libAddress = libAddress;
        
        
    }

    
    public Library(int id) {
        this.id =id;
        
    }

 
    public int getlibID(){
        return totalNum;
        
    }
    public String getlibName(){
        return libName;
    }
    public String getAddress(){
        return libAddress;
    }  
    
     
 /*
    
    //METHODS
    public void addBook(Books book){
		database.add(book);
	}
    
    
    public Books viewUnborrowed(Books book){
        return book;
    }
    
    public Books borrowedBooks(Books book){
        return book;
    }
    
    public Books showAllBooks(Books book){
        return book;
        
    }
    
    public void borrowBook(){
        
    }
    
    public void deleteBook(){
        
    }
    
    public void updateBook(){
        
    }
    public int countBook(){
        return totalNum;
    }
    
    */
    
    
    public void addLibrary(int id, String libName, String libAddress){
          try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
   
      String query = "INSERT INTO libName (idLibName, libName, libAddress)"
        + " values (?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, id);
      preparedStmt.setString (2, libName);
      preparedStmt.setString (3, libAddress);
      

      // execute the preparedstatement
      preparedStmt.execute();
      
      
      
      
      conn.close();
      JOptionPane.showMessageDialog(null,"New library location has been added.");
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
      JOptionPane.showMessageDialog(null,e.getMessage());
    }
          
    
    }
    public void showLibrary(){
        
    }
    
    public void deleteLibrary(int id){
          try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
   
      String query = "DELETE FROM libname WHERE idlibName = " + id;

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      // execute the preparedstatement
      preparedStmt.execute();
      
      
      
      
      conn.close();
      JOptionPane.showMessageDialog(null,"Library location has been deleted.");
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
      JOptionPane.showMessageDialog(null,e.getMessage());
    }
          
    
    }
    public void updateLibrary(int idlibName, String libName, String libAddress) {
        try
            {
              // create a mysql database connection
              String myDriver = "com.mysql.cj.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/librarysystem";
              Class.forName(myDriver);
            try (Connection conn = DriverManager.getConnection(myUrl, "root", "1234")) {
                String query = "UPDATE libname SET libName= '" + libName +"', libAddress = '" + libAddress + "' " +
                       "WHERE idlibName = " + idlibName;
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                System.out.println(query);
                
                // execute the preparedstatement
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null,"Library location has been updated.");
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
