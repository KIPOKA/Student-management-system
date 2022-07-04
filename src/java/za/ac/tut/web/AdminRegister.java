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
import za.ac.tut.business.AdminFacadeLocal;
import za.ac.tut.business.AssignFacadeLocal;
import za.ac.tut.business.SecurityFacadeLocal;
import za.ac.tut.entity.Admin;
import za.ac.tut.entity.Assign;
import za.ac.tut.entity.Security;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class AdminRegister extends HttpServlet {

    @EJB
    private SecurityFacadeLocal securityFacade;

    @EJB
    private AssignFacadeLocal assignFacade;

    @EJB
    private AdminFacadeLocal adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String decodePassword = request.getParameter("password");
        String surname = request.getParameter("surname");
        Integer staffNum = Integer.parseInt(request.getParameter("staffNum"));
        Integer phone = Integer.parseInt(request.getParameter("phone"));
        String loc;
        
        String password = "";
        try {
            password = encodePassword(decodePassword);
        } catch (Exception ex) {
            Logger.getLogger(AdminRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Security security = initialiseSecurity(email, password);
        
        Assign assign = assignPerson(email);
        
        securityFacade.create(security);
        assignFacade.create(assign);
        
        if(email.contains("tut.ac.za")){
            Admin admin = registerAdmin(name, email, surname, password, staffNum, phone);

            adminFacade.create(admin);

            loc = "register.jsp";    
            String mg = "adminprofile.jsp";
            request.setAttribute("mg", mg);
            String reg = "register.jsp";  

            request.setAttribute("reg", reg);
            request.setAttribute("mg", mg);
            request.setAttribute("email", email);

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

    private Admin registerAdmin(String name, String email, String surname, String password, Integer staffNum, Integer phone) {
        Admin admin = new Admin();
        
        admin.setId(email);
        admin.setName(name);
        admin.setPhone(phone);
        admin.setStaffNum(staffNum);
        admin.setSurname(surname);
        admin.setPassword(password);
        
        return admin;
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
        
        a.setId("admin");
        a.setEmail(email);
        
        return a;
    }
}
