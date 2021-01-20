package Controller;

import java.util.ArrayList;

import model.Ns_Notification;
import model.Ns_Response;
import model.Ns_Response;

public class C_response extends C_Main {

	public int insert (Ns_Response t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Response t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Response.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Response.class, id);
	}
	
	public  boolean delete (Ns_Response t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Response t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_Response GetByID(int id)
	{
		return super.GetByID(Ns_Response.class, id);
	}

	public  ArrayList<Ns_Response> GetAll(String where)
	{
		return super.GetAll(Ns_Response.class, where);
	}
	
	public  Ns_Response create_Response(Ns_Response r)
	{
		if (r==null)
			return null;
		else
		{
			
			int id=insert(r);
			r.ID=id;
			if(id<=0)
				return null;
			else 
				return r;
			
		}
	}
	

}
