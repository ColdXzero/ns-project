package Controller;

import java.util.ArrayList;

import model.Ns_Group;
import model.Ns_MemberShip;
import model.Ns_User;

public class C_Group extends C_Main {


	public int insert (Ns_Group t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Group t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Group.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Group.class, id);
	}
	
	public  boolean delete (Ns_Group t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Group t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_Group GetByID(int id)
	{
		return super.GetByID(Ns_Group.class, id);
	}

	public  ArrayList<Ns_Group> GetAll(String where)
	{
		return super.GetAll(Ns_Group.class, where);
	}
	
	public Ns_Group LoadUsers(Ns_Group ns)
	{
		ArrayList<Ns_MemberShip> mems= new C_MemberShip().GetByGroupID(ns.ID);
		ArrayList<Ns_User> list= new ArrayList<Ns_User>();
		C_User u= new C_User();
		for (Ns_MemberShip i: mems) {
			list.add(u.GetByID(i.UserID));
		}
		ns.users=list;
	return ns;	
	}
	
	public Ns_Group create_group(String group_name,String group_description, int owner_id, String status)
	{
		Ns_Group group=new Ns_Group();
		group.Name=group_name;
		group.Description=group_description;
		group.OwnerID=owner_id;
		group.Status=status;
		
		int id =-1;
		id= insert(group);
		group.ID=id;
		if (id <= 0)
			return null;
		else return group;
	}
	
	public Ns_Group update_group(Ns_Group g)
	{
		if (g==null)
			return null;
		else
		{
			boolean b= update(g,"ID="+g.ID);
			if (b==false)
				return null;
			else
				return g;
			}
	}
	
	
}
