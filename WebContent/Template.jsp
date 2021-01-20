<%@page import="Controller.C_User"%>
<%@page import="UserManagement.ManageUsers"%>
<%@page import="model.NotTemplate"%>
<%@page import="Template_management.Template_manage"%>
<%@page import="model.Ns_Template_Privillege"%>
<%@page import="Group_Management.View_group"%>
<%@page import="Controller.C_MemberShip"%>
<%@page import="model.Ns_MemberShip"%>
<%@page import="model.Ns_User"%>
<%@page import="model.Ns_Group"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Templates</title>
</head>
<body>
  
<% 
ArrayList<NotTemplate> temps =null;
String title=""; 
int access=0;
Ns_User u=((Ns_User)session.getAttribute("user"));
if(u == null) response.sendRedirect("default.jsp");
else if(u.User_Type.equals("SENDER")){
 temps= Template_manage.GetTemplatesByUserID(u);
title="You can use the below ID to send notifications"; 
}
else if(u.User_Type.equals("ADMIN"))
{
	access=1;
	temps=Template_manage.view_templates_for_owner(u);
title="You are the ownere of below notifications"; 

}
	
	%>
<section id="why_us">
     <div class="container text-center">
          <div class="row">
		          <div class="col-md-8 col-md-offset-2">
		               <div class="head_title">
		                            <h2>Notification Templates</h2>
									<h4><%=title %></h4>
		                </div>
		           </div>
          </div>
          <div class="row">     

