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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.business.AssignFacadeLocal;
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.business.SecurityFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Assign;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Security;
import static za.ac.tut.entity.Security_.password;


/**
 *
 * @author letso
 */
public class CompanyRegister extends HttpServlet {

    @EJB
    private SecurityFacadeLocal securityFacade;

    @EJB
    private AssignFacadeLocal assignFacade;

    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String decodePassword = request.getParameter("password");
        String buildName = request.getParameter("buildName");
        String streetName = request.getParameter("streetName");
        String town = request.getParameter("town");
        Integer code = Integer.parseInt(request.getParameter("code"));
        
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
        
        Address address = registerAddress(buildName, streetName, town, code);
        
        Company company = registerStudent(name, email, address, password );
        
        companyFacade.create(company);
            
        String mg = "index.html";
        request.setAttribute("mg", mg);

            request.setAttribute("success", "Register sucessful!");
        
        RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
        dis.forward(request, response);
    }

    private Company registerStudent(String name, String email, Address address, String password) {
        Company company = new Company();
        
        company.setAddress(address);
        company.setName(name);
        company.setPassword(password);
        company.setId(email);
        company.setApproval("Pending");
        
        return company;
    }

    private Address registerAddress(String buildName, String streetName, String town, Integer code) {
        Address address = new Address();
        
        address.setBuildName(buildName);
        address.setCode(code);
        address.setTown(town);
        address.setStreetName(streetName);
        
        return address;
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
        
        a.setId("company");
        a.setEmail(email);
        
        return a;
    }
}
