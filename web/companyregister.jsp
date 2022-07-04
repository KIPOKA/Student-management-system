<%-- 
    Document   : companyregister
    Created on : May 15, 2022, 10:23:45 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company registration page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/register.css"/>         
<!--        <link rel="stylesheet" href="CSS/tables.css"/>-->
    <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
         </head>
        <body>
        <div class="container"> 
            <div class="form">
                <div class="form login">
                    <span class="title">Company registration</span>
                    <form action="CompanyRegister.do" method="POST">
                        <div class="input-field">
                        <input type="text" name="name" placeholder="Company's name" required/>
                        <i class="fa-solid fa-users"></i>
                        </div>
                        <div class="input-field">
                        <input type="email" name="email" placeholder="Company's email" required/>
                        <i class="fa-solid fa-at"></i>
                        </div>
                     
<!--                        <div class="input-field">
                        <input type="text" name="name" placeholder="Building's name" required/>
                        <i class="fas fa-user" ></i>
                        </div>-->
                        <div class="input-field">
                        <input type="text" name="buildName" placeholder="Building name" required/>
                        <i class="fa-solid fa-building"></i>
                        </div>
                        
                        <div class="input-field">
                        <input type="text" name="streetName" placeholder="Street name" required/>
                        <i class="fa-solid fa-road"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="town" placeholder="Town's name" required/>
                        <i class="fa-solid fa-city"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="code" placeholder="Post code" required/>
                        <i class="fa-solid fa-signs-post"></i>
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
        <h1>Company Registration</h1>
        <form action="CompanyRegister.do" method="POST">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>Address Details:</td>
                </tr>
                <tr>
                    <td>Building Name:</td>
                    <td><input type="text" name="buildName"/></td>
                </tr>
                <tr>
                    <td>Street Name</td>
                    <td><input type="text" name="streetName"/></td>
                </tr>
                <tr>
                    <td>Town:</td>
                    <td><input type="text" name="town"/></td>
                </tr>
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td></td>
                    <td><input type="submit" name="Register"/></td>
                </tr>
            </table>
        </form>
    </body>-->
</html>
