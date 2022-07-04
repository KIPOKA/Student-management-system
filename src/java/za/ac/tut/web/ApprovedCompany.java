/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.entity.Company;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class ApprovedCompany extends HttpServlet {

    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("name");
        
        Company approveCompany = companyFacade.find(email);
        
        approveCompany.setApproval("Approved");
        
        companyFacade.edit(approveCompany);
        
        RequestDispatcher dis = request.getRequestDispatcher("ApproveCompany.do");
        dis.forward(request, response);
    }

}
