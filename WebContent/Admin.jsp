<%@page import="model.Ns_User"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Templates</title>
</head>
<body>
<% if(session.getAttribute("user")==null ){ response.sendRedirect("default.jsp");} %>

<% if(session.getAttribute("user")!=null &&((Ns_User)session.getAttribute("user")).User_Type.equals("SENDER")){ response.sendRedirect("Templates.jsp");} %>
<%@include file='Header.jsp'   %>
        <section id="home" class="home">
            <!-- Carousel -->
            <div id="carousel" class="carousel slide" data-ride="carousel" style="height: 350px">
                <!-- Carousel-inner -->
                <div class="carousel-inner" role="listbox" style="height: 100%">
      
                    <div class="item active">
                        <img src="images/slider_img2.jpg" alt="Construction">
                        <div class="overlay">
                            <div class="carousel-caption">
                                <h3>Create Notification Templates</h3>
                                <p> Specify template's properties for scheduling, priorities, send way and escalation.
                                </p>
                        
                            </div>					
                        </div>
                    </div>
                
                </div><!-- Carousel-inner end -->



               
            </div><!-- Carousel end-->

        </section>


<%@include file='AddTemplate.jsp'   %>
<%@include file='Template.jsp'   %>

<%@include file='Footer.jsp' %>
        <!-- JavaScript -->
        <script src="js/jquery-1.12.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Bootsnav js -->
        <script src="js/bootsnav.js"></script>

        <!-- JS Implementing Plugins -->
        <script src="js/isotope.js"></script>
        <script src="js/isotope-active.js"></script>
        <script src="js/jquery.fancybox.js?v=2.1.5"></script>

        <script src="js/jquery.scrollUp.min.js"></script>

        <script src="js/main.js"></script>
 
</body>
</html>