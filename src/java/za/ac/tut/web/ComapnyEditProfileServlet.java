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
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.business.SecurityFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Security;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"company"}))
public class ComapnyEditProfileServlet extends HttpServlet {

    @EJB
    private SecurityFacadeLocal securityFacade;
    
    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newName = request.getParameter("name");
        String newPassword = request.getParameter("password");
        String newPhone = request.getParameter("phone");
        String email = (String)session.getAttribute("email");
        String newBuildName = request.getParameter("buildName");
        String newStreetName = request.getParameter("streetName");
        String newTown = request.getParameter("town");
        String newCode = request.getParameter("code");
        
        
        Company company= companyFacade.find(email);
                
        if(newName != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        if(newBuildName != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
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
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        if(newStreetName != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        if(newPhone != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        if(newTown != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        if(newCode != null){
            String password = newPassword;
            String name = newName;
            String buildName = newBuildName;
            Integer phone = Integer.parseInt(newPhone);
            String streetName = newStreetName;
            String town = newTown;
            Integer code = Integer.parseInt(newCode);
            
            Address address = registerAddress(buildName, streetName, town, code);
            
            company.setName(name);
            company.setPhone(phone);
            company.setAddress(address);
            company.setPassword(password);
                        
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("buildName", buildName);
            session.setAttribute("phone",phone);
            session.setAttribute("streetName",streetName);
            session.setAttribute("town",town);
            session.setAttribute("code",code);
            
            companyFacade.edit(company);
        }
        
        
        RequestDispatcher dis = request.getRequestDispatcher("companyprofile.jsp");
        dis.forward(request, response);        
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
}
