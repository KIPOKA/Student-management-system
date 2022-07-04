/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class StartAdminSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String password = (String)request.getParameter("password");
        
        initialise(session, email, password);
        
        response.sendRedirect("adminlogin.jsp");
    }

    private void initialise(HttpSession session, String email, String password) {
        String video = "", name = "", surname = "";
        Long videoid;
        Integer phone = 0, staffNum = 0;
        
        List<Company> companies = new ArrayList<>();
        List<Student> allStudents = new ArrayList<>();
        
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("surname", surname);
        session.setAttribute("staffNum", staffNum);
        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        session.setAttribute("companies", companies);
        session.setAttribute("allStudents", allStudents);
    }

}
