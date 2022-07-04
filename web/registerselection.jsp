<%-- 
    Document   : registerselection
    Created on : May 19, 2022, 10:51:52 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/login.css"/>
        <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
        <title>Register Selection Page</title>
    </head>
    <body>
        <div class="container"> 
            <div class="forms">
                <div class="form login">
                    <span class="title">Register As</span>
                    <form action="studentregister.jsp">
                        <div class="input-field button">
                        <input type="submit" value="Student" />
                        </div>
                    </form>
                    <form action="companyregister.jsp">
                        <div class="input-field button">
                        <input type="submit" value="Company" />
                        </div>                       
                    </form>                                        
                </div>                
            </div>            
        </div>
    </body>
</html>
