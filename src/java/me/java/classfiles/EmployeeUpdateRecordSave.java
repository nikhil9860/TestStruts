/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.classfiles;

import com.opensymphony.xwork2.ModelDriven;
import java.sql.PreparedStatement;
import me.java.DataBase.DataBaseHandler;
import me.java.POJO.RegisterPOJO;

/**
 *
 * @author nikhil
 */
public class EmployeeUpdateRecordSave implements ModelDriven<RegisterPOJO>{

    RegisterPOJO pojo = new RegisterPOJO();
    
    @Override
    public RegisterPOJO getModel() {
        return  pojo;
    }
    
    public String execute(){
        
        //String sql = "update employee set email='"+pojo.getEmail()+"'gender='"+pojo.getGender()+"'state='"+pojo.getState()+"'identity='"+pojo.getIdentity()+"'address='"+pojo.getAddress()+"' where name="+pojo.getName()+"'";
       //String sql ="update employee set email ='"+pojo.getEmail()+"'     where name ='"+pojo.getName()+"'";
       String sql = "update employee  set email =?,gender=?,state=?,identity=?,address=? where name =? ";
       try{
       PreparedStatement ps = DataBaseHandler.getCon().prepareStatement(sql);
       ps.setString(1, pojo.getEmail());
       ps.setString(2, pojo.getGender());
       ps.setString(3, pojo.getState());
       ps.setString(4, pojo.getIdentity());
       ps.setString(5, pojo.getAddress());
       ps.setString(6, pojo.getName());
       
       if(DataBaseHandler.doUpdate(ps)){
        
            return "true";
        }
        
       
       }catch(Exception e){
           e.printStackTrace();
       }
        
  
       //System.out.println(sql);
       
        return "false";
    } 
    
}
