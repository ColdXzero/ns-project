package api;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.NotTemplate;
import model.Ns_User;
import Template_management.Template_manage;
import UserManagement.ManageUsers;
@Path ("/users")
public class UserAPI {
/*
	@POST
	@Path("/Login")
	@Produces (MediaType.APPLICATION_XML)
	public Ns_User LoginPost(@FormParam("usr") String user,@FormParam("pwd") String pwd)
	{
		Ns_User User =ManageUsers.Login(user, pwd);
		return User;
		
	}
*/
	@GET
	@Path("/Login/usr={usr}&pwd={pwd}")
	@Produces (MediaType.APPLICATION_XML)
	public Ns_User LoginGet(@PathParam("usr") String user,@PathParam("pwd") String pwd)
	{
		Ns_User User =ManageUsers.Login(user, pwd);
		return User;
		
	}

	@GET
	@Path("/confirm/{token}")
	@Produces (MediaType.TEXT_PLAIN)
	public String confirm(@PathParam("token") String key)
	{
		Ns_User ClientUser = ManageUsers.GetUserByKey(key);
		if(ClientUser== null)
			return "Failed!";
		else {
			if(ClientUser.User_Type.equals("CLIENT"))
				ManageUsers.UpdateAccountStatus(ClientUser, "TRUE");
			
			if(ClientUser.User_Type.equals("SENDER"))
				ManageUsers.UpdateAccountStatus(ClientUser, "PENDING ADMIN");
			
			if(ClientUser.User_Type.equals("ADMIN"))
				ManageUsers.UpdateAccountStatus(ClientUser, "PENDING ADMIN");
			
			return "Done!";
		}
	}


}
