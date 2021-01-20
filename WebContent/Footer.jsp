<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <meta charset="utf-8">
        <title>Construction - Free HTML Bootstrap Template</title>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Custom Fonts -->
        <link rel="stylesheet" href="custom-font/fonts.css" />
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css" />
        <!-- Bootsnav -->
        <link rel="stylesheet" href="css/bootsnav.css">
        <!-- Fancybox -->
        <link rel="stylesheet" type="text/css" href="css/jquery.fancybox.css?v=2.1.5" media="screen" />	
        <!-- Custom stylesheet -->
        <link rel="stylesheet" href="css/custom.css" />
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>
<body>
        <footer>
            <!-- Footer top -->
            <div class="container footer_top">
                <div class="row">
                    <div class="col-lg-4 col-sm-7">
                        <div class="footer_item">
                            <h4>About Company</h4>
                            <img class="logo" src="images/logo.png" alt="Construction" />
                            <p>
                            Notification System where you can send your notifications clearly in right time with many features
                            using dynamic templates with escalation, priority and scheduling.
                            
                            </p>

                            <ul class="list-inline footer_social_icon">
                                <li><a href="https://www.facebook.com"><span class="fa fa-facebook"></span></a></li>
                               </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-5">
                        <div class="footer_item">
                            <h4>Explore link</h4>
                            <ul class="list-unstyled footer_menu">
                                           <% if (session.getAttribute("user_type") != null && 
                           ( session.getAttribute("user_type").equals("S") ||session.getAttribute("user_type").equals("A"))  )
                           {%><li><a href=""><span class="fa fa-play"></span> Templates</a> 
                          
                           
                            <%}
                           if (session.getAttribute("user_type") != null && 
                                   ( session.getAttribute("user_type").equals("A"))  )
                                   {
                           %>
                           <li><a href="#"><span class="fa fa-play"></span>User Management</a></li>
                            <li><a href="#"><span class="fa fa-play"></span>Statistics</a></li>
                            <li><a href="#"><span class="fa fa-play"></span>System Management</a></li>
                            <%}                          
                            %>
                        <li><a href="#"><span class="fa fa-play"></span>About Us</a></li>
                             <li><a href="#"><span class="fa fa-play"></span>API</a></li>
                                      </ul>
                        </div>
                    </div>
                    
                </div>
            </div><!-- Footer top end -->

            <!-- Footer bottom -->
            <div class="footer_bottom text-center">
                <p class="wow fadeInRight">
                    Made with 
                    <i class="fa fa-heart"></i>
                    by 
                    <a target="_blank" href="http://bootstrapthemes.co">Bootstrap Themes</a> 
                    2019. All Rights Reserved
                </p>
            </div><!-- Footer bottom end -->
        </footer><!-- Footer end -->

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