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
import za.ac.tut.entity.Video;
import za.ac.tut.entity.VideoFacadeLocal;

/**
 *
 * @author letso
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class VideoDeclineServlet extends HttpServlet {

    @EJB
    private VideoFacadeLocal videoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        
        String text = "<h4> Dear student,<br> Your video, is being declined. <br>Kind regards.<br>   <b>i-TECH Group</b> </h4>";
        Video video = videoFacade.find(id);
        
        video.setApprove("Declined");
        
        videoFacade.edit(video);
        
        request.setAttribute("email", email);
        request.setAttribute("text", text);
        request.setAttribute("reg", "ApproveVideoServlet.do");
        request.setAttribute("success", "Uploaded sucessfully!");
        
        RequestDispatcher dis = request.getRequestDispatcher("VerifyEmail.do");
        dis.forward(request, response);
    }

}
