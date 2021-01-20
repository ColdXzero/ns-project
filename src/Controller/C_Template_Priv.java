package Controller;

import java.util.ArrayList;

import model.NotTemplate;
import model.Ns_Template_Privillege;
import model.Ns_User;

public class C_Template_Priv extends C_Main {
	public static String privilage="TRUE";
	public static String nonprivilage="FALSE";

	public int insert (Ns_Template_Privillege t)
	{
		return super.insert(t);
	}

	public Boolean update (Ns_Template_Privillege t,String where)
	{
		return super.update(t, where);
	}

	public  boolean delete (String where)
	{
		return super.delete(Ns_Template_Privillege.class, where);
	}

	public  boolean deleteByID (int id)
	{
		return super.deleteByID(Ns_Template_Privillege.class, id);
	}
	
	public  boolean delete (Ns_Template_Privillege t)
	{
		return super.delete(t);
	}

	public  int updateWhere (Ns_Template_Privillege t,String field,Object obj)
	{
		return super.updateWhere(t, field, obj);
	}

	public Ns_Template_Privillege GetByID(int id)
	{
		return super.GetByID(Ns_Template_Privillege.class, id);
	}

	public  ArrayList<Ns_Template_Privillege> GetAll(String where)
	{
		return super.GetAll(Ns_Template_Privillege.class, where);
	}
	
	public  ArrayList<Ns_Template_Privillege> GetByUserID(int userId)
	{
		return super.GetAll(Ns_Template_Privillege.class, " user_id="+userId);
	}
	
	public  Ns_Template_Privillege grant_privilage(NotTemplate t, Ns_User user)
	{
		if (t==null || user==null)
		return null;
		else
		{
			Ns_Template_Privillege tp=new Ns_Template_Privillege();
			tp.Status=privilage;
			tp.TemplateID=t.ID;
			tp.UserID=user.ID;
			
			ArrayList<Ns_Template_Privillege> list=GetAll(" user_id="+user.ID+" and template_id="+t.ID);
			if (list==null || list.size()==0)
			{
				
				int id =insert(tp);
				if (id<=0)
					return null;
				else
				{
					tp.ID=id;
					return tp;				
				}
			
			}
			else  		
			
			{
				tp.ID=list.get(0).ID;
				boolean b=update(tp,"id="+list.get(0).ID);
				if (b==false)
				{return null;}
				else
				{
					
					return tp;
				}
			}
			
		}
		
	}
	
	public  Ns_Template_Privillege revoke_privilage(NotTemplate t, Ns_User user)
	{
		if (t==null || user==null)
		return null;
		else
		{
			Ns_Template_Privillege tp=new Ns_Template_Privillege();
			tp.Status=nonprivilage;
			tp.TemplateID=t.ID;
			tp.UserID=user.ID;
			
			ArrayList<Ns_Template_Privillege> list=GetAll(" user_id="+user.ID+" and template_id="+t.ID);
			if (list==null || list.size()==0)
			{
								
					return null;
													
			}
			
			
			else  		
			
			{
				tp.ID=list.get(0).ID;
				boolean b=update(tp,"id="+list.get(0).ID);
				if (b==false)
				{return null;}
				else
				{
					
					return tp;
				}
			}
			
		}
		
	}
}
