/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.Company;
import za.ac.tut.entity.Video;
import za.ac.tut.entity.VideoFacadeLocal;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"student"}))
public class DeleteVideoServlet extends HttpServlet {

    @EJB
    private VideoFacadeLocal videoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        
        Video video = videoFacade.find(id);
        
        video.setVideoName(null);
        videoFacade.edit(video);
        
        RequestDispatcher dis = request.getRequestDispatcher("StudentVideosSerlvlet.do");
        dis.forward(request, response);
    }

}
