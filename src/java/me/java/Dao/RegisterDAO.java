/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.java.DataBase.DataBaseHandler;
import me.java.POJO.RegisterPOJO;

/**
 *
 * @author nikhil
 */
public class RegisterDAO {
    
    
    public static  void getRegisterData(RegisterPOJO pojo){
        
        String sql = "insert into employee values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = DataBaseHandler.getCon().prepareStatement(sql);
            ps.setString(1, pojo.getName());
            ps.setString(2, pojo.getEmail());
            ps.setString(3, pojo.getGender());
            ps.setString(4, pojo.getState());
            ps.setString(5, pojo.getIdentity());
            ps.setString(6, pojo.getAddress());
            
            DataBaseHandler.doInsert(ps);
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        System.out.println(pojo.getName()+" "+pojo.getAddress()+" "+pojo.getEmail()+" "+pojo.getGender()
//        +" "+pojo.getState()+" "+pojo.getIdentity()
//        );
        
        
    }
}
