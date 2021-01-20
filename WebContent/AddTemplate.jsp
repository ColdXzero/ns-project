<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
 <section id="contact_form">
            <div class="container">
              <form role="form"  class="form-inline text-right" action="AddTemplates" method="post">
            
                <div class="row">
                    <div class="col-md-6">
                        <h2>Create New Template</h2>
                         <div class="row">
                        <div class="form-group">
                            <input id="not_title" type="text" class="form-control" name="not_title" placeholder="Insert Title Here!">
                        </div>
                     </div> <div class="row">

                        <div class="form-group">
                            <textarea id="not_txt"  style="width: 100%;height: 100%;"class="form-control" name="not_txt"  placeholder="Insert Text Here!" rows='10' cols='30'></textarea>
                        </div>
                         <div class="row">
                                                <div class="popup" ><button  class="btn"  type="button" onclick="ShowFieldPop()">Add Fields</button>
                                            
						<input type="hidden" id="fieldsnew" name="fieldsnew" > 
                            	  <span class="popuptext" id="FieldsPop" style="width: 350px;">
                            	 
                   <div class=form-group style="text-align: center;">
                <div class="form-group">
                            <input id="not_field_add" type="text" class="form-control"  placeholder="Field Name">
                        </div>
                        <button id="addFieldName" type="button" onclick="addFieldNameFun()" >+</button>
                </div>
                </span>
                
                </div>
                        
                    </div></div>
                    <div class="row" >
                <div class="col-md-6">
                        <button id="AddTemplateBtn" type="submit" class="btn submit_btn" >Finish</button>
                        </div></div>
                    </div>
                    <div class="col-md-6">
                    <h2>Template Properties</h2>
                       
                                        <div class="row">
                        <input id="hid1" type="hidden" name="signin" value="addtemp"> 

                        <div class="form-group col-md-9">
                            <input id="not_start_date" type="datetime-local" class="form-control " name="not_start_date" placeholder="Start Date">
                            
                        </div>
                          </div>
                          
                                                                  <div class="row">
                          
                        <div class="form-group col-md-9">
                            <input id="not_end_date" type="datetime-local" class="form-control" name="not_end_date" placeholder="End Date">
                        </div>
                        </div> 

                         <div class="row ">
                                                 <div class="form-group col-md-6" > <h4>Send Way</h4></div>
                        
                        <select name="SendWay" class="form-control col-md-6 "  style="width:20%">
                        <option  value="email">Email</option>
                                                <option value="sms">SMS</option>
                                                <option value="push">Push Notification</option>
                        
                        </select>
                        </div>
                        

                         <div class="row ">
                                                 <div class="form-group col-md-6" > <h4>Scheduling</h4></div>
                        
                        <input type="text" name="duration" class="form-control col-md-6 "  style="width:20%" placeholder="Minutes">
                        
                        
                        </div> 
                        
                        
                                                              <div class="row">
                        <div class="form-group col-md-7">
                            <input id="not_escal" type="checkbox" class="form-control " name="not_escal" style="width: 10%" value="yes"> Has Escalation
                            
                        </div>
                        
                        
                      </div>
                </div>
                </div>
                
                </div>
             </form> </div>                  				
            
        </section>
  
</body>
</html>