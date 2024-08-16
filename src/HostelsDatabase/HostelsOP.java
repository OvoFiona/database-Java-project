
package HostelsDatabase;

import java.sql.*;

public class HostelsOP extends HostelsCon {
    
    
    @Override
    public void insert(String Surname,int roomNo,int ownerId,int Rent) {
     
       try{
        // Step 3: Create a statement
        String query = "INSERT INTO Owner(ownerId,Surname,roomNo,Rent) Values(?,?,?,?);";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, ownerId);
        pst.setString(2, Surname);
        pst.setInt(3, roomNo);
        pst.setInt(4, Rent);
                          
       //Step 4: Execute statement
           ResultSet rs = pst.executeQuery();
          
       //Step 5: Process statement
        while(rs.rowInserted()){
              String hownerId = rs.getString(1);
              String hSurname = rs.getString(2);
              String hRent = rs.getString(3);
              String hroomNo = rs.getString(4);
              
              System.out.println(hownerId + " "+hSurname+" " +hRent+""+hroomNo);
          }
       //Step 6: Close statement
        }catch(SQLException sqle){
            System.out.println("Could not insert:" + sqle.getMessage());
        }
       
    }
    
    
    
    @Override
    public void select(int Id) {
       try{
        // Step 3: Create a statement
        String query = "SELECT * FROM Owner WHERE ownerId = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,Id);
      
        
       //Step 4: Execute statement
          ResultSet rs = pst.executeQuery();
          
       //Step 5: Process statement
          while(rs.next()){
              String hownerId = rs.getString(1);
              String hSurname = rs.getString(2);
              String hRent = rs.getString(3);
              String hroomNo = rs.getString(4);
              
              System.out.println(hownerId + " "+hSurname+" " +hRent+ " "+hroomNo);
          }
       //Step 6: Close statement
        }catch(SQLException sqle){
            System.out.println("Could not select:" + sqle.getMessage());
        }
       
    }

    
    @Override
    public void update(String Surname,int ownerId) {
      try{
        // Step 3: Create a statement
        String query = "UPDATE Owner SET Surname ='Peter' WHERE ownerId = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, "Peter");
        pst.setInt(1, 402);
        
       //Step 4: Execute statement
          ResultSet rs = pst.executeQuery();
          
       //Step 5: Process statement
          while(rs.next()){
              String hownerId = rs.getString(402);
              String hSurname = rs.getString("Peter");
              
              rs.updateRow();
              System.out.println(hownerId + " "+hSurname+"");
          }
       //Step 6: Close statement
        }catch(SQLException sqle){
            System.out.println("Could not update:" + sqle.getMessage());
        }
    }

    
    @Override
    public void delete(String Surname) {
        try{
     // Step 3: Create a statement
        String query = "DELETE FROM Owner WHERE Surname='Kamau';";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,Surname);
             
       //Step 4: Execute statement
          ResultSet rs = pst.executeQuery();
          
       //Step 5: Process statement
          while(rs.next()){
              String hownerId = rs.getString(1);
              String hSurname = rs.getString(2);
              String hRent = rs.getString(3);
              String hroomNo = rs.getString(1);
              
              System.out.println(hownerId + " "+hSurname+" " +hRent+""+hroomNo);
          }
       //Step 6: Close statement
        }catch(SQLException sqle){
            System.out.println("Could not delete:" + sqle.getMessage());
        }
    }
    }
    
    

