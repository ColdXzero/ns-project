<%@page import="UserManagement.ManageUsers"%>
<%@page import="Controller.C_User"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>User Management</title>
</head>
<body>
<%@include file="Header.jsp" %>
   <section id="contact_form">
            <div class="container">
                <div class="row">
                <div class=form-group style="text-align: center;">
                <h2>Users</h2></div>
                    <form role="form" class="form-inline text-right col-md-12" action="UserMange" method="post"  >
 						<table cellspacing="4" style="text-align: center;">
 						<tr>
 						<th>
 						 <div class="form-group">
                       	<h6> User Name</h6>
                        </div>
                        </th>
                        						<th>
 						 <div class="form-group">
                       	<h6> User Type</h6>
                        </div>
                       </th>
                        						<th>
 						 <div class="form-group">
                       	<h6> User Status</h6>
                        </div>
                       </th>
                        
                        						<th>
 						 <div class="form-group">
                       	<h6> Send Rate</h6>
                        </div>
                       </th>

 											<th>
 						 <div class="form-group">
                        </div>
                       </th>
 								<th>
 						 <div class="form-group">
                        </div>
                       </th>
 						</tr>
 						<% for (Ns_User c : ManageUsers.GetAllPending()){ %>
                            <tr>
                            <td><p ><%= c.User_Name %></p></td>
                            <td><p ><%= c.User_Type %></p></td>
                            <td><p ><%= c.Status %></p></td>

                           <td>
                           <div class="form-group">
                         	<input type="text" name="usr_val<%=c.ID %>" class="form-control" style="width:100%;" id="s_val<%=c.ID %>" placeholder="Send Rate" value=<%=c.Send_rate%>>
                         	</div>
                       	 </td>

                            
						<td>
						<div class="form-group">
                         <button type="submit"  class="btn submit_btn" style="width:100%;" id="contact_order_new" onclick="document.getElementById('user_id').setAttribute('value', <%=c.ID%>)" >edit </button>
                        </div></td>
                        <td>
						<div class="form-group">
                         <button type="submit"  class="btn submit_btn" style="width:100%;" id="contact_order_new" onclick="document.getElementById('user_confirm_id').setAttribute('value', <%=c.ID%>)" >Confirm</button>
                        </div>
                        </td>
                              
                 			</tr>
                 			<%} %>
                     <input type="hidden" name="user_id" id="user_id">
                     <input type="hidden" name="user_confirm_id" id="user_confirm_id">
           
			                	  
                            	  </table>
                            	  </form>
                            	</div>
</div>
                    
              
        
        </section><!-- Contact form end -->
<%@include file="Footer.jsp" %>

</body>
</html>