<%-- 
    Document   : studentregister
    Created on : May 14, 2022, 10:29:32 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/companyregister.css"/>         
<!--        <link rel="stylesheet" href="CSS/tables.css"/>-->
    <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
         </head>
        <body>
        <div class="container"> 
            <div class="forms">
                <div class="form login">
                    <span class="title"> Registration</span>
                    <form action="StudentRegister.do" method="GET">
                        <div class="input-field">
                        <input type="text" name="studNum" placeholder="Enter your student number" required/>
                        <i class="fa-solid fa-graduation-cap"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="name" placeholder="Enter your name" required/>
                        <i class="fas fa-user" ></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="surname" placeholder="Enter your surname" required/>
                        <i class="fas fa-user" ></i>
                        </div>
                        <div class="input-field">
                        <input type="email" name="email" placeholder="Enter your email" required/>
                        <i class="fa-solid fa-envelope"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="phone" placeholder="Enter your cell number" required/>
                        <i class="fa-solid fa-phone-flip"></i>
                        </div>
                        <div class="input-field">
                        <input type="password" name="password" placeholder="Enter your password" required/>
                        <i class="fa-solid fa-lock"></i>
                        </div>
                        <div class="checkbox-text" >
                            <div class="checkbox-content" >
                                <input type="checkbox" id="logCheck"/>
                                <label for="logCheck" class="text">Remember me</label>
                                  </div>
                        
                        </div>
                        <div class="input-field button">
                        <input type="submit" value="Register now" />
                        </div>
                        
                    </form> 
                    
                </div>
                
            </div>
            
        </div>
    </body>
</html>

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Student</h1>
        <form action="StudentRegister.do" method="POST">
            <table>
                <tr>
                    <td>Student Number:</td>
                    <td><input type="text" name="studNum"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Surname:</td>
                    <td><input type="text" name="surname"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="Register"/></td>
                </tr>
            </table>
        </form>
    </body>-->
</html>
