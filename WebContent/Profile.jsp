<%@page import="model.Ns_User"%>
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
<title>Profile</title>
</head>
<body>
<% if(session.getAttribute("user")==null){ %>
   <section id="contact_form">
            <div class="container">
              <form id="signform" role="form" action="SignInUser" class="form-inline text-right " method="post">
            
                <div class="row">
                    <div class="col-md-6">
                        <h2>Do you have account?</h2>
                        <h2 class="second_heading">Login Now!</h2>
                        <div class="form-group">
                            <input id="usr_name" type="text" class="form-control" name="username" placeholder="User Name">
                        </div>
                                                  <div id="err_usr_name" style="display:none;"><h6></h6></div>

                        <div class="form-group">
                            <input id="pwd1" type="password" class="form-control" name="pwd1" placeholder="Password">
                        </div>
                                                 <div id="err_pwd" style="display:none;"><h6></h6></div> 
                        
                        <input id="hid1" type="hidden" name="signin"> 
                                                <button type="submit" class="btn submit_btn" onclick="{document.getElementById('hid1').setAttribute('value', 'signin');}">Log In</button>
                        
                    </div> 
                    <div class="col-md-6">
                    <h2>Create new account?</h2>
                        <h2 class="second_heading">Sign Up Now!</h2>
                                        <div class="row">

                        <div class="form-group col-md-9">
                            <input id="usr_name_2" type="text" class="form-control " name="name" placeholder="Name">
                            
                        </div>
                          </div>
                                                  <div id="err_usr_name2" style="display:none;"><h6></h6></div>
                          
                                                                  <div class="row">
                          
                        <div class="form-group col-md-9">
                            <input id="su_email" type="email" class="form-control" name="email" placeholder="Email">
                        </div>
                        </div> 

						<div class="row">
                        
                        <div class="form-group col-md-9">
                            <input id="su_email_con" type="email" class="form-control" name="con_email" placeholder="Confirm Email">
                        <div id="error_mail" style="display:none;"><h6></h6></div>
                        </div>
                        </div>  
                        <div class="row">
                        
                        <div class="form-group col-md-9">
                            <input id ="in_pwd" type="password" class="form-control" name="pwd" placeholder="Password">
                         <div id="error_pwd" style="display:none;"><h6></h6></div> 

                        </div>
                     
                        
                        <div class="form-group col-md-9">
                            <input id="con_pwd" type="password" class="form-control" name="con_pwd" placeholder="Confirm Password">
                        </div>
                        </div>
                         <div class="row ">
                        <div class="form-group ">
                        <input id="hid2" type="hidden" name="signup"> 
                                               
                        
                        <select name="user_type" class="form-control  ">
                        <option  value="client">Client</option>
                                                <option value="sender">Sender</option>
                                                <option value="admin">Admin</option>
                        
                        </select>
                        
                        </div>
                                                 <div class="form-group"> <h4>Account Type</h4></div>
                        
                        </div> 
                        
                        
                                                              <div class="row">
                        
                        <div class="form-group col-md-6">
                        <button id="signupbtn" type="submit" class="btn submit_btn" onclick="{document.getElementById('hid1').setAttribute('value', 'signup'); }">Submit</button>
                        </div>
                      </div>
                </div> </div>
             </form> </div>                  				
            
        </section>
        <% } else if(session.getAttribute("user")!=null && ((Ns_User) session.getAttribute("user")).Status.equals("PENDING CHECK")){ %> 
        
                <section id="why_us">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="head_title">
                            <h2>Confirm Your Account</h2>
                            <p>
                            Please check your mail and confirm the account to access to our services
                            </p>
                            

                        </div>
                    </div>
                </div>
                </div>
                </section>
        
         <% } else if(session.getAttribute("user")!=null && ((Ns_User) session.getAttribute("user")).Status.equals("PENDING ADMIN")){ %> 
        
                <section id="why_us">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="head_title">
                            <h2>Your mail is confirmed</h2>
                            <p>
							Please wait to confirm your account by the Super Admin
                            </p>
                            

                        </div>
                    </div>
                </div>
                </div>
                </section>
        
        <% } else {
        
        	Ns_User current = (Ns_User) session.getAttribute("user");
            current=new C_User().GetByID(current.ID);
            session.setAttribute("user", current);
        %> 
         <section id="why_us">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="head_title">
                            <h2>User Key</h2>
                            <p>
                            Your Key is:<%=current.User_Key %>
                            </p>
                            

                        </div>
                    </div>
                </div>
                </div>
                </section>
  
       <% if(current.User_Type.equals("CLIENT") || current.User_Type.equals("SENDER")){ %>
       
       
 <%@include file='Groups.jsp' %>
        
 <%@include file='Contacts.jsp' %>
        <%} else{ response.sendRedirect("Admin.jsp");%>
        	
  <%       } %>
        
        
        <%} %>
</body>
</html>