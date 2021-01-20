package Controller;

import java.util.ArrayList;

import model.Ns_Setting;

public class C_Setting extends C_Main {

	public int insert (Ns_Setting t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Setting t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Setting.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Setting.class, id);
	}
	
	public  boolean delete (Ns_Setting t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Setting t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_Setting GetByID(int id)
	{
		return super.GetByID(Ns_Setting.class, id);
	}

	public  ArrayList<Ns_Setting> GetAll(String where)
	{
		return super.GetAll(Ns_Setting.class, where);
	}
	
	public Ns_Setting create_setting(Ns_Setting s)
	{
		if (s==null)
			return null;
		else
		{
			
			int id=insert(s);
			s.ID=id;
			if(id<=0)
				return null;
			else 
				return s;
			
		}
	}
	
	public Ns_Setting update_setting(Ns_Setting s)
	{
		if (s==null)
			return null;
		else
		{		
			
				boolean b= update(s,"ID="+s.ID);
				if (b==false)
					return null;
				else
					return s;
							
		}
	}


}
