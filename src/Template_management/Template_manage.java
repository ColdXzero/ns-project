package Template_management;

import model.*;
import Controller.*;

import java.util.ArrayList;
import java.util.Date;

public class Template_manage {

	
	public static NotTemplate Add_template(String title,Ns_User owner, String field, String text,Date start_date,Date end_date, String send_way,String esc, String duration)
	{
		C_Template ct=new C_Template();
		if (title==null ||start_date==null )
		{
			return null;
		}
		else
		{
			int ownerid=0;
			if (owner!=null)
				ownerid=owner.ID;
			if (esc==null)
				esc="0";
			
			NotTemplate t=new NotTemplate();
			t.Tittle=title;
			t.Duration=duration;
			t.Owner=ownerid;
			t.Escalation=esc;
			t.Send_Way=send_way;
			t.T_Fields=field;
			t.T_TEXT=text;
			t.Start_Date=start_date;
			t.End_Date=end_date;
			NotTemplate newt=ct.create_template(t);
			return newt;
		}
	}
	
	
	public static NotTemplate update_template(NotTemplate t, String title,Ns_User owner, String field, String text,Date start_date,Date end_date, String send_way,String esc, String duration )
	{
		C_Template ct=new C_Template();
		if (t==null ||title==null ||start_date==null )
		{
			return null;
		}
		else
		{
			int ownerid=0;
			if (owner!=null)
				ownerid=owner.ID;
			if (esc==null)
				esc="F";
			

			t.Tittle=title;
			t.Duration=duration;
			t.Owner=ownerid;
			t.Escalation=esc;
			t.Send_Way=send_way;
			t.T_Fields=field;
			t.T_TEXT=text;
			t.Start_Date=start_date;
			t.End_Date=end_date;
			NotTemplate newt=ct.update_template(t);
			return newt;
		}
	}
	

	public static Ns_Template_Privillege grant_priviege_template(NotTemplate t, Ns_User user)
	{
		C_Template_Priv ct=new C_Template_Priv();
		if (t==null ||user==null )
		{
			return null;
		}
		else
		{
			Ns_Template_Privillege ntp=ct.grant_privilage(t,user);
			return ntp;
			
		}
	}
	
	public static Ns_Template_Privillege revoke_priviege_template(NotTemplate t, Ns_User user)
	{
		C_Template_Priv ct=new C_Template_Priv();
		if (t==null ||user==null )
		{
			return null;
		}
		else
		{
			Ns_Template_Privillege ntp=ct.revoke_privilage(t,user);
			return ntp;
			
		}
	}

	// view all templates those have a specific owner
	public static ArrayList<NotTemplate> view_templates_for_owner(Ns_User user)
	{
		C_Template ct=new C_Template();
		if (user==null)
			return null;
		else 
			return ct.GetAll("Owner="+user.ID);
		
	}
	
	// view all templates those are active currently
	public static ArrayList<NotTemplate> view_active_templates()
	{
		C_Template ct=new C_Template();
		return ct.GetAll(" CURDATE() between Start_Date and End_Date");
		
	}
	
	public  static ArrayList<NotTemplate> GetTemplatesByUserID(Ns_User u)
	{
		ArrayList<NotTemplate> res = new ArrayList<NotTemplate>();
		C_Template_Priv ctp = new C_Template_Priv();
		C_Template ct=new C_Template();
		ArrayList<Ns_Template_Privillege> list= ctp.GetByUserID(u.ID);
		if(list != null)
		{
			for (Ns_Template_Privillege x : list) {
				res.add(ct.GetByID(x.TemplateID));
			}
		}
		
		return res;
	}
	
	
	// view users have ***active*** privilege on specific template
	public static ArrayList<Ns_User>  view_users_have_privi(NotTemplate t)
	{
		if (t==null)
		return null;
		else
		{
			C_Template_Priv ctp=new C_Template_Priv();
			ArrayList<Ns_Template_Privillege> list_priv=ctp.GetAll("template_id="+t.ID+ " and status = 'TRUE'");
			if (list_priv==null || list_priv.size()==0)
			{							
				return null;
							
			}
			else  		
			
			{
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				list_priv.forEach(priv -> {
					C_User cu=new C_User();
					list_user.add(cu.GetByID(priv.UserID));
		        });
				
				return list_user;
				
			}
			
		}
		
	}
	
	
	// view all ***active*** privilege  for specific user
	public  static ArrayList<NotTemplate>  view_active_privi_for_user(Ns_User u)
	{
		if (u==null)
		return null;
		else
		{
			C_Template_Priv ctp=new C_Template_Priv();
			ArrayList<Ns_Template_Privillege> list_priv=ctp.GetAll("user_id="+u.ID +" and  status = 'TRUE'");
			if (list_priv==null || list_priv.size()==0)
			{							
				return null;
							
			}
			else  		
			
			{
				ArrayList<NotTemplate> list_template=new ArrayList<NotTemplate>();
				list_priv.forEach(priv -> {
					C_Template ct=new C_Template();
					list_template.add(ct.GetByID(priv.TemplateID));
		        });
				
				return list_template;
				
			}
			
		}
		
	}
	
	
	// view status of privilege that is for specific user on  specific template
	public static  String  view_status_privilage(Ns_User u, NotTemplate t)
	{
		if (u==null || t==null)
		return null;
		else
		{
			C_Template_Priv ctp=new C_Template_Priv();
			ArrayList<Ns_Template_Privillege> list=ctp.GetAll(" user_id="+u.ID+" and template_id="+t.ID);
			
			if (list==null || list.size()==0)
			{
								
					return null;
													
			}
			
			
			else  		
			
			{
				return list.get(0).Status;
				
			}
			
		}
		
	}

}
