package Group_Management;

import java.util.ArrayList;

import model.*;
import Controller.*;

public class View_group {
	
	public static String pending_join_status= "PENDING_APPROVE";
	public static String join= "TRUE";
	public static String notjoin= "FALSE";


	public static ArrayList<Ns_User> view_active_members_of_group (Ns_Group g)
	{
		if (g ==null)
			return null;
		
		else		
		{
			C_MemberShip cm=new C_MemberShip();
			ArrayList<Ns_MemberShip> list_members =cm.GetAll("group_id= "+ g.ID +" and status='"+join+"'") ;
			if (list_members==null || list_members.size()==0)
			{
					return null;
	    	}
			else
			{
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				list_members.forEach(member -> {
					C_User cu=new C_User();
					list_user.add(cu.GetByID(member.UserID));
		        });
				
				return list_user;
				
			}
	
		
		}
		
	}
	
	public static ArrayList<Ns_User> view_pending_members_of_group (Ns_Group g)
	{
		if (g ==null)
			return null;
		
		else		
		{
			C_MemberShip cm=new C_MemberShip();
			ArrayList<Ns_MemberShip> list_members =cm.GetAll("group_id= "+ g.ID +" and status='"+pending_join_status+"'") ;
			if (list_members==null || list_members.size()==0)
			{
					return null;
	    	}
			else
			{
				ArrayList<Ns_User> list_user=new ArrayList<Ns_User>();
				list_members.forEach(member -> {
					C_User cu=new C_User();
					list_user.add(cu.GetByID(member.UserID));
		        });
				
				return list_user;
				
			}
	
		
		}
		
	}
	
	public static ArrayList<Ns_MemberShip> view_pending_membership ()
	{
		
			C_MemberShip cm=new C_MemberShip();
			ArrayList<Ns_MemberShip> list_members =cm.GetAll("status='"+pending_join_status+"'") ;
			if (list_members==null || list_members.size()==0)
			{
					return null;
	    	}
			else
			{
							
				return list_members;
				
			}
		
		
		
	}
	
	public static ArrayList<Ns_Group> view_active_group()
	{
		
		C_Group cg=new C_Group();
		ArrayList<Ns_Group> list_group= cg.GetAll("status ='"+join+"'");
		if (list_group == null)
			return null;
		else
			return list_group;
		
	}
	
	public static ArrayList<Ns_Group> view_group_of_specific_owner(Ns_User owner)
	{
		if (owner==null)
			return null;
		else
		{
		C_Group cg=new C_Group();
		ArrayList<Ns_Group> list_group= cg.GetAll("OwnerID ="+owner.ID);
		if (list_group == null)
			return null;
		else
			return list_group;
		}
		
	}
	
	
	

	
}
