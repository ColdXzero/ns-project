<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Controller.C_User"%>
<%@page import="Controller.C_User_Contacts"%>
<%@page import="model.Ns_User_Contacts"%>
<%@page import="javax.enterprise.inject.Model"%>
<%@page import="model.Ns_User"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<% Ns_User u=((Ns_User)session.getAttribute("user"));
u=new C_User().GetByID(u.ID);

 ArrayList<Ns_User_Contacts> cons = u.Contacts;
 %>
   <section id="contact_form">
            <div class="container">
                <div class="row">
                <div class=form-group style="text-align: center;">
                <h2>Your Contacts</h2></div>
                    <form role="form" class="form-inline text-right col-md-12"  >
 						<table cellspacing="4" style="text-align: center;">
 						<tr>
 						<th>
 						 <div class="form-group">
                       	<h6> Contact Value</h6>
                        </div>
                        </th>
                        						<th>
 						 <div class="form-group">
                       	<h6> Contact Type</h6>
                        </div>
                       </th>

						<th>
 						 <div class="form-group">
                       	<h6> Contact Status</h6>
                        </div>
                       </th>
 						 						<th>
 						 <div class="form-group">
                       	<h6> Contact Order</h6>
                        </div>
                       </th>
 											<th>
 						 <div class="form-group">
                        </div>
                       </th>
 						
 						</tr>
 						<% for (Ns_User_Contacts c : cons){ %>
                            <tr><td><p><%= c.Contact_Val %></p></td>
                            
                            <td><p ><%= c.Contact_Type %></p></td>
                            
                            <td>
                                  <select id="contact_status<%=c.ID %>" class="form-control" style="width: 100%" >
                                                <option value="TRUE" <%=  c.Status.equals("TRUE")?"selected="+"\"selected\"":"" %>>Live</option>
                                                <option value="FALSE" <%= c.Status.equals("FALSE")?"selected="+"\"selected\"":"" %>>Pending</option>
                                                 
                        </select></td>
                           <td>
                           <div class="form-group">
                         <input type="text" class="form-control" style="width:50%;" id="v_order<%=c.ID %>" placeholder="Order" value=<%=c.OrderId %>></td>
                        </div>
                        <td>
                        <div class="popup" >

                            	  <span class="popuptext" id="myPopup2" style="width: 100px;" onclick="hide2();" >
</span>
                        <button type="submit" style="width:100%;"  class="btn submit_btn" id="btn_change_order" onclick="{document.getElementById('hid_order_id').setAttribute('value', '<%=c.ID%>'); clickchange();}">Change Order</button>
                 			</td></tr>
                 			<%} %>
                     <input type="hidden" name="" id="hid_order_id">
                    </table>
                    </form>		
                    
                    <div class="popup" ><button  class="btn submit_btn" onclick="ShowPop()">+</button>

                            	  <span class="popuptext" id="myPopup" style="width: 1000px;">
                            	 
                   <div class=form-group style="text-align: center;">
                <h2>Add New Contact</h2>
                </div>
                    <form role="form" class="form-inline text-right col-md-12" >
 						<table cellspacing="4" style="text-align: center;">
 						<tr>
 						<th>
 						 <div class="form-group" >
                       	<h5> Contact Value</h5>
                        </div>
                        </th>
                        						<th>
 						 <div class="form-group">
                       	<h5> Contact Type</h5>
                        </div>
                       </th>

						<th>
 						 <div class="form-group">
                       	<h5> Contact Status</h5>
                        </div>
                       </th>
 						 						<th>
 						 <div class="form-group">
                       	<h5> Contact Order</h5>
                        </div>
                       </th>
 						
 						</tr>

<tr>
                           <td>
                           <div class="form-group">
                         <input type="text" class="form-control" style="width:70%;" id="contact_val_new" placeholder="Value" >
                        </div>
                        </td>
                        
                        

                           <td>
                           <div class="form-group">
                                          <select id="contact_type_new" class="form-control  " style="width: 100%">
                                                <option value="mail">Mail</option>
                                                <option value="phone">Phone</option>
                                                <option value="ip">IP</option>
                        
                        </select>
     </div>
</td>
                <td>
                            <div class="form-group">
                                          <select id="contact_status_new" class="form-control" style="width: 100%">
                                                <option value="true">Live</option>
                                                <option value="false">Pending</option>
                                                 
                        </select>
     </div>
           </td>
                        
                           <td>
                           <div class="form-group">
                         <input type="text" class="form-control" style="width:70%;" id="contact_order_new" placeholder="Order" >
                        </div></td>
                <td>
                           <div class="form-group">
                         <button type="submit"  class="btn submit_btn" style="width:100%;" id="contact_order_new" onclick="clickAddContact();" >Add</button>
                        </div></td>
           
</tr>                            	  
                            	  
                            	  </table>
                            	  </form>
                            	  </span>
                            	</div>
</div>
                    
                </div>
            </div>
        </section><!-- Contact form end -->
</body>
</html>