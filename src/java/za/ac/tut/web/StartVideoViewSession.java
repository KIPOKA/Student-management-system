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
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class StartVideoViewSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        initialise(session);
        
        response.sendRedirect("ViewVideoServlet.do");
    }

    private void initialise(HttpSession session) {
        String video = "", comment = "", surname = "";
        Integer phone = 0, studNum = 0;
        List<Student> students  = new ArrayList<>();
        
        session.setAttribute("comment", comment);
        session.setAttribute("students", students);
    }
}
