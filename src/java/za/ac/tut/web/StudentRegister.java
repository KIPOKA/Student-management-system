/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.business.AdminFacadeLocal;
import za.ac.tut.business.AssignFacadeLocal;
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.business.SecurityFacadeLocal;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Admin;
import za.ac.tut.entity.Assign;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Security;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class StudentRegister extends HttpServlet {

    @EJB
    private SecurityFacadeLocal securityFacade;

    @EJB
    private AssignFacadeLocal assignFacade;

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String decodePassword = request.getParameter("password");
        String surname = request.getParameter("surname");
        Integer studNum = Integer.parseInt(request.getParameter("studNum"));
        Integer phone = Integer.parseInt(request.getParameter("phone"));
        String loc;
        
        String password = "";
        
        
        if(email.contains("tut4life")){
            Student student = registerStudent(name, email, surname, password, studNum, phone);
            
            try {
                password = encodePassword(decodePassword);
            } catch (Exception ex) {
                Logger.getLogger(AdminRegister.class.getName()).log(Level.SEVERE, null, ex);
            }

            Security security = initialiseSecurity(email, password);

            Assign assign = assignPerson(email);

            securityFacade.create(security);
            assignFacade.create(assign);
        
            studentFacade.create(student);
            loc = "register.jsp";           
            String text = "<h4> Dear applicant,<br> By this email, your registration has been successfully <br> received. Thank you for your support. <br>Kind regards.<br>   <b>i-TECH Group</b> </h4>";
            String reg = "register.jsp";            
            String mg = "index.html";
            
            request.setAttribute("reg", reg);
            request.setAttribute("mg", mg);
            request.setAttribute("email", email);
            request.setAttribute("text", text);

            request.setAttribute("success", "Register sucessful!");
        }else {
            loc = "error.jsp";
            String mg = "adminprofile.jsp";
            request.setAttribute("mg", mg);

            request.setAttribute("success", "Wrong email!");
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(loc);
        dis.forward(request, response);
    }

    private Student registerStudent(String name, String email, String surname, String password, Integer staffNum, Integer phone) {
        Student studnet = new Student();
        
        studnet.setId(email);
        studnet.setName(name);
        studnet.setPhone(phone);
        studnet.setStudNum(staffNum);
        studnet.setSurname(surname);
        studnet.setPassword(password);
        return studnet;
    }

    private String encodePassword(String decodePassword) throws Exception {
        String s = decodePassword;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        
        return new BigInteger(1, m.digest()).toString(16);
    }

    private Security initialiseSecurity(String email, String password) {
        Security s = new Security();
        
        s.setId(email);
        s.setPassword(password);
        
        return s;
    }

    private Assign assignPerson(String email) {
        Assign a = new Assign();
        
        a.setId("student");
        a.setEmail(email);
        
        return a;
    }
}
