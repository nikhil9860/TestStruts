/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.java.classfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import me.java.DataBase.DataBaseHandler;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author nikhil
 */
public class EmployeeDelete implements ServletRequestAware {

        HttpServletRequest req;
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        
        req=hsr;
        
        System.out.println(req.getParameter("name"));
        
        
    }

    public String execute(){
        
        String sql = "delete from employee where name='"+req.getParameter("name")+"'";
        
          
        
            if(DataBaseHandler.doDelete(sql)){
                return "true";
            }
        
         return  "false";
     }   
    
    
}