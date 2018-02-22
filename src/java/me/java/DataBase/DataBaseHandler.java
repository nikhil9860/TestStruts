/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikhil
 */
public class DataBaseHandler {
    
   private static Connection con;
   
   
   public static Connection getCon(){
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           
           
            con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            return  con;
            
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return null;
   } 
    
    public static boolean doInsert(PreparedStatement ps){
        
       try {
           
            ps.executeUpdate();
           
               return true; 
          
           
       } catch (SQLException ex) {
           Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return false;
    }
    
    public  static boolean doDelete(String sql){
       try{
           
           Statement smt = getCon().createStatement();
           smt.executeUpdate(sql);
           return true;
       }catch(Exception e){
           e.printStackTrace();
       }
        
        return false;
    }
    
    public  static  boolean doUpdate(PreparedStatement ps){
       
        
       try {
           
           ps.executeUpdate();
           
           return true;
       } catch (SQLException ex) {
           Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return false;
    }
    
    
}
