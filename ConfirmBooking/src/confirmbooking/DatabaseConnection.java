/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmbooking;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {  
    private static Statement stmt = null;
    private static Connection con = null;
    private static String host = "jdbc:derby://localhost:1527/Bookings";
    private static String uName = "root";
    private static String uPass = "root";
    
    public static void main(String[] args) {
        createConnection();
        //selectFName();
        
    }  
    
    public static void createConnection(){
        try {
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    
   
    
    
    public String selectFName(String CustomerID){
        try
        {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT FIRSTNAME FROM MEMBER WHERE ID = "+ CustomerID);
        rs.next();
        String name = rs.getString("FIRSTNAME");
        
        
        stmt.close();
        return name;
        
        }
        
        catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
    
    public String selectSName(String CustomerID){
        try
        {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT SECONDNAME FROM MEMBER WHERE ID = "+ CustomerID);
        rs.next();
        String name = rs.getString("SECONDNAME");
        
        
        stmt.close();
        return name;
        
        }
        
        catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
    
    
    
    
}