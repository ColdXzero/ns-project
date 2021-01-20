package Controller;

import java.util.ArrayList;

import model.NotTemplate;

public class C_Template extends C_Main  {

	public  NotTemplate create_template(NotTemplate t)
	{
		if (t==null)
			return null;
		else
		{
			
			int id=insert(t);
			t.ID=id;
			if(id<=0)
				return null;
			else 
				return t;
			
		}
	}
	
	public  NotTemplate update_template(NotTemplate t)
	{
		if (t==null)
			return null;
		else
		{
			
			boolean b=update(t,"id="+t.ID);
			if (b==false)
				return null;
			else
			return t;
			
		}
	}

	public int insert (NotTemplate t)
	{
		return super.insert(t);
	}

	public Boolean update (NotTemplate t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(NotTemplate.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(NotTemplate.class, id);
	}
	
	public  boolean delete (NotTemplate t)
	{
		return super.delete(t);
	}

	public  int updateWhere (NotTemplate t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public NotTemplate GetByID(int id)
	{
		return super.GetByID(NotTemplate.class, id);
	}

	public  ArrayList<NotTemplate> GetAll(String where)
	{
		return super.GetAll(NotTemplate.class, where);
	}
	
}
