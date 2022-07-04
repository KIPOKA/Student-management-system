<%-- 
    Document   : adminregister
    Created on : May 19, 2022, 10:34:04 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Administrator Registration Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/adminregister.css"/>
    <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
         </head>
        <body>
        <div class="container"> 
            <div class="form">
                <div class="form login">
                    <span class="title"> Registration</span>
                    <form action="AdminRegister.do" method="POST">
                        <div class="input-field">
                        <input type="text" name="staffNum" placeholder="Enter your staff number" required/>
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