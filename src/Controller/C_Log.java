package Controller;


import java.util.ArrayList;

import model.Ns_log;;


public class C_Log extends C_Main{

	
	public  Ns_log create_log(Ns_log l)
	{
		if (l==null)
			return null;
		else
		{
			
			int id=insert(l);
			l.ID=id;
			if(id<=0)
				return null;
			else 
				return l;
			
		}
	}
	
	
	
	public int insert (Ns_log l)
	{
		return super.insert(l);
	}
	
	public Boolean update (Ns_log l,String where)
	{
		return super.update(l, where);
	}
	
	public  boolean delete (String where)
	{
		return super.delete(Ns_log.class, where);
	}
	
	public  boolean delete (Ns_log l)
	{
		return super.delete(l);
	}
	
	public  int updateWhere (Ns_log l,String field,Object obj)
	{
		return super.updateWhere(l, field, obj);
	}

	public Ns_log  GetByID(int id)
	{
		return super.GetByID(Ns_log.class, id);
	}

	public  ArrayList<Ns_log> GetAll(String where)
	{
		return super.GetAll(Ns_log.class, where);
	}

}
