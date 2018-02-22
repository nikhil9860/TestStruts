/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.classfiles;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import me.java.DataBase.DataBaseHandler;
import me.java.POJO.RegisterPOJO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author nikhil
 */
public class FetchDetails implements SessionAware{
    
    private ArrayList<RegisterPOJO> list = new ArrayList<>();
    
    Map<String, Object> session;
    
    /* for fetching the employee view details
    */
    public  String execute(){
        
          try{
              
              String sql = "select * from employee";
              ResultSet rs = DataBaseHandler.getCon().createStatement().executeQuery(sql);
              while (rs.next()) {                  
               RegisterPOJO pojo = new RegisterPOJO();
               pojo.setName(rs.getString("name"));
               pojo.setEmail(rs.getString("email"));
               pojo.setGender(rs.getString("gender"));
               pojo.setState(rs.getString("state"));
               pojo.setAddress(rs.getString("address"));
               pojo.setIdentity(rs.getString("identity"));
               list.add(pojo);
               
             
              }
              
               session.put("information", list);
               
               return "true";
                  
              
          }  catch(Exception e){
              e.printStackTrace();
          }
        
        
        return "false";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        
        session=map;
        
    }

    /**
     * @return the list
     */
    public ArrayList<RegisterPOJO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<RegisterPOJO> list) {
        this.list = list;
    }
    
}
