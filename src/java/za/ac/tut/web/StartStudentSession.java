/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Student;
import za.ac.tut.entity.Video;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"student","admin", "company"}))
public class StartStudentSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getUserPrincipal().getName();
        String password = (String)request.getParameter("j_password");
        
        initialise(session, email, password);
        
        //response.sendRedirect();
        RequestDispatcher dis = request.getRequestDispatcher("StudentLogin.do");
        dis.forward(request, response);
    }

    private void initialise(HttpSession session, String email, String password) {
        String video = "", name = "", surname = "";
        Integer phone = 0, studNum = 0, staffNum = 0;
        Student student = new Student();
        Company company = new Company();
        List<Video> videos  = new ArrayList<>();
        List<Company> jobAvailable = new ArrayList<>();       
        List<Company> companies = new ArrayList<>();
        List<Student> allStudents = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Student> partners = new ArrayList<>();
        String streetName = "",  buildName = "", jobDiscription = "", approval = "", town = "";
        Integer code = 0;
        
        session.setAttribute("company", company);
        session.setAttribute("student", student);
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        session.setAttribute("jobDiscription", jobDiscription);
        session.setAttribute("approval", approval);
        session.setAttribute("code", code);
        session.setAttribute("streetName", streetName);
        session.setAttribute("town", town);
        session.setAttribute("buildName", buildName);        
        session.setAttribute("staffNum", staffNum);
        session.setAttribute("password", password);
        session.setAttribute("companies", companies);
        session.setAttribute("allStudents", allStudents);        
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("surname", surname);
        session.setAttribute("video", video);
        session.setAttribute("studNum", studNum);
        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        session.setAttribute("videos", videos);
        session.setAttribute("students", students);
        session.setAttribute("partners", partners);
        session.setAttribute("jobAvailable", jobAvailable);
    }
}
