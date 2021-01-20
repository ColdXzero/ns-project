<%@page import="Controller.C_Setting"%>
<%@page import="model.Ns_Setting"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>System Setting</title>
</head>
<body>
<%@include file="Header.jsp" %>
   <section id="contact_form">
            <div class="container">
                <div class="row">
                <div class=form-group style="text-align: center;">
                <h2>Setting</h2></div>
                    <form role="form" class="form-inline text-right col-md-12" action="EditSetting" method="post"  >
 						<table cellspacing="4" style="text-align: center;">
 						<tr>
 						<th>
 						 <div class="form-group">
                       	<h6> Setting Value</h6>
                        </div>
                        </th>
                        						<th>
 						 <div class="form-group">
                       	<h6> Setting Type</h6>
                        </div>
                       </th>

 											<th>
 						 <div class="form-group">
                        </div>
                       </th>
 						
 						</tr>
 						<% for (Ns_Setting c : new C_Setting().GetAll("")){ %>
                            <tr>
                           <td>
                           <div class="form-group">
                         	<input type="text" name="set_val<%=c.ID %>" class="form-control" style="width:100%;" id="s_val<%=c.ID %>" placeholder="Setting Value" value=<%=c.Value %>>
                         	</div>
                       	 </td>

                            <td><p ><%= c.Type %></p></td>
                            
						<td>
						<div class="form-group">
                         <button type="submit"  class="btn submit_btn" style="width:100%;" id="contact_order_new" onclick="document.getElementById('setting_id').setAttribute('value', <%=c.ID%>)" >edit</button>
                        </div></td>
                              
                 			</tr>
                 			<%} %>
                     <input type="hidden" name="setting_id" id="setting_id">
           
			                	  
                            	  </table>
                            	  </form>
                            	</div>
</div>
                    
              
        
        </section><!-- Contact form end -->
<%@include file="Footer.jsp" %>
</body>
</html>