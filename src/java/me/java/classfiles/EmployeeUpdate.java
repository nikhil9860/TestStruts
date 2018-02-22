/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.classfiles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import me.java.DataBase.DataBaseHandler;
import me.java.POJO.RegisterPOJO;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author nikhil
 */
public class EmployeeUpdate implements ServletRequestAware,SessionAware{

        HttpServletRequest req;
        Map<String, Object> session;
        
        ArrayList<RegisterPOJO> list = new ArrayList<>();
        
        @Override
    public void setServletRequest(HttpServletRequest hsr) {
       req=hsr;
       
       
    }
    
    public  String execute(){
        
            try {
                String sql = "select name,email,gender,state,identity,address from employee where name='"+req.getParameter("name")+"'";
               
                ResultSet rs = DataBaseHandler.getCon().createStatement().executeQuery(sql);
                
                if(rs.next()){
                 
                    RegisterPOJO pojo = new RegisterPOJO();
                        
                    pojo.setName(rs.getString("name"));
                    pojo.setEmail(rs.getString("email"));
                    pojo.setGender(rs.getString("gender"));
                    pojo.setState(rs.getString("state"));
                    pojo.setAddress(rs.getString("address"));
                    pojo.setIdentity(rs.getString("identity"));
                    
                    session.put("information", pojo);
                    
                return "true";    
                
                }
                
                
            } catch (SQLException ex) {
                  System.out.println(ex);
                Logger.getLogger(EmployeeUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return "false";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session=map;
    }

    
}
