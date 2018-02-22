<%-- 
    Document   : login
    Created on : 9 Feb, 2018, 11:34:25 AM
    Author     : nikhil
--%>

<%@page import="me.java.POJO.RegisterPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <style>
table,tr,th,td {
    border: 1px solid black;
}
a#delete{
    
    color: red;
    text-decoration: none;
}

a#update{
    color: green;
    text-decoration: none;
}

a#home{
    color: blueviolet;
    text-decoration: none;
}

</style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>    
        <h1>View Details!
            <a id="home" href="index.html">home</a></h1>
        
        <table  style=" align-content: center">
           <tr>
                    <th>name </th>
                    <th> email </th>
                    <th> gender </th>
                    <th> state </th>
                    <th> identity </th>
                    <th> address </th>
                    </tr>  
            
        <%
          ArrayList<RegisterPOJO> list = (ArrayList<RegisterPOJO>)session.getAttribute("information");
          
            for(RegisterPOJO pojo : list){
                
                String name = pojo.getName();

                %>
                
                <tr>
                    <td><%= pojo.getName()%> </td>
                    <td> <%= pojo.getEmail() %> </td>
                    <td> <%= pojo.getGender() %> </td>
                    <td> <%= pojo.getState()%> </td>
                    <td> <%= pojo.getIdentity()%> </td>
                    <td> <%= pojo.getAddress()%> </td>
                    <td><a id="delete" href="delete?name=<%=name %>" > delete </a></td>
                    <td><a id="update" href="update?name=<%=name%>">update</a> </td>
                </tr>
                            
                <%    
            }

        %>  
        </table>
         </center>
    </body>
</html>
