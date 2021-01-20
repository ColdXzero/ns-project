package Notification_Management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.*;
import Controller.*;
import Group_Management.View_group;

public class Notification_manage {


	
	public static ArrayList<Ns_Notification> view_notifications_to_user(Ns_User user)
	{
		C_Notification cn=new C_Notification();
		if (user==null)
			return null;
		else
		{
			return cn.GetAll("reciever_id="+user.ID);
		}
		
	}
	
	public static ArrayList<Ns_Notification> view_notifications_to_group(Ns_Group g)
	{
		C_Notification cn=new C_Notification();
		if (g==null)
			return null;
		else
		{
			return cn.GetAll("reciever_group_id="+g.ID);
			
			
		}
		
	}
	
	public static ArrayList<Ns_Notification> view_notifications_from_user(Ns_User user)
	{
		C_Notification cn=new C_Notification();
		if (user==null)
			return null;
		else
		{
			return cn.GetAll("sender_id="+user.ID);
			
			
		}
		
	}
	
	public static ArrayList<Ns_Notification> view_notifications_in_date (Date  date1,Date date2)
	{
		C_Notification cn=new C_Notification();
		if (date1==null && date2==null)
			return null;
		else
		{
			SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if(date2==null)
			return cn.GetAll("DATE(send_date) = \""+ft.format(date1)+"\"");
			else
				return cn.GetAll("DATE(send_date) >= \""+ft.format(date1)+"\" and DATE(send_date)<=\""+ft.format(date2)+"\"");

			
			
		}
		
	}
	
	public static ArrayList<Ns_User> view_recievers_of_notification(Ns_Notification not)
	{
		C_Notification cn=new C_Notification();
		if (not==null)
			return null;
		else
		{
			ArrayList<Ns_Notification> list_notification= cn.GetAll("code='"+not.Code+"'");
			if (list_notification==null || list_notification.size()==0)
			{							
				return null;
							
			}
			else  		
			
			{
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				list_notification.forEach(notification -> {
					
					C_User cu=new C_User();
					C_Group cg =new C_Group();
					
					if (cu.GetByID(notification.RecieverID) != null )
					{
						list_user.add(cu.GetByID(notification.RecieverID));
						
					}
					
					else
					{
						
						if (cg.GetByID(notification.RecieverGroupID) != null)
						{
							ArrayList<Ns_User> list_member= View_group.view_active_members_of_group(cg.GetByID(notification.RecieverGroupID));
							list_member.forEach(mem-> {
								list_user.add(mem);
							 });
						}
						else 
							list_user.add(null);
					}
		        });
				
				return list_user;
				
			}
			
			
		}
		
	}
	
	public static Ns_Notification view_specific_notifications(int ID)
	{
		C_Notification cn=new C_Notification();
		if (ID<=0 )
			return null;
		else
		{
			return cn.GetByID(ID);
		}
	}
	
	public static ArrayList<Ns_User> view_recievers_of_notification_id(Ns_Notification not)
	{
		if (not==null)
			return null;
		else
		{
			
		
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				
					C_User cu=new C_User();
					C_Group cg =new C_Group();
					
					if (cu.GetByID(not.RecieverID) != null )
					{
						list_user.add(cu.GetByID(not.RecieverID));
						
					}
					
					else
					{
						
						if (cg.GetByID(not.RecieverGroupID) != null)
						{
							ArrayList<Ns_User> list_member= View_group.view_active_members_of_group(cg.GetByID(not.RecieverGroupID));
							list_member.forEach(mem-> {
								list_user.add(mem);
							 });
						}
						else 
							list_user.add(null);
					}
		       
				
				return list_user;
				
			
			
			
		}
		
	}
	
	
	public static ArrayList<Ns_Response> view_responses_per_notification (Ns_Notification not)
	{
		C_response cr=new C_response();
		if (not==null)
			return null;
		else
		{
			return cr.GetAll("Not_ID="+not.ID);
			
			
		}
		
	}
	
