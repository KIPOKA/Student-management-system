/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.JobDiscription;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
public class CompanyLogin extends HttpServlet {

    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Company company= companyFacade.find(email);
        
        String mg;
        if(company.equals(null)){
            mg = "error.jsp";
        }else{
            String dbpassword = company.getPassword();
            if(dbpassword.equals(password)){
                String approval = company.getApproval();
                
                if(approval.equals("Approved")){
                    String name = company.getName();                
                    List<JobDiscription> jobDescription = company.getJobDescription();
                    Address address = company.getAddress();

                    String builName = address.getBuildName();
                    String streetName = address.getStreetName();
                    String town = address.getTown();
                    Integer code = address.getCode();

                    session.setAttribute("email", email);
                    session.setAttribute("name", name);
                    session.setAttribute("approval", approval);
                    session.setAttribute("jobDescription", jobDescription);
                    session.setAttribute("password", password);
                    session.setAttribute("builName", builName);
                    session.setAttribute("streetName", streetName);
                    session.setAttribute("town", town);
                    session.setAttribute("code", code);

                    mg = "companyprofile.jsp";
                }else{
                    mg = "error.jsp";
                    request.setAttribute("pending", "Pending");
                }
                
            }else{
                mg = "error.jsp";
            }
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(mg);
        dis.forward(request, response);
    }

}
