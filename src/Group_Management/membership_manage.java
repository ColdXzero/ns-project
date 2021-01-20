package Group_Management;

import java.util.ArrayList;

import model.*;
import Controller.*;


public class membership_manage {
	
	public static String pending_join_status= "PENDING_APPROVE";
	public static String join= "TRUE";
	public static String notjoin= "FALSE";



	public static String Request_join_to_Group(Ns_Group group,Ns_User user)
	{
		if (group==null || user== null)	
		return null;
		else
		{
	    	C_MemberShip member= new C_MemberShip();
	     	ArrayList<Ns_MemberShip> mems=new C_MemberShip().GetByUserIDGroupID(user.ID, group.ID);
	    if(mems==null||mems.size()==0) {
	     	Ns_MemberShip requestmember= member.request_membership(group.ID, user.ID ,pending_join_status );
		
	     	if (requestmember==null)
				return null;
			else
				return pending_join_status;
			
		}
	    else
	    {
	    	if(mems.get(0).Status.equals(join)) return null;
	    	
     		member.update_status_membership(group.ID, user.ID, pending_join_status) ; return pending_join_status;
     	}
	
	    }
		
	}
	
	public static String unsubscripe_from_Group(Ns_Group group,Ns_User user)
	{
		if (group==null || user== null)	
		return null;
		else
		{
	    	C_MemberShip member= new C_MemberShip();
			Ns_MemberShip requestmember= member.update_status_membership(group.ID, user.ID ,notjoin );
			if (requestmember==null)
				return null;
			else
				return notjoin;
			
		}
	}
	
	public static Ns_MemberShip Adminstration_user_to_Group(Ns_Group group,Ns_User user, String status)
	{
		if (group==null || user== null)	
		return null;
		else
		{
			// in this cases the statuses are "TRUE" for Approve to join from Admin or add user by Admin directly
			//                            or  "FALSE" for reject 
			
			C_MemberShip member= new C_MemberShip();
			Ns_MemberShip requestmember= member.adminstration_membership(group.ID, user.ID ,status );
			if (requestmember==null)
				return null;
			else
				return requestmember;
			
		}
	}
	
	public static ArrayList<Ns_MemberShip> Approve_all_request_to_Group(Ns_Group group)
	{
		if (group==null)	
		return null;
		else
		{
			ArrayList<Ns_MemberShip> list_member=new ArrayList<Ns_MemberShip>();
			
			ArrayList<Ns_User> list_user=View_group.view_pending_members_of_group(group);
			
			if (list_user==null || list_user.size()==0)
			{
					return null;
	    	}
			else
			{
				list_user.forEach(user -> {
					C_MemberShip member= new C_MemberShip();
					Ns_MemberShip joinmember= member.adminstration_membership(group.ID, user.ID ,join );
					
					list_member.add(joinmember);
		        });
				
				return list_member;
				
			}
			
						
		}
	}

	
	
}
