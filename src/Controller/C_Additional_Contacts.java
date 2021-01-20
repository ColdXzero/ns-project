package Controller;

import java.util.ArrayList;

import model.Ns_Additional_Contacts;

public class C_Additional_Contacts extends C_Main {
	
	public int insert (Ns_Additional_Contacts t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Additional_Contacts t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Additional_Contacts.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Additional_Contacts.class, id);
	}
	
	public  boolean delete (Ns_Additional_Contacts t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Additional_Contacts t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_Additional_Contacts GetByID(int id)
	{
		C_Group gr= new C_Group();
		C_User us= new C_User();
		Ns_Additional_Contacts temp=super.GetByID(Ns_Additional_Contacts.class, id);
		temp.add_group=temp.add_group==null ?gr.GetByID(temp.group_id):null;
		temp.add_user=us.GetByID(temp.User_Id);
		return temp;
	}

	public  ArrayList<Ns_Additional_Contacts> GetAll(String where)
	{
		ArrayList<Ns_Additional_Contacts>list= super.GetAll(Ns_Additional_Contacts.class, where);
		for (Ns_Additional_Contacts ns_Additional_Contacts : list) {
			C_Group gr= new C_Group();
			C_User us= new C_User();
			ns_Additional_Contacts.add_group=ns_Additional_Contacts.add_group==null ?gr.GetByID(ns_Additional_Contacts.group_id):null;
			ns_Additional_Contacts.add_user=us.GetByID(ns_Additional_Contacts.User_Id);
		}
		
		return list;
	}
}
