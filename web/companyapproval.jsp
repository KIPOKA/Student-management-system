<%-- 
    Document   : companyapproval
    Created on : May 15, 2022, 11:43:52 PM
    Author     : letso
--%>

<%@page import="za.ac.tut.entity.Address"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Approval Page</title>
        <link rel="stylesheet" href="CSS/tables.css"/>
        <link rel="stylesheet" href="CSS/student.css"/>
        <link rel="stylesheet" href="CSS/stylemain.css"/>
        <link rel="stylesheet" href="CSS/delete.css"/>
        <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
     </head>
    <body>
        <div class="banner" >
            <div class="navbar">
                <nav>
                    <input type="checkbox" id="check"/>
                    <label for="check" class="checkBtn">
                        <i class="fas fa-bars"></i>                        
                    </label>

                    <label class="logo">i-Tech</label>
                
                <ul >
                    <li><a href="adminprofile.jsp" class="active"> <i class="fa-solid fa-house"></i>Home</a></li>
                    <li><a href="adminregister.jsp"><i class="fa-solid fa-users"></i> Add Admin </a></li>
                    <li><a href="ApproveVideoServlet.do"><i class="fa-solid fa-check"></i> Pending Video</a></li>
                    <li><a href="GetAllStudents.do"><i class="fa-solid fa-graduation-cap"></i> Students</a></li>
                    <li><a href="ApproveCompany.do"><i class="fa-solid fa-building"></i>Companies</a></li> 
                    <li><a href="adminviewprofile.jsp"><i class="fa-solid fa-user"></i>  View Profile</a></li>
                    <li><a href="EndSession.do"><i class="fa-solid fa-arrow-right-from-bracket"></i>Log out</a></li>                   
                </ul>
                </nav>
            </div> 
        <div class="contn">
        <table class="content-table">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Company ID</th>
                    <th>Name</th>
                    <th>Building name</th>
                    <th>Street</th>
                    <th>Street number</th>
                    <th>Town</th>
                    <th>Status</th>
                    <th>Status approval /</th>
                    <th>declined</th>
                    
                </tr>
            </thead>
            <%
            List<Company> companiesPending = (List<Company>)session.getAttribute("companies");
            Integer count = 0;
            for(Company companyPending: companiesPending){
                String approval = companyPending.getApproval();
                count++;
                
                Address address = companyPending.getAddress();
                
            %>
            <tbody>
                <tr>
<!--        REPLACE BY GETTERS OF ALL-->
                    <td><%=count%></td>
                    <td> <%=companyPending.getId() %></td>
                    <td> <%=companyPending.getName() %></td>
                    <td><%=address.getBuildName() %></td>            
                    <td><%=address.getStreetName() %></td>            
                    <td><%=address.getTown() %></td>            
                    <td><%=address.getCode() %></td>
                    <td><%=approval %></td>
                    <td><form action="ApprovedCompany.do" method="GET">
                            <input name="name" value="<%=companyPending.getId() %>" hidden="true" />
                    <input type="submit" value="Approve" class="approve-comp"/>
                    </form></td>

                        <td><form action="DeclineCompany.do" method="GET">
                        <input name="name" value="<%=companyPending.getId() %>" hidden="true" />
                        <input type="submit" value="Decline" class="decline-comp"/>
                    </form></td>
                
                    
                </tr>
            </tbody>
            <%
            
                }
            %>
        </table >
        </div>
        </div>
    </body>
</html>


<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            //List<Company> companiesPending = (List<Company>)session.getAttribute("companies");
            
            for(Company companyPending: companiesPending){
                String approval = companyPending.getApproval();
        %>
        <table>
            <tr>
                <td><%=companyPending.getName() %></td>
            </tr>
            <tr>
                <td><%=companyPending.getId() %></td>
            </tr>
            <%
                Address address = companyPending.getAddress();
            %>
            <tr>
                <td><%=address.getBuildName() %></td>
            </tr>
            <tr>
                <td><%=address.getStreetName() %></td>
            </tr>
            <tr>
                <td><%=address.getTown() %></td>
            </tr>
            <tr>
                <td><%=address.getCode() %></td>
            </tr>
            
        </table>
            
                <p><%=approval%></p>
                <form action="ApprovedCompany.do" method="GET">
                    <input name="name" value="<%=companyPending.getId() %>" hidden="true"/>
                    <input type="submit" value="Approve" />
                </form>
                <form action="DeclineCompany.do" method="GET">
                    <input name="name" value="<%=companyPending.getId() %>" hidden="true"/>
                    <input type="submit" value="Decline" />
                </form>
                
                <form action="DeclineCompany.do" method="GET">
                    <input name="name" value="<%=companyPending.getId() %>" hidden="true"/>
                    <input type="submit" value="Delete" />
                </form>               
        <%
            
            }
        %>
        
    </body>
</html>-->
