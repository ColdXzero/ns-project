package Notification_Management;


import java.util.Date;

import model.*;
import Controller.*;

public class Response_manage {
	
	public static Ns_Response add_response(Ns_Notification not, Ns_User user, Date date)
	{
		C_response ct=new C_response();
		if (not==null || user==null )
		{
			return null;
		}
		else
		{
			/***
			 * 
			 * should check if the user has privilege to do 
			 * **/
			Ns_Response nr=new Ns_Response();
			nr.Not_ID=not.ID;
			nr.Response_date=date;
			nr.User_ID=user.ID;
						
			Ns_Response new_resp=ct.create_Response(nr);
			return new_resp;
		}
	}

}
