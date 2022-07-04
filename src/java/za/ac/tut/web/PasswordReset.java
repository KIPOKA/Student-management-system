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
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class PasswordReset extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordReset = request.getParameter("passwordReset");
        
        Student student = studentFacade.find(email);
        String loc = "";
        if(student != null){
            if(password.equals(passwordReset)){
                student.setPassword(password);
                
                studentFacade.edit(student);
                
                loc = "index.html";
            }else{
                loc = "error.jsp";
            }
        }else{
            loc = "error.jsp";
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(loc);
        dis.forward(request, response);
    }

}
