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
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.AdminFacadeLocal;
import za.ac.tut.business.CompanyFacadeLocal;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Address;
import za.ac.tut.entity.Admin;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.JobDiscription;
import za.ac.tut.entity.Student;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"student", "admin", "company"}))
public class StudentLogin extends HttpServlet {

    @EJB
    private CompanyFacadeLocal companyFacade;

    @EJB
    private AdminFacadeLocal adminFacade;

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getUserPrincipal().getName();
        String password = request.getParameter("password");
        
        Student student= studentFacade.find(email);
        Admin admin= adminFacade.find(email);
        Company company= companyFacade.find(email);
        
        String mg, loc = "";
        if(student!=(null) && email.contains("@tut4life.ac.za")){
            String dbpassword = student.getPassword();
            //if(dbpassword.equals(password)){
                String name = student.getName();
                String surname = student.getSurname();
                Integer studNum = student.getStudNum();
                Integer phone = student.getPhone();

                session.setAttribute("student", student);
                session.setAttribute("name", name);
                session.setAttribute("surname", surname);
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setAttribute("phone", phone);
                session.setAttribute("studNum", studNum);

                loc = "loginsucess.jsp";
                mg = "studentprofile.jsp";
                request.setAttribute("mg", mg);
                request.setAttribute("success", "Login Sucessful!");

            //}else{
//                loc = "error.jsp";
//                mg = "studentlogin.jsp";
//                
//                request.setAttribute("mg", mg);                    
//                request.setAttribute("success", "Wrong Password!");
            //}
        
        }else if(admin!=null && email.contains("@tut.ac.za")){
            String dbpassword = admin.getPassword();
            //if(dbpassword.equals(password)){
                String name = admin.getName();
                String surname = admin.getSurname();
                Integer staffNum = admin.getStaffNum();
                Integer phone = admin.getPhone();
                              
                session.setAttribute("name", name);
                session.setAttribute("surname", surname);
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setAttribute("phone", phone);
                session.setAttribute("staffNum", staffNum);
                    
                loc = "loginsucess.jsp";
                mg = "adminprofile.jsp";
                
                request.setAttribute("mg", mg);
                request.setAttribute("success", "Login Sucessful!");
                
//            }else{
//                loc = "error.jsp";
//                mg = "studentlogin.jsp";
//                request.setAttribute("mg", mg);
//                    
//                request.setAttribute("success", "Wrong Password!");
//            }
        }else if(company!=null){
            String dbpassword = company.getPassword();
            //if(dbpassword.equals(password)){
                String approval = company.getApproval();
                
                //if(approval.equals("Approved")){
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

                    loc = "loginsucess.jsp";
                    mg = "companyprofile.jsp";
                    request.setAttribute("mg", mg);
                    request.setAttribute("success", "Login Sucessful!");
//                }else{
//                    loc = "error.jsp";
//                    mg = "studentlogin.jsp";
//                    request.setAttribute("pending", "Pending");
//                    request.setAttribute("mg", mg);
//                    
//                    request.setAttribute("success", "Company Unapproved!");
//                }
                
//            /}else{
//                loc = "error.jsp";
//                mg = "studentlogin.jsp";
//                request.setAttribute("mg", mg);
//                    
//                request.setAttribute("success", "Wrong Password!");
            //}
        }else{
            loc = "error.jsp";
            mg = "studentlogin.jsp";
            request.setAttribute("mg", mg);
                    
            request.setAttribute("success", "Email doesn't exits!");
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(loc);
        dis.forward(request, response);
    }

}