<%
	if(temps!=null)
		for (NotTemplate xt : temps){
    %>

            <div class="col-md-4 col-sm-8">
                <div class="why_us_item">
                    <span class="fa fa-group"></span>
                    <h4><%=xt.Tittle %></h4>
                    <h5> ID :<%=xt.ID %></h5>      
                	<div class="testimonial_item">
                       <div class="testimonial_content text-left">
                            <p>
 							   <%=xt.Duration!=null?"Duration:"+xt.Duration+"<br/>":"" %>
                            	Send Way:<%=xt.Send_Way %><br/>
                            	Start Date:<%=xt.Start_Date %> <br/>
                            	<%=xt.End_Date!=null?"End Date:"+xt.End_Date+"<br/>":"" %> 
                            	<%=xt.Escalation.equals("T")?"Escalition:Active <br/>":""%> <br/>
                               	Text: <%=xt.T_TEXT %></p>
                            <p>        
                        </div>
                    </div>
   	<% if(access==1) {%>				                 
                    <button  class="btn"  type="button" onclick="{ShowTempPop3(<%=xt.ID %>);}"> Grant Access</button> <%} %>
<div class="popup" >
                                    
					<span class="popuptext" id="TempPopSend<%=xt.ID %>" style="width: 200px;">
   						 <!-- Edit Template start -->
            			<div class="container">
              			  	<form role="form"  class="form-inline text-left" action="GrantAccess" method="post">
              			  		<input type="hidden" name="edit_id_sender" id="edit_id_sender<%=xt.ID %>">
                    			<div class="row">
                    				<div class="col-md-6">
                    				<div style="text-align: left;">
                        				<h4>Template <%=xt.ID %></h4>
                         			</div>
    									

                         							<select name="senders" class="form-control col-md-6 "  style="width:20%">
	                                            <% 
	                                            ArrayList<Ns_User> senders= new C_User().GetAll(" user_type='SENDER'");
	                                            if(senders!=null)
	                                            	for(Ns_User x : senders)
	                                            	{
	                                            %>
	                                                	<option  value="<%=x.ID%>"><%=x.User_Name %></option>
								                	<%} %>
								                	</select>
								                	 <button  class="btn"  type="submit" onclick="document.getElementById('edit_id_sender<%=xt.ID %>').setAttribute('value', ''+<%=xt.ID %>);">Grant</button>
								                	
         </div>              
        
						 			
										
									
</div>
		
</form>
</div>    
</span>
</div>                	<% if(access==1) {%>	
                    <button  class="btn"  type="button" onclick="{ShowTempPop2(<%=xt.ID %>);}"> Edit</button> 	<% }%>	
                    <div class="popup" >
                                    
					<div class="popuptext" id="TempPop<%=xt.ID %>" style="width: 700px;">
   						 <!-- Edit Template start -->
            			<div class="container">
              			  	<form role="form"  class="form-inline text-right" action="AddTemplates" method="post">
              			  		<input type="hidden" name="edit_id" id="edit_id<%=xt.ID %>">
                    			<div class="row">
                    				<div class="col-md-4">
                    				<div style="text-align: left;">
                        				<h4>Edit Template <%=xt.ID %></h4>
                         		</div>
		                         		<div class="row">
		                        			<div class="form-group col-md-3" >
		                        			<p>Title:</p>
		                        			</div>
		                         		 
		                        			<div class="form-group col-md-3" >
		                            			<input id="not_title"  type="text" class="form-control" name="not_title" placeholder="Insert Title Here!" value=<%=xt.Tittle %>>
		                        			</div>
		                     			</div>
		                      			<div class="row">
		                        			<div class="form-group col-md-3" >
		                        			<p>Text:</p>
		                        			</div>

		                        			<div class="form-group col-md-6">
					                            <textarea id="not_txt<%=xt.ID %>"  style="width:200px;height: 80%;"class="form-control" name="not_txt"  placeholder="Insert Text Here!" rows='10' cols='30'><%=xt.T_TEXT %></textarea>
		            			            </div>
		                         		</div>
		                         		<div class="row">
		                                    <div class="popup" >
		                                    	<button  class="btn"  style="color:black;" type="button" onclick="ShowFieldPop2(<%=xt.ID %>)">Add Fields</button>    
												<input type="hidden" id="fieldsnew<%=xt.ID %>" name="fieldsnew" value="<%=xt.T_Fields %>" > 
		                            	  		<div class="popuptext" id="FieldsPop<%=xt.ID %>" style="width: 350px;">                            	 
		                   							<div class=form-group style="text-align: center;">
		                								<div class="form-group col-md-6">
		                            						<input id="not_field_add<%=xt.ID %>" type="text" class="form-control"  placeholder="Field Name">
		                       							 </div>
		                        						<button id="addFieldName" type="button"  onclick="addFieldNameFun2(<%=xt.ID %>)" >+</button>
		                							</div>
		                						</div>
		               						 </div>                        
		                   				 </div>
		                   				 <div class="row" >
		               						 <div class="col-md-6">
		                        					<button id="AddTemplateBtn" type="submit" class="btn" style="color:black;" onclick="document.getElementById('edit_id<%=xt.ID %>').setAttribute('value', ''+<%=xt.ID %>);" >Finish</button>
		                        			 </div>
		                       			 </div>
		                    </div>
                    			<div class="col-md-4">
                    			<div style="text-align: left;">
                    					<h4>Template Properties</h4>
                    					</div>
							 			<div class="row">
							 					                        			<div class="form-group col-md-3" style="text-align: left;">
		                        		<p> End Date:</p>
					                    	</div>
							 			
							 			    <div class="form-group col-md-6">
                    					        <input id="not_end_date" type="datetime-local" class="form-control" name="not_end_date" placeholder="End Date">
                        					</div>
                       					 </div> 
                       		
                         				<div class="row ">
                                                 <div style="text-align: left;" class="form-group col-md-6" > <h4>Send Way</h4>
                                         		 </div>
                        						<select name="SendWay" class="form-control col-md-6 "  style="width:20%">
                     							   <option  value="email">Email</option>
                                                   <option value="sms">SMS</option>
                                                   <option value="push">Push Notification</option>
                        						</select>
										</div>
                         				<div class="row ">
                                                 <div class="form-group col-md-6" style="text-align: left;"> <h4>Scheduling</h4>
                                                 </div>
                        							<input type="text"  placeholder="Minutes" name="duration" class="form-control col-md-6 "  style="width:20%">
	                                                	
                        				</div> 
				                        <div class="row">
				                            <div class="form-group col-md-4">
					                    	 Has Escalation
					                        </div>
				                        
					                        <div class="form-group col-md-4">
					                            <input id="not_escal" type="checkbox" class="form-control " name="not_escal" style="width: 10%" value="yes"> 
					                        </div>
				                         </div>
                				</div>
                				</div>
							 </form>
              </div>                  				
    </div>
    
                            	  </div>
                                         
                    
</div> 
</div>
<% } %>

</div>
</div>

</section>
        <script src="js/main.js"></script>

</body>
</html>