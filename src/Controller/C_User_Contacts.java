package Controller;

import java.util.ArrayList;

import model.Ns_User_Contacts;

public class C_User_Contacts extends C_Main {
	
	public int insert (Ns_User_Contacts t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_User_Contacts t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_User_Contacts.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_User_Contacts.class, id);
	}
	
	public  boolean delete (Ns_User_Contacts t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_User_Contacts t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_User_Contacts GetByID(int id)
	{
		return super.GetByID(Ns_User_Contacts.class, id);
	}

	public  ArrayList<Ns_User_Contacts> GetAll(String where)
	{
		return super.GetAll(Ns_User_Contacts.class, where);
	}


}
