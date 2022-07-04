/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
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
import za.ac.tut.entity.Company;
import za.ac.tut.entity.JobDiscription;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"company"}))
public class JobDescriptionServlet extends HttpServlet {

    @EJB
    private CompanyFacadeLocal companyFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        String jobDiscription = request.getParameter("jobDescription");
        
        Company company = companyFacade.find(email);
                
        List<JobDiscription> jobDescription = company.getJobDescription();
         
        newJobDescription(jobDiscription, jobDescription);
        

        company.setJobDescription(jobDescription);

        companyFacade.edit(company);
                
        RequestDispatcher dis = request.getRequestDispatcher("jobdescription.jsp");
        dis.forward(request, response);        
    }

    private void newJobDescription(String jobDiscription, List<JobDiscription> jobs) {
        JobDiscription discription = new JobDiscription();
        
        discription.setJobDiscription(jobDiscription);
        jobs.add(discription);

    }

}
