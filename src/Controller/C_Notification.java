package Controller;

import java.util.ArrayList;

import model.NotTemplate;
import model.Ns_Notification;

public class C_Notification extends C_Main {

	public int insert (Ns_Notification t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Notification t,String where)
	{
		if(t.RecievedGroup==null) t.RecieverGroupID=null;

		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Notification.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Notification.class, id);
	}
	
	public  boolean delete (Ns_Notification t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Notification t,String field,Object obj)
	{
		if(t.RecievedGroup==null) t.RecieverGroupID=null;
		return super.updateWhere(t, field, obj);
	}

	public Ns_Notification GetByID(int id)
	{
		Ns_Notification temp= super.GetByID(Ns_Notification.class, id);
		temp.Template=new C_Template().GetByID(temp.TemplateID);
		temp.SenderUser=new C_User().GetByID(temp.SenderID);
		temp.RecievedUser=new C_User().GetByID(temp.RecieverID);
		temp.RecievedGroup=new C_Group().GetByID(temp.RecieverGroupID);
		return temp;
	}

	public  ArrayList<Ns_Notification> GetAll(String where)
	{
		
		ArrayList<Ns_Notification> list=super.GetAll(Ns_Notification.class, where);
		
		for (Ns_Notification temp : list) {
			temp.Template=new C_Template().GetByID(temp.TemplateID);
			temp.SenderUser=new C_User().GetByID(temp.SenderID);
			temp.RecievedUser=new C_User().GetByID(temp.RecieverID);
			temp.RecievedGroup=new C_Group().GetByID(temp.RecieverGroupID);
		}
		
		return list;
	}
	
	public  Ns_Notification create_Notification(Ns_Notification n)
	{
		if (n==null)
			return null;
		else
		{
			
			int id=insert(n);
			n.ID=id;
			if(id<=0)
				return null;
			else 
				return n;
			
		}
	}

	

}
