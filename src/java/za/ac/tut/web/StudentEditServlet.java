/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.SecurityFacadeLocal;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Assign;
import za.ac.tut.entity.Security;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"student"}))
public class StudentEditServlet extends HttpServlet {


    @EJB
    private SecurityFacadeLocal securityFacade;

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newName = request.getParameter("name");
        String newSurname = request.getParameter("surname");
        String newPassword = request.getParameter("password");
        String newPhone = request.getParameter("phone");
        String newStudNum = request.getParameter("studNum");
        String email = (String)session.getAttribute("email");
        
        
        Student student = studentFacade.find(email);
                
        if(newName != null){
            String password = newPassword;        
            String name = newName;
            String surname = newSurname;
            Integer phone = Integer.parseInt(newPhone);
            Integer studNum = Integer.parseInt(newStudNum);
            
            student.setName(name);
            student.setPassword(password);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setStudNum(studNum);
            
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            session.setAttribute("password", password);
            session.setAttribute("phone",phone);
            session.setAttribute("studNum",studNum);
            
            studentFacade.edit(student);
        }
        if(newSurname != null){
            String password = newPassword;
            String name = newName;
            String surname = newSurname;
            Integer phone = Integer.parseInt(newPhone);
            Integer studNum = Integer.parseInt(newStudNum);
            
            student.setName(name);
            student.setPassword(password);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setStudNum(studNum);
            
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            session.setAttribute("password", password);
            session.setAttribute("phone",phone);
            session.setAttribute("studNum",studNum);
            
            studentFacade.edit(student);
        }
        if(newPassword != null){
            String password = "";
            try {
                password = encodePassword(newPassword);
            } catch (Exception ex) {
                Logger.getLogger(AdminRegister.class.getName()).log(Level.SEVERE, null, ex);
            }

            Security security = securityFacade.find(email);

            security.setPassword(password);
            String name = newName;
            String surname = newSurname;
            Integer phone = Integer.parseInt(newPhone);
            Integer studNum = Integer.parseInt(newStudNum);
            
            student.setName(name);
            student.setPassword(password);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setStudNum(studNum);
            
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            session.setAttribute("password", password);
            session.setAttribute("phone",phone);
            session.setAttribute("studNum",studNum);
            
            studentFacade.edit(student);
        }
        if(newStudNum != null){
            String password = newPassword;
            String name = newName;
            String surname = newSurname;
            Integer phone = Integer.parseInt(newPhone);
            Integer studNum = Integer.parseInt(newStudNum);
            
            student.setName(name);
            student.setPassword(password);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setStudNum(studNum);
            
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            session.setAttribute("password", password);
            session.setAttribute("phone",phone);
            session.setAttribute("studNum",studNum);
            
            studentFacade.edit(student);
        }
        if(newPhone != null){
            String password = newPassword;
            String name = newName;
            String surname = newSurname;
            Integer phone = Integer.parseInt(newPhone);
            Integer studNum = Integer.parseInt(newStudNum);
            
            student.setName(name);
            student.setPassword(password);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setStudNum(studNum);
            
            session.setAttribute("name", name);
            session.setAttribute("surname", surname);
            session.setAttribute("password", password);
            session.setAttribute("phone",phone);
            session.setAttribute("studNum",studNum);
            
            studentFacade.edit(student);
        }
        
        
        RequestDispatcher dis = request.getRequestDispatcher("studentprofile.jsp");
        dis.forward(request, response);
    }

    private String encodePassword(String decodePassword) throws Exception {
        String s = decodePassword;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        
        return new BigInteger(1, m.digest()).toString(16);
    }

}
