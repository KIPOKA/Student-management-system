/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.StudentFacadeLocal;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"student"}))
public class JobApplyServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        
        String text = "<h4> Dear student,<br> Your apllication has been received. <br>Kind regards.<br>   <b>i-TECH Group</b> </h4>";        
                        
        request.setAttribute("email", email);
        request.setAttribute("text", text);
        request.setAttribute("mg", "JobsAvailableServlet.do");
        request.setAttribute("success", "Application has been received.");
        
        RequestDispatcher dis = request.getRequestDispatcher("loginsucess.jsp");
        dis.forward(request, response);
    }

}
