/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.tut.business.StudentFacadeLocal;
import za.ac.tut.entity.Partner;
import za.ac.tut.entity.Student;
import za.ac.tut.entity.Video;
import za.ac.tut.entity.VideoFacadeLocal;

/**
 *
 * @author letso
 */
@MultipartConfig
@ServletSecurity(@HttpConstraint(rolesAllowed={"student"}))
public class UploadVideo extends HttpServlet {

    @EJB
    private VideoFacadeLocal videoFacade;

    @EJB
    private StudentFacadeLocal studentFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        String[] newPartner = request.getParameterValues("partner[]");
        String discription = request.getParameter("description");
        Part part = request.getPart("file");
        String videoName = part.getSubmittedFileName();
        String path = "C:\\Users\\letso\\Documents\\NetBeansProjects\\i-Tech\\web\\videos\\" + videoName;
        FileOutputStream fos = new FileOutputStream(path);
        
        InputStream is = part.getInputStream();
        byte[] data = new byte[is.available()];
        is.read(data);        
        fos.write(data);
        fos.close();
        
        Student student;
        student = studentFacade.find(email);                      
        
        List<Video> videos = student.getVideos();               
        
        String partner = email;
        String log = "";
        List<String> wrongEmail = new ArrayList<>();
        if((newPartner.length) > 1){    
            addVideo(videos, videoName, discription);
            session.setAttribute("videos", videos);
            student.setVideos(videos);
            studentFacade.edit(student);
        
            for(int i = 0; i < newPartner.length; i++){
                email = newPartner[i];
                student = studentFacade.find(email);                      

                if(student != null){
                    videos = student.getVideos();        

                    addPartnerVideo(videos, videoName, partner, discription);
                    session.setAttribute("videos", videos);
                    student.setVideos(videos);
                    studentFacade.edit(student);
                    request.setAttribute("success", "Uploaded sucessfully!");

                    log="loginsucess.jsp";
                }else{
                    wrongEmail.add(newPartner[i]);
                    request.setAttribute("mg", "studentprofile.jsp");
                    request.setAttribute("email", wrongEmail);
                    log="erroremail.jsp";
                }
            }
        }else{        
            addVideo(videos, videoName, discription);
            session.setAttribute("videos", videos);
            student.setVideos(videos);
            studentFacade.edit(student);
            request.setAttribute("success", "Uploaded sucessfully!");
            request.setAttribute("mg", "studentprofile.jsp");
            log="loginsucess.jsp"; 
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(log);
        dis.forward(request, response);
    }
    private void addVideo(List<Video> videos, String videoName, String discription) {
        Video video = new Video();
        
        video.setVideoName(videoName);
        video.setApprove("Pending");
        video.setDiscription(discription);
        
        videos.add(video);
    }

    private void addPartnerVideo(List<Video> videos, String videoName, String partner, String discription) {
        Video video = new Video();
        
        video.setVideoName(videoName);
        video.setApprove("Pending");
        video.setPartner(partner);        
        video.setDiscription(discription);
        
        videos.add(video);
    }
    
    

}
