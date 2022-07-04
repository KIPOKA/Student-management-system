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
import za.ac.tut.business.JobDiscriptionFacadeLocal;
import za.ac.tut.entity.JobDiscription;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"company"}))
public class CompanyRemoveJob extends HttpServlet {

    @EJB
    private JobDiscriptionFacadeLocal jobDiscriptionFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        
        JobDiscription jobDiscription = jobDiscriptionFacade.find(id);
        
        jobDiscription.setJobDiscription(null);
        jobDiscriptionFacade.edit(jobDiscription);
        
        RequestDispatcher dis = request.getRequestDispatcher("CompanyJobServlet.do");
        dis.forward(request, response);
    }

}
