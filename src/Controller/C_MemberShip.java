package Controller;

import java.util.ArrayList;

import model.Ns_MemberShip;

public class C_MemberShip extends C_Main {

	public Ns_MemberShip request_membership(int group_id,int user_id, String status)
	{
		Ns_MemberShip member = new Ns_MemberShip();
		member.Status=status;
		member.UserID=user_id;
		member.GroupID= group_id;
		int id=insert(member);
		member.ID=id;
		if (id<= 0)
			return null;
		else
		    return member;
	}
	
	public Ns_MemberShip update_status_membership(int group_id,int user_id, String status)
	{
		String where="group_id="+group_id+ " and user_id="+ user_id;
		ArrayList<Ns_MemberShip> mem= GetAll(where);
		if (mem==null || mem.size()==0)
		{
				return null;
    	}
		else
		{
			Ns_MemberShip member = mem.get(0);
			member.Status=status;
			boolean b= update(member,"ID="+member.ID);
			if (b==false)
				return null;
			else
				return member;
			
		}
		
	}
	
	public Ns_MemberShip adminstration_membership(int group_id,int user_id, String status)
	{
		// in this cases the statuses are "TRUE" for Approve to join from Admin or add user by Admin directly
		//                            or  "FALSE" for reject 
		String where="group_id="+group_id+ " and user_id="+ user_id;
		ArrayList<Ns_MemberShip> mem= GetAll(where);
		if (mem==null || mem.size()==0)
		{
			Ns_MemberShip member=request_membership(group_id,user_id,status);
			
			if (member== null)
				return null;
			else
			    return member;			
		}
		else
		{
			Ns_MemberShip member = mem.get(0);
			member=update_status_membership(member.GroupID,member.UserID,status);
			return member;
			
		}
		
	}

	public int insert (Ns_MemberShip t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_MemberShip t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_MemberShip.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_MemberShip.class, id);
	}
	
	public  boolean delete (Ns_MemberShip t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_MemberShip t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_MemberShip GetByID(int id)
	{
		return super.GetByID(Ns_MemberShip.class, id);
	}
	
	public ArrayList<Ns_MemberShip> GetByUserID(int id)
	{
		return super.GetAll(Ns_MemberShip.class," user_id ="+id);
	}
	
	public ArrayList<Ns_MemberShip> GetByUserIDGroupID(int uid,int gid)
	{
		return super.GetAll(Ns_MemberShip.class," user_id ="+uid+" and group_id="+gid);
	}
	public ArrayList<Ns_MemberShip> GetByGroupID(int id)
	{
		return super.GetAll(Ns_MemberShip.class," group_id ="+id);
	}

	public  ArrayList<Ns_MemberShip> GetAll(String where)
	{
		return super.GetAll(Ns_MemberShip.class, where);
	}

}
