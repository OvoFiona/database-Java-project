
package HostelsDatabase;

//import the connection interface
import java.sql.*;

public abstract class HostelsCon {
    //A variable to store a connection
   public Connection con = this.getconnection();
   
         //API:DBMS://Server:####/DBName   
   String url = "jdbc:postgresql://localhost:5432/Hostels";
   String username = "postgres";
   String Password = "postgres";
   
   
    //a function to get a connection
    public Connection getconnection(){
        Connection connection = null;
        
        //step 1: Load driver
        try{
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Driver loading failed : "+cnfe.getMessage());
        }
        
        
        //step 2:Establish connection
        try{
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hostels","postgres","postgres");
        System.out.println("successfully connect to database");
        }
        catch(SQLException sqle){
            System.out.println("Could not establish connection : "+sqle.getMessage());
        }
     return connection;   
   }
    
    // Insert operation
    public abstract void insert(String Surname,int roomNo,int ownerId,int Rent);
    
    // Select operation
    public abstract void select(int Id);
    
    // Update operation
    public abstract void update(String Surname,int ownerId);
    
    // Delete operation
    public abstract void delete(String Surname);
}


