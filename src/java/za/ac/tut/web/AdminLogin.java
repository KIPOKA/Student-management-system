/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.AdminFacadeLocal;
import za.ac.tut.entity.Admin;

/**
 *
 * @author letso
 */
public class AdminLogin extends HttpServlet {

    @EJB
    private AdminFacadeLocal adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Admin admin= adminFacade.find(email);
                
        String mg;
        if(admin.equals(null)){
            mg = "error.jsp";
        }else{
            String dbpassword = admin.getPassword();
            if(dbpassword.equals(password)){
                String name = admin.getName();
                String surname = admin.getSurname();
                Integer staffNum = admin.getStaffNum();
                Integer phone = admin.getPhone();
                              
                session.setAttribute("name", name);
                session.setAttribute("surname", surname);
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setAttribute("phone", phone);
                session.setAttribute("studNum", staffNum);
                    
                mg = "adminprofile.jsp";
                
            }else{
                mg = "error.jsp";
            }
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(mg);
        dis.forward(request, response);
    }

    public AdminFacadeLocal getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacadeLocal adminFacade) {
        this.adminFacade = adminFacade;
    }

}
