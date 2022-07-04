/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.Company;

/**
 *
 * @author letso
 */
public class StartCompanySession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String password = (String)request.getParameter("password");
        
        initialise(session, email, password);
        
        response.sendRedirect("companylogin.jsp");
    }

    private void initialise(HttpSession session, String email, String password) {
        String streetName = "", name = "", buildName = "", jobDiscription = "", approval = "", town = "";
        Integer phone = 0, code = 0;
        
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        session.setAttribute("jobDiscription", jobDiscription);
        session.setAttribute("approval", approval);
        session.setAttribute("code", code);
        session.setAttribute("streetName", streetName);
        session.setAttribute("town", town);
        session.setAttribute("buildName", buildName);
    }

}
