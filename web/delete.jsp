<%-- 
    Document   : delete
    Created on : May 21, 2022, 10:13:22 AM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tables.css"/>
        <title>Delete Page</title>
    </head>
    <body>
        <%
            String mg = (String)request.getAttribute("mg");
            String sucess = (String)request.getAttribute("success");
        %>
        <div class="popup">
           <div class="popup-content">
               <img src="th.png" alt="user">
               <label class="question"><%=sucess%></label>
               <a href="<%=mg %>" value="o" class="button" >OK</a>
           </div>
       </div>
    </body>
</html>
