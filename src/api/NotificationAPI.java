package api;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Notification_Management.Notification_manage;
import Notification_Management.Response_manage;
import model.Ns_Notification;
import model.Ns_User;

@Path ("/templates")
public class NotificationAPI {

	@GET
	@Path("/Response/key={Token}&ID={ID}&code={NotCode}")
	@Produces (MediaType.TEXT_PLAIN)
	public String sendResponse(@PathParam("Token") String key, @PathParam("NotCode") String code,@PathParam("ID") int id   )
	{
		Date date = new Date();
		boolean b = false;
		Ns_User user =  UserManagement.ManageUsers.GetUserByKey(key);
		if(user.User_Key.equals(key))
		{
			ArrayList<Ns_Notification> UserNotifications=Notification_manage.view_notifications_to_user(user);
			for (Ns_Notification ns_Notification : UserNotifications)
			{
				if(ns_Notification.Code.equals(code) && ns_Notification.ID==id)
				{ 	b=true;
					Response_manage.add_response(ns_Notification, user, date);	
				}
			}
		}
	return b?"Done!":"Failed: Wrong Request!";
	
	}


}

