package api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Controller.C_Group;
import Controller.C_Notification;
import Controller.C_User;
import Controller.C_User_Contacts;
import Group_Management.Group_manage;
import Group_Management.View_group;
import Notification_Management.Notification_manage;
import Notification_Management.Response_manage;
import Template_management.Template_manage;
import UserManagement.ManageUsers;
import model.NotTemplate;
import model.Ns_Group;
import model.Ns_Notification;
import model.Ns_Response;
import model.Ns_User;
import model.Ns_User_Contacts;

@Path ("/templates")
public class TemplateAPI {
	
	@GET
	@Path("/MyTemplates/{Token}")
	@Produces (MediaType.APPLICATION_XML)
	public ArrayList<NotTemplate> ShowMyTemplates(@PathParam("Token") String token)
	{
		Ns_User user = ManageUsers.GetUserByKey(token);
		return Template_manage.GetTemplatesByUserID(user);
		
	}
	
	@GET
	@Path("/MyTemplates/{Token}/{id}")
	@Produces (MediaType.APPLICATION_XML)
	public NotTemplate ShowMyTemplate(@PathParam("Token") String token,@PathParam("id") int id)
	{
		NotTemplate res = new NotTemplate();
		Ns_User user = ManageUsers.GetUserByKey(token);
		ArrayList<NotTemplate>list= Template_manage.GetTemplatesByUserID(user);
		for (NotTemplate x : list) {
			if(x.ID==id) res=x;
		}
		return res;
	}
	

	
	
	
	@GET
	@Path("/MyTemplates/Response/{Token}/{id}/{q}")
	@Produces (MediaType.TEXT_PLAIN)
	public String ResponseNotification(@PathParam("Token") String token,@PathParam("id") String code,@PathParam("q") String q)
	{
		Ns_User ClientUser = ManageUsers.GetUserByKey(token);
		
		if(ClientUser.ID<=0)
			return "Access Denied!";
		else
		{
			//q= email:Test@gmail.com
			//q= phone:0123456
			Date response_date = new Date();
			ArrayList<Ns_Notification> nots = new C_Notification().GetAll("code='"+code+"'");
			Ns_User_Contacts contact= new Ns_User_Contacts();
			
			q=q.substring(q.indexOf(':'),q.length());
			
			boolean found=false;
			Ns_Notification not= new Ns_Notification();
			for(Ns_Notification n :nots)
			{
				contact=new C_User_Contacts().GetByID(n.SendWay);
				if(contact.Contact_Val.equals(q))
				{
					found=true;
					not=n;
					break;
				}
			}
			
			if(found){
				Response_manage.add_response(not, ClientUser, response_date);
					return "done!";
							
			}
		}
		return "failed!";
	}
	
	@GET
	@Path("/Send/{Token}/{id}/{q}")
	@Produces (MediaType.TEXT_PLAIN)
	public String SendNotification(@PathParam("Token") String token,@PathParam("id") int id,@PathParam("q") String q)
	{
		Ns_User SenderUser = ManageUsers.GetUserByKey(token);
		ArrayList<NotTemplate>list= Template_manage.GetTemplatesByUserID(SenderUser);
		NotTemplate template= new NotTemplate();
		for (NotTemplate x : list) {
			if(x.ID==id) template=x;
		}
		
		if(template.ID<=0)
			return "Access Denied!";
		else
		{
		
		
		/// q= contacts:username1,group1;fields:company,name;priority:1;
		
		String [] pars= q.split("&");
		
		ArrayList<Ns_User> contacts_user = new ArrayList<Ns_User>();
		ArrayList<Ns_Group> groups = new ArrayList<Ns_Group>() ;
		Date SendDate = new Date();
		String NotFields="#";
		int priority=0;
		ArrayList<Ns_Notification> nots= new ArrayList<Ns_Notification>();
		for (String p : pars) {
			if(p.startsWith("priority:"))
			{
				p=p.substring(p.indexOf(':')+1, p.length());
				priority=Integer.parseInt(p);
			}
			if(p.startsWith("fields:"))
			{
				p=p.substring(p.indexOf(':')+1, p.length());
				String [] fields_value= p.split(",");
				String [] fields_name= template.T_Fields.split("#");
				if(fields_value.length!= fields_name.length-1)
				{
					return "error in fields!";
				}
				NotFields=p.replace(',', '#');
			}
			
		
			if(p.startsWith("contacts:"))
			{
				p=p.substring(p.indexOf(':')+1, p.length());
				String [] contacts= p.split(",");
				String where="";
				for (String c : contacts) {
				 where += "'"+c.toUpperCase()+"',";
				}
				where =where.substring(0, where.length()-1);
				contacts_user= new C_User().GetAll("user_name in ("+where+")"); 
			groups=new C_Group().GetAll("upper(name) in ("+where+")");	
			}
			
		}
	
			String Code=UUID.randomUUID().toString().replace("-","");
			for(Ns_User u:contacts_user)
			{
				Ns_Notification not = new Ns_Notification();
				not.Code=Code;
				not.SendDate=SendDate;
				not.NotFields=NotFields;
				not.RecievedUser=u;
				not.RecieverID=u.ID;
				not.SenderUser=SenderUser;
				not.SenderID=SenderUser.ID;
				not.priority=priority;
				int min=99999;
				int minid=0;
				for(Ns_User_Contacts co :u.Contacts)
				{
					if (co.OrderId<min)
					{minid=co.ID;
						min=co.OrderId;
					}
				}
				not.SendWay=minid;
				nots.add(not);
				Notification_manage.add_notification(template, SenderUser, not.RecievedUser, null, SendDate, minid, null, NotFields, Code,not.priority);

			}
			
			
			for(Ns_Group g:groups)
			{
				Ns_Notification not = new Ns_Notification();
				not.Code=Code;
				not.SendDate=SendDate;
				not.NotFields=NotFields;
				not.RecievedGroup=g;
				not.RecieverGroupID=g.ID;
				not.SenderUser=SenderUser;
				not.SenderID=SenderUser.ID;
				not.priority=priority;

				int min=99999;
				int minid=0;
				ArrayList<Ns_User> group_users = View_group.view_active_members_of_group(g);
				if(group_users!=null){
				for(Ns_User u: group_users){
					not.RecievedUser=u;
					not.RecieverID=u.ID;
				for(Ns_User_Contacts co :u.Contacts)
				{
					if (co.OrderId<min)
					{minid=co.ID;
						min=co.OrderId;
					}
				}
				}
				not.SendWay=minid;
				nots.add(not);
				Notification_manage.add_notification(template, SenderUser, not.RecievedUser, g, SendDate, minid, null, NotFields, Code,not.priority);
				}
			}
		return "Done";
		}
	}
	
	

}
