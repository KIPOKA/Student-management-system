<%-- 
    Document   : companyprofile
    Created on : May 14, 2022, 9:26:16 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/stylemain.css"/>         
        <link rel="stylesheet" href="CSS/tables.css"/>
        <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="banner" >
            <div class="navbar">
                <nav>
                    <input type="checkbox" id="check"/>
                    <label for="check" class="checkBtn">
                        <i class="fas fa-bars"></i>
                        
                    </label>

                    <label class="logo">i-Tech</label>
                
                <ul > 
                    
                    <li><a href="companyprofile.jsp" class="active"> <i class="fa-solid fa-house"></i> Home</a></li>
                    <li><a href="JobDescriptionServlet.do"> <i class="fa-solid fa-user-doctor"></i> Job Description</a></li>
                    <li><a href="CompanyJobServlet.do"><i class="fa-solid fa-user-doctor"></i> Jobs and Opportunity</a></li>
                    <li><a href="VeiwCV.do"><i class="fa-solid fa-graduation-cap"></i> Student CV</a></li>
                    <li><a href="companyviewprofile.jsp"><i class="fa-solid fa-user"></i> View Profile</a></li> 
                    <li><a href="EndSession.do"><i class="fa-solid fa-arrow-right-from-bracket"></i>Log out</a></li>
                </ul>
                </nav>
               </div> 
             <div class="banner-2">
             <div class="left-column">
                 <h1 class="txt">Welcome to <span class="tech">i-Tech</span></h1>
                 <p>Make things <span class="better">better!</span></p>
 
             </div>

            </div>
        </div>
       
        <footer>
            <div class="footer-container">
                <div class="footer">
                    <div class="footer-heading footer-1">
                        <h4>Sponsors</h4>
                        
                            <a href="#">IBM</a>
                            <a href="#">FNB</a>
                            <a href="#">TSHWANE UNIVERSITY OF TECHNOLOGY</a>
                            <a href="#">i-Tech</a>
                    </div> 
                    <div class="footer-heading footer-2">
                        <h4>About us</h4>
                        
                            <a href="#">Contact us</a>
                            <a href="#">Donate</a>
                            <a href="#">Rate</a>
                    </div>
                    <div class="footer-heading footer-3">
                        <h4>Media</h4>
                        
                            <a href="#">Linked in</a>
                            <a href="#"> Facebook</a>
                            <a href="#">Instagram</a> 
                    </div>  
                </div>
            </div>
            </footer> 
    </body>
</html>


