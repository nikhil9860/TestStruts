<%-- 
    Document   : updatedetails
    Created on : 9 Feb, 2018, 2:54:43 PM
    Author     : nikhil
--%>

<%@page import="me.java.POJO.RegisterPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <% RegisterPOJO pojo = (RegisterPOJO)session.getAttribute("information");
        String gender=pojo.getGender().toString();
        String idenity =pojo.getIdentity().toString();
        %>
    
    
    <body>
       
        <form action="updaterecord" method="post">
            <center>
                <h1>Update Details!</h1>
                
                Employee Name:<input type="text" name="name" readonly="true" value="<%= pojo.getName()%>"><br><br>
                Email Id:<input type="email" name="email" value="<%= pojo.getEmail() %>"><br><br>
            Gender:
                

            
            <input type="radio" name="gender" id="male" value="male"
                   <% if(gender.equals("male"))%> checked <% %>  > Male 
           
            <input type="radio" name="gender" id="female" value="female" 
                   <%if(gender.equals("female"))%> checked <% %> >Female<br>
            
         
            State <select name="state" > 
                <option value="Maharashtra" >Maharashtra</option>
                <option value="Gujrat" >Gujrat</option>
                <option value="MP">Madhya Pradesh</option>
            </select>   <br><br>
            Identity Proof:
            
            <input type="checkbox" name="identity" value="Adhar card" 
                   <% if(idenity.contains("Adhar card"))%> checked <% %> > Adhar Card
            
            <input type="checkbox" name="identity" value="PAN Card"
                   <% if(idenity.contains("PAN Card"))%>checked <% %> > PAN Card
            
            <input type="checkbox" name="identity" value="Passport"
                   <% if(idenity.contains("Passport"))%> checked <% %>  >Passport<br>
            <div>
                 <br> 
                 Address<br>
                 <textarea cols="40" rows="5" name="address"><%= pojo.getAddress() %></textarea><br> 
            </div>
          
            <br><input type="submit" name="submit" value="Submit"> 
            </center>
            
        </form>
        
    </body>
</html>
