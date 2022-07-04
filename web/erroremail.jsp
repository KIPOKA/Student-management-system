<%-- 
    Document   : erroremail
    Created on : May 14, 2022, 11:01:01 PM
    Author     : letso
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tables.css"/>
        <title>Error Page</title>
    </head>
    <body>
        <%
            String mg = (String)request.getAttribute("mg");
            String sucess = (String)request.getAttribute("success");            
            List<String> emails = (List<String>)request.getAttribute("email");
        %>
        <div class="popup">
           <div class="popup-content">
               <img src="O.png" alt="user">
               <%
                   for(String email: emails){
               %>
               <label class="question"><%=email%></label>
               <%}%>
               <a href="<%=mg %>" value="o" class="button" >OK</a>
           </div>
       </div>
    </body>
</html>
