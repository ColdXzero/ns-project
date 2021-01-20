<%@page import="Controller.C_User"%>
<%@page import="model.Ns_User"%>
<%@page import="Controller.C_MemberShip"%>
<%@page import="model.Ns_MemberShip"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Group_Management.View_group"%>
<%@page import="Group_Management.Group_manage"%>
<%@page import="Controller.C_Group"%>
<%@page import="model.Ns_Group"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Groups</title>
</head>
<body>
  
<form id="form1" role="form" action="group_request" method="post" >
<input id="req_type" type="hidden" name="req_type" >
<input id="group_id" type="hidden" name="group_id" >

<section id="why_us">

            <div class="container text-center">
                 <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="head_title">
                            <h2>Notification Groups</h2>
                            <p>
                            Join the group and receive the notifications which send to all member of the group, Please note that you need 
                            approval from group owner to complete join request.
                            </p>

                        </div>
                    </div>
                </div>
            
                <div class="row">
      <div class="col-md-3 col-sm-6">
                        <div class="why_us_item">
                            <span class="fa fa-group"  ></span>
                            <h4>All Users</h4>
                            <p>Show all clients
                            </p>
                            <button class="btn" type="button" onclick="ShowAll()">Show</button>
                            <% ArrayList <Ns_User> all = new C_User().GetAll("user_type in ('SENDER','CLIENT') and status='TRUE'"); %>
	 <div class="popup" >                   
                            	  <span id="alluser" class="popuptext" style="width: 200px; height: 90px;">
						<select class="form-control" rows="<%=2*(all.size()+1)%>" cols="30">
						<% if (all!=null)
							for(Ns_User x :all){ %> <option> <%=x.User_Name %> </option> <%} %>
						</select> 
                            	 
                </span>
                
                </div>
                        
                    </div></div>
                          
<%
ArrayList<Ns_Group> groups = View_group.view_active_group(); 
int uid=((Ns_User)session.getAttribute("user")).ID;
for (Ns_Group xg : groups){
 	ArrayList<Ns_MemberShip> mems=new C_MemberShip().GetByUserIDGroupID(uid, xg.ID);
  xg=new C_Group().LoadUsers(xg);
    %>
                    <div class="col-md-3 col-sm-6">
                        <div class="why_us_item">
                            <span class="fa fa-group"></span>
                            <h4><%=xg.Name %></h4>
                            <p><%=xg.Description %>
                           
                            </p>
       <button class="btn" type="button" onclick="ShowAll2(<%=xg.ID%>)">Show Members</button>
                            
	 <div class="popup" >                   
                            	  <span id="alluser<%=xg.ID%>" class="popuptext" style="width: 200px; height: 90px;">
						<select class="form-control" rows="<%=2*(xg.users.size()+1)%>" cols="30">
						<% if (xg.users!=null)
							for(Ns_User x :xg.users){ %> <option> <%=x.User_Name %> </option> <%} %>
						</select> 
                            	 
                </span>
                
                </div>
                        
                    </div>
                          
                            <% if(mems!=null && mems.size()>0)
                            {
                            	if(mems.get(0).Status.equals("TRUE")) {%>
                            	  <a href="javascript:{}" class="btn know_btn" onclick="{document.getElementById('req_type').setAttribute('value', 'L');document.getElementById('group_id').setAttribute('value', '<%=xg.ID%>'); document.getElementById('form1').submit();}"> Leave  </a>
                            	<% } else if(mems.get(0).Status.equals("PENDING_APPROVE")){%>
                            	  <a href="javascript:{}" class="btn know_btn" onclick="{document.getElementById('req_type').setAttribute('value', 'C');document.getElementById('group_id').setAttribute('value', '<%=xg.ID%>'); document.getElementById('form1').submit();}"> Cancel Request </a>
                            	 <%} 
                             else if(mems.get(0).Status.equals("FALSE")){%>
                          	  <a href="javascript:{}" class="btn know_btn" onclick="{document.getElementById('req_type').setAttribute('value', 'J');document.getElementById('group_id').setAttribute('value', '<%=xg.ID%>'); document.getElementById('form1').submit();}"> Join </a>
                          	 <%} 
                            }
                            else  {%>
                                                        	  <a href="javascript:{}" class="btn know_btn" onclick="document.getElementById('req_type').setAttribute('value', 'J'); document.getElementById('group_id').setAttribute('value', '<%=xg.ID%>'); document.getElementById('form1').submit();"> Join </a>
                            	  
                            	<% } %>
                                  
                        
                    </div>

<% } %>
</div>
</div>
</section>
</form>
</body>
</html>