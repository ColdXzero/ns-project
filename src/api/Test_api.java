package api;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.w3c.dom.CharacterData;

import com.clockworksms.SMS;

import Notification_Management.Mail;
import Notification_Management.SendSMS;
import UserManagement.ManageUsers;
import sun.nio.cs.UnicodeEncoder;
import model.Ns_Group;
import model.Ns_Response;
import model.Ns_Template_Privillege;
import model.Ns_User;
import Controller.C_Main;
import Controller.C_Template_Priv;
import Controller.C_User;
import DBA.MysqlConnection;

@Path ("/templates")
public class Test_api {

	@Context UriInfo uriInfo;
	@Context Request request;
	
	@Resource(name = "NOTIFICATION_SYSTEM")
	private	DataSource NOTIFICATION_SYSTEM;
		 
	@GET
	@Path("/Helloo/{x}")
	@Produces (MediaType.TEXT_PLAIN)
	public String run(@PathParam("x") String x)
	{
	
		/*ArrayList<Ns_Group> l = new ArrayList<Ns_Group>();
	  try {
		  Connection con = MysqlConnection.getConnection();

		 java.sql.Statement st =  con.createStatement();
		 ResultSet res= st.executeQuery("select * from ns_group");
		 st.getGeneratedKeys();
		 
		 while (res.next())
		 {
		 Ns_Group g = new Ns_Group();
		 g.ID=res.getInt(1);
		 g.Description=res.getString(3);
		 g.Name=res.getString(2);
		 l.add(g);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	  return l;*/
	/*	Ns_User user = ManageUsers.GetUserByKey(x);
		C_Template_Priv ctp = new C_Template_Priv();


		ArrayList<Ns_Template_Privillege> list= ctp.GetByUserID(user.ID);

		return 			list.size()+" ";*/
		
		return SendSMS.sendSms(x, "Hello From Omar");
	
		
	}
}