	public static ArrayList<Ns_User> view_responsers_per_notification (Ns_Notification not)
	{
		C_response cr=new C_response();
		if (not==null)
			return null;
		else
		{
			ArrayList<Ns_Response> list_responses=cr.GetAll("Not_ID="+not.ID);
			if (list_responses==null || list_responses.size()==0)
			{							
				return null;
							
			}
			else
			{
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				C_User cu=new C_User();
				list_responses.forEach(res-> {
					list_user.add(cu.GetByID(res.User_ID));
				 });
				
				return list_user;
			}
			 
			
			
		}
		
	}
	
	public static ArrayList<Ns_User> view_receivers_dont_response_notification(Ns_Notification not)
	{
		if (not==null)
			return null;
		else
		{
			ArrayList<Ns_User> list_recievers=view_recievers_of_notification(not);
			ArrayList<Ns_User> list_responser=view_responsers_per_notification(not);
			
			if (list_recievers==null || list_recievers.size()==0)
			{							
				return null;
							
			}
			else
			{
				if(list_responser==null || list_responser.size()==0)
				{
					return list_recievers;
				}
				else
				{
					ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
					list_recievers.forEach(rec-> {
						
						if (!list_responser.contains(rec))
							list_user.add(rec);
					 });
					
					return list_user;	
					
				}
				
				
			}
			 
			
			
		}
		
	}
	
	public static ArrayList<Ns_Response> view_responses_from_user (Ns_User user)
	{
		C_response cr=new C_response();
		if (user==null)
			return null;
		else
		{
			return cr.GetAll("user_id="+user.ID);
			
			
		}
		
	}
	
	public static String get_text_notification(Ns_Notification not)
	{
		if (not==null)
			return null;
		else 
		{
		     ArrayList<String> resultList = new ArrayList<String>();
		    
			 C_Template ct=new C_Template();
             NotTemplate tnot= ct.GetByID(not.TemplateID);
             
             String[] splitstext = tnot.T_TEXT.split("#");
             String[] splitsnotfield = not.NotFields.split(",");

                       
             for(String s: splitstext)
            	 {       
            	
            		 resultList.add(s);
            		 
            	 }
             
             int n1=1;
             for(String s: splitsnotfield)
         	 {           
            	 try{
         		 resultList.set(n1,s);}
            	 catch(Exception er){}
         		 n1=n1+2;
         	 }		 
            
             String merge_result = "";

             for (String s : resultList)
             {
            	 merge_result += s + " ";
             }
             if(merge_result.length()>0)
             return merge_result;
             else
            	 return tnot.T_TEXT;
			
		}
		
		
	}
	public static Ns_Notification add_notification(NotTemplate template ,Ns_User sender, Ns_User reciever, Ns_Group reciever_group,Date send_date,int send_way, String Escalation, String NotFields,String Code,int priority)
	{
		C_Notification ct=new C_Notification();
		if (template==null ||sender==null || (reciever==null && reciever_group==null) || NotFields==null || Code==null )
		{
			return null;
		}
		else
		{
			
			Ns_Notification notification=new Ns_Notification();
			notification.TemplateID=template.ID;
			notification.SenderID=sender.ID;
			if(reciever!=null)notification.RecieverID=reciever.ID;
			else notification.RecieverID=null;
			if(reciever_group!=null)notification.RecieverGroupID=reciever_group.ID;
			else
				notification.RecieverGroupID=null;
			notification.SendDate=send_date;
			notification.SendWay=send_way;			
			notification.Code=Code;
			notification.Escalation=Escalation;
			notification.NotFields=NotFields;
			

			C_Template ctemplete=new C_Template();
			ArrayList<NotTemplate> list_t=ctemplete.GetAll(" duration is not null");
			
			 boolean ans = list_t.contains(template); 
			 
			if  (ans==true)
				notification.priority = -1; // scheduled notifications
			else
				notification.priority = priority;
			
			notification.status= 1; // wait
			
			Ns_Notification new_notification= ct.create_Notification(notification);
			
			return new_notification;
		}
	}
	
}
