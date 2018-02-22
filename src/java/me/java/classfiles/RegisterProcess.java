/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.classfiles;

import com.opensymphony.xwork2.ModelDriven;
import me.java.Dao.RegisterDAO;
import me.java.POJO.RegisterPOJO;

/**
 *
 * @author nikhil
 */
public class RegisterProcess implements ModelDriven<RegisterPOJO>{

    RegisterPOJO pojo = new RegisterPOJO();

    @Override
    public RegisterPOJO getModel() {
        return  pojo;
    }
    
    
    public String execute(){
        
            RegisterDAO.getRegisterData(pojo);
            
        return "true";
    }
    
   
}
