/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
@MultipartConfig
@ServletSecurity(@HttpConstraint(rolesAllowed={"student"}))
public class UploadCVServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        Part part = request.getPart("file");
        String cvName = part.getSubmittedFileName();
        String path = "C:\\Users\\letso\\Documents\\NetBeansProjects\\i-Tech\\web\\cv\\" + cvName;
        FileOutputStream fos = new FileOutputStream(path);
        
        InputStream is = part.getInputStream();
        byte[] data = new byte[is.available()];
        is.read(data);        
        fos.write(data);
        fos.close();
        
        Student student;
        student = studentFacade.find(email);
        
        student.setCvName(cvName);
        
        studentFacade.edit(student);
        
        request.setAttribute("mg", "StudentCV.do"); 
        request.setAttribute("success", "Uploaded sucessfully!");
        RequestDispatcher dis = request.getRequestDispatcher("loginsucess.jsp");
        dis.forward(request, response);
    }

}
