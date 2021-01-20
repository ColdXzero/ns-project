package Notification_Management;

import model.*;
import Controller.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.*;



public class send_notification {
	
	
	public static ArrayList<Ns_Notification> cashe_priority_notifications = new ArrayList<Ns_Notification>();
	public static ArrayList<Ns_Notification> priority_notifications = new ArrayList<Ns_Notification>();
	public static ArrayList<Ns_Notification> scheduled_notifications = new ArrayList<Ns_Notification>();

	public static void load_cashe_priority_notifications()
    {
		cashe_priority_notifications = new ArrayList<Ns_Notification>();
		ArrayList<Ns_Notification> top_notifications = new ArrayList<Ns_Notification>();
		C_Notification cn=new C_Notification();
		
		top_notifications= cn.GetAll(" priority <> -1 and priority= (select max(priority) from ns_notification) and status = 1 ");
			
		cashe_priority_notifications= new ArrayList<Ns_Notification>(top_notifications);
					
    }
	
   public static void load_scheduled_notifications()
    {
		C_Notification cn=new C_Notification();
		scheduled_notifications= cn.GetAll("priority= -1 and status = 1 ");			
    }
   
   public static void send_priority_notifications()
   {
	   
	   priority_notifications= new ArrayList<Ns_Notification>(cashe_priority_notifications);
	  //ÊÚÏíá
	  //
	   
	   for (Ns_Notification ca :priority_notifications){
	   
		   
			C_Notification cnn=new C_Notification();
			ca.status=2;
        	cnn.update(ca, " ID="+ca.ID);

	       	
		   }
	   
	  load_cashe_priority_notifications();
	  
	 // priority_notifications.forEach(not -> {;
		  for (Ns_Notification not:priority_notifications){
		                C_User_Contacts cuc=new C_User_Contacts();
		                Ns_User_Contacts Uc=cuc.GetByID(not.SendWay);
		                
		                C_Template ct=new C_Template();
		                NotTemplate tnot= ct.GetByID(not.TemplateID);
		                
		                String text=Notification_manage.get_text_notification(not);
		                
		                if (Uc != null)
		                    if (Uc.Contact_Type.equals("email"))
		                    {
		                    	
		                    	text += "<a href=http://localhost:8081/NS_Project/service/templates/Response/key="+not.RecievedUser.User_Key+"&ID="+not.ID+"&code="+not.Code+" >Response</a>";
		                    	String s=Mail.sendMail(Uc.Contact_Val, tnot.Tittle, text);
		                      
		                    	if (s.equals("Done dear"))
		                        {
		                        	
		                        	C_Notification cnn=new C_Notification();
		                        	not.status=3;
		                        	Date date = new Date();
		                        	not.SendDate=date;
		                        	cnn.update(not, "ID="+not.ID);
		                        	
		                            priority_notifications.remove(not);
		                        	
		                        }
		                    }
		                   
		                    else 
		                    	if (Uc.Contact_Type.equals("PHONE"))
		                    	{
		                    		String s=SendSMS.sendSms(Uc.Contact_Val, text);
		                    		if (s.equals("Done dear") || s.equals("Done"))
			                        {
			                        	
			                        	C_Notification cnn=new C_Notification();
			                        	not.status=3;
			                        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			                        	Date date = new Date();
			                        	not.SendDate=date;
			                        	cnn.update(not, "ID="+not.ID);
			                            priority_notifications.remove(not);
			                        }
		                    		
		                    	}
			                   
 	                                	
	                                	
	               }
	  
	 
   }
   
   public static void send_scheduled_notifications()
   {
	   
	   load_scheduled_notifications();
	   
	   scheduled_notifications.forEach(sn->{
		   
			C_Notification cnn=new C_Notification();
			sn.status=2;
        	cnn.update(sn, " ID="+sn.ID);
	       	
		   });
	   
	       scheduled_notifications.forEach(snot -> {
           C_User_Contacts cuc=new C_User_Contacts();
           Ns_User_Contacts Uc=cuc.GetByID(snot.SendWay);
           
           C_Template ct=new C_Template();
           NotTemplate tnot= ct.GetByID(snot.TemplateID);
           
           String text=Notification_manage.get_text_notification(snot);
           
           Date current_date=new Date();
           
   		   if((current_date.compareTo(tnot.End_Date)<=0) && (current_date.compareTo(tnot.Start_Date)>=0))
   		   {
   			      long diff = current_date.getTime() - tnot.Start_Date.getTime();
   			      long diffMinutes = diff / (60 * 1000) % 60;
   			      if ((diffMinutes % Integer.parseInt(tnot.Duration)) == 0)
   			      {
   			       
        	         if (Uc != null)
		               if (Uc.Contact_Type.equals("email"))
		               {
	                    	text += "<a href=http://localhost:8081/NS_Project/service/templates/Response/key="+snot.RecievedUser.User_Key+"&ID="+snot.ID+"&code="+snot.Code+" >Response</a>";

		               	String s=Mail.sendMail(Uc.Contact_Val, tnot.Tittle, text);
		                   if (s.equals("Done dear"))
		                   {
		                   	
		                   	C_Notification cnn=new C_Notification();
		                   	Date date = new Date();
		                   	snot.SendDate=date;
		                	cnn.update(snot, " ID="+snot.ID);
		                   	
		                   }
		               }
		              
		               else 
		               	if (Uc.Contact_Type.equals("PHONE"))
		               	{
		               		String s=SendSMS.sendSms(Uc.Contact_Val, text);
		               		if (s.equals("Done dear") || s.equals("Done"))
		                       {
		                       	
		                       	C_Notification cnn=new C_Notification();
		                       	Date date = new Date();
		                    	snot.SendDate=date;
			                	cnn.update(snot, " ID="+snot.ID);
		                       	
		                       }
		               		
		               	}                
   			   }
   		   }       			                       	
		      });
   		
           
	   
   }

}
