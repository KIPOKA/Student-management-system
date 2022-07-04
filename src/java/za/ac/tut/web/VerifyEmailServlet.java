/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.mail.SendMail;
import za.ac.tut.mail.UserEmail;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class VerifyEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String registerEmail = (String)request.getAttribute("email");
        String reg = (String)request.getAttribute("reg");
        String text = (String)request.getAttribute("text");
        String email = "";
        
        
            email = registerEmail;
        
        
        SendMail sm = new SendMail();
        
        UserEmail user = new UserEmail(email, text);
             
        boolean test =sm.sendEmail(user);
        if (test) {
             
            RequestDispatcher dis = request.getRequestDispatcher(reg);
            dis.forward(request, response);
        }    
    }

}
