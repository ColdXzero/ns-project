package Setting_Management;



import java.util.ArrayList;
import java.util.Date;

import model.*;
import Controller.*;

public class Setting_Manage {
	

	public static Integer num_call_function_in_period(String name_function, Date date1, Date date2)
	{
		C_Log cl =new C_Log();
		if (name_function ==null )
			return null;
		else 
		{
			Date date = new Date(); //current datetime

			
			if (date1 ==null)
				date1 =date ; 
			if (date2== null)
				date2= date;
			
			ArrayList<Ns_log> list_log = cl.GetAll("name_function='"+name_function+"' and date_time between STR_TO_DATE("+date1.toString()+") and STR_TO_DATE("+date2.toString()+")");
			
			if (list_log ==null || list_log.size()==0)
				return null;
			else
				return list_log.size();
			
		}
		
	}
	
	public static ArrayList<Ns_log>  log_specific_function_in_period(String name_function, Date date1, Date date2)
	{
		C_Log cl =new C_Log();
		if (name_function ==null )
			return null;
		else 
		{
			Date date = new Date(); //current datetime

			
			if (date1 ==null)
				date1 =date ; 
			if (date2== null)
				date2= date;
			
			ArrayList<Ns_log> list_log = cl.GetAll("name_function='"+name_function+"' and date_time between STR_TO_DATE("+date1.toString()+") and STR_TO_DATE("+date2.toString()+")");
			
			if (list_log ==null || list_log.size()==0)
				return null;
			else
				return list_log;
			
		}
		
	}
	
	public static ArrayList<Ns_log>  log_all_function_in_period( Date date1, Date date2)
	{
		C_Log cl =new C_Log();
		
			Date date = new Date(); //current datetime

			
			if (date1 ==null)
				date1 =date ; 
			if (date2== null)
				date2= date;
			
			ArrayList<Ns_log> list_log = cl.GetAll("date_time between STR_TO_DATE("+date1.toString()+") and STR_TO_DATE("+date2.toString()+")");
			
			if (list_log ==null || list_log.size()==0)
				return null;
			else
				return list_log;
			
		
		
	}

	public static Ns_Setting add_Setting(String type, String value)
	{
		C_Setting cs=new C_Setting();
		if (type==null  )
		{
			return null;
		}
		else
		{
			
			Ns_Setting ns=new Ns_Setting();
			ns.Type=type;
			ns.Value=value;
			
			Ns_Setting new_set= cs.create_setting(ns);
			
			return new_set;
		}
	}
	
	public static Ns_Setting update_Setting(Ns_Setting set,String type, String value)
	{
		C_Setting cs=new C_Setting();
		if ( set==null || type ==null)
		{
			return null;
		}
		else
		{
			
			Ns_Setting ns=new Ns_Setting();
			ns.ID=set.ID;
			ns.Type=type;
			ns.Value=value;
			
			Ns_Setting updated_set= cs.update_setting(ns);
			
			return updated_set;
		}
	}
	
	public static Ns_log add_log(Ns_User user, String name_function, String parameters, Date date_time , String result)
	{
		    C_Log cl=new C_Log();
					
			Ns_log nl=new Ns_log();
			
			nl.date_time =date_time;
			nl.name_function = name_function;
			nl.parameters = parameters;
			nl.result = result;
			if (user !=null)
			nl.user_id= user.ID;
						
			Ns_log new_log= cl.create_log(nl);
			
			if (new_log == null)
				return null;
			else
			return new_log;
		
	}

}
