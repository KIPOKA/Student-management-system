/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class StudentRemoveStudent extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        
        Student student = studentFacade.find(email);
        
        studentFacade.remove(student);
        
        String mg = "GetAllStudents.do";
        
        request.setAttribute("pending", "Pending");
        request.setAttribute("mg", mg);
        request.setAttribute("success", "Student Removed!");
                    
        RequestDispatcher dis = request.getRequestDispatcher("delete.jsp");
        dis.forward(request, response);
    }

}
