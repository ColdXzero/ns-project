package Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.sun.xml.internal.ws.spi.db.FieldSetter;

import model.*;


public class C_User extends C_Main {

	public int insert (Ns_User t)
	{
		int id=super.insert(t);
		C_User_Contacts control= new C_User_Contacts();
		for (Ns_User_Contacts c : t.Contacts) {
			if(c.User_ID<=0)
			{	c.User_ID=id;
				control.insert(c);
			}
		}
		
		C_Additional_Contacts control2= new C_Additional_Contacts();
		for (Ns_Additional_Contacts c : t.Additional_Contacts) {
			if(c.OwnerId<=0)
			{	c.OwnerId=id;
				control2.insert(c);
			}
		}
		
		return id;
	}

	public Boolean update (Ns_User t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_User.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_User.class, id);
	}
	
	public  boolean delete (Ns_User t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_User t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_User GetByID(int id)
	{
		Ns_User user=super.GetByID(Ns_User.class, id);
		C_User_Contacts c = new C_User_Contacts();
		user.Contacts=c.GetAll(" user_id="+id);
		return user;
	}

	public Ns_User GetByKey(String key )
	{
		ArrayList<Ns_User> users=super.GetAll(Ns_User.class, " user_key='"+key+"'");
		if(users ==null || users.size()==0) return new Ns_User();
		
		Ns_User user= users.get(0);
		C_User_Contacts c = new C_User_Contacts();
		user.Contacts=c.GetAll(" user_id="+user.ID);
		return user;
	}
	public  ArrayList<Ns_User> GetAll(String where)
	{
		ArrayList<Ns_User> users=super.GetAll(Ns_User.class, where);
		C_User_Contacts c = new C_User_Contacts();
	if(users!=null)
		for (Ns_User ns_User : users) {
		ns_User.Contacts=c.GetAll(" user_id="+ns_User.ID);
	}
		return users;
	}
	
	public Ns_User LoadAdditional(Ns_User u){

		C_Additional_Contacts ca = new C_Additional_Contacts();
		u.Additional_Contacts=ca.GetAll(" owner_id= "+u.ID);
		return u;
	}

	public Ns_User Login(String n,String p)
	{
		ArrayList<Ns_User> list=GetAll(" user_name=\""+n+"\" and user_password=\""+p+"\"");
		if (list==null || list.size()==0)
			return null;
		else return list.get(0);
	}
}
