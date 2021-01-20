package UserManagement;

import java.util.ArrayList;
import java.util.UUID;

import model.Ns_Additional_Contacts;
import model.Ns_MemberShip;
import model.Ns_User;
import model.Ns_User_Contacts;
import Controller.C_Additional_Contacts;
import Controller.C_MemberShip;
import Controller.C_User;
import Controller.C_User_Contacts;

public class ManageUsers {
	

	public static Ns_User Login(String UserName,String Password)
	{
		C_User c = new C_User();
		Ns_User user =c.Login(UserName, Password);		
		if (user==null || user.ID<=0 ) 
			return null;
		
		return user;
	}
	public static Ns_User GetUserByKey(String Key)
	{
		C_User cu= new C_User();
	return cu.GetByKey(Key);
	}
	public static Ns_User AddUser(Ns_User u)
	{
		u.User_Type=u.User_Type.toUpperCase();
		u.User_Name=u.User_Name.toUpperCase();

		ArrayList<Ns_User> temp= new C_User().GetAll("user_name= '"+u.User_Name+"'");
		if(temp!=null && temp.size()>0)
		{
		return null;
		}
		
		if (u.User_Type.equals("ADMIN")|| u.User_Type.equals("SENDER") ||u.User_Type.equals("SUPER")||u.User_Type.equals("CLIENT"))
		{
			
			
		 //generate key
			u.User_Key=UUID.randomUUID().toString().replace("-","");
			
			if(u.User_Type.equals("SUPER"))
				u.Status="TRUE";
			else
				u.Status="PENDING CHECK";
			
			C_User c_u = new C_User();
			u.ID=c_u.insert(u);

			// SENDING CONFIRMATION MAIL
			String msg=ManageUsers.SendingConfirmation(u);
			if(msg.indexOf("Failed")>0)
				return null;
			
			return u;
		}
		
		/// error unknown type
		else return null;
	
	}
	
	public static Ns_User add_contacts(Ns_User u)
	{
		if (u.Contacts==null || u.Contacts.size()==0)
			  return u;

		C_User_Contacts c_add = new C_User_Contacts();
		ArrayList<Ns_User_Contacts> list= c_add.GetAll(" user_id="+u.ID);
		
		if (list==null || list.size()==0) return u;
		
		for (Ns_User_Contacts x : list) {
			for (Ns_User_Contacts y : u.Contacts) {
				if(x.ID==y.ID || (x.Contact_Type.equals(y.Contact_Type) && x.Contact_Val.equals(y.Contact_Val)))
				{
					// remove the existed contacts from temporary list
					list.remove(x);
				}

			}
		}
		if (list.size()>0)
		for (Ns_User_Contacts x : list) {
			x.User_ID=u.ID;
			x.ID=c_add.insert(x);
			u.Contacts.add(x);
		}
		
		return u;
	}
	
	public static String SendingConfirmation (Ns_User u)
	{
		String Text="please confirm your account by click <a href=\"http://localhost:8081/NS_Project/service/users/confirm/"+u.User_Key+"\">Here</a>";
		if (u.Contacts==null || u.Contacts.size()==0) return "Failed: no reciepent mail";
		
		int min=Integer.MAX_VALUE;
		Ns_User_Contacts main=new Ns_User_Contacts();
		for (Ns_User_Contacts x : u.Contacts) 
		{
			if(x.Contact_Type.toUpperCase().equals("EMAIL"))
			if(x.OrderId<min)
				{
					main=x;
					min=x.OrderId;
				}
		}
		
		if(min!=Integer.MAX_VALUE && main!= null && main.Contact_Type.equals("email"))
					{
					Notification_Management.Mail.sendMail(main.Contact_Val, "Confirmation Mail", Text);
					return "Done";
					}
		
		return "Failed";
	}
	
    public static Ns_User add_additional_contacts(Ns_User u)
	{
		if (u.Additional_Contacts==null || u.Additional_Contacts.size()==0)
			  return u;

		C_Additional_Contacts c_add = new C_Additional_Contacts();
		ArrayList<Ns_Additional_Contacts> list= c_add.GetAll(" owner_id="+u.ID);
		
		if (list==null || list.size()==0) return u;
		
		for (Ns_Additional_Contacts x : list) {
			for (Ns_Additional_Contacts y : u.Additional_Contacts) {
				if(x.ID==y.ID || (x.group_id==y.group_id || x.User_Id==y.User_Id))
				{
					// remove the existed contacts from temporary list
					list.remove(x);
				}

			}
		}
		if (list.size()>0)
		for (Ns_Additional_Contacts x : list) {
			
			x.ID=c_add.insert(x);
			u.Additional_Contacts.add(x);
		}
		
		return u;

	}

    // deactivate and change order
    public static Ns_User EditContacts(Ns_User u,ArrayList<Ns_User_Contacts> changes)
    {
    	if (u.Contacts==null || u.Contacts.size()==0)
			  return u;

		C_User_Contacts c_add = new C_User_Contacts();
		ArrayList<Ns_User_Contacts> list= c_add.GetAll(" user_id="+u.ID);
		
		if (list==null || list.size()==0) return u;
		
		for (Ns_User_Contacts x : list) {
			for (Ns_User_Contacts y : changes) {
				if(x.ID==y.ID || (x.Contact_Type.equals(y.Contact_Type) && x.Contact_Val.equals(y.Contact_Val)))
				{
					x.Status=y.Status.toUpperCase();
					x.OrderId=y.OrderId;
					c_add.update(x," id="+x.ID);
					
				}

			}
		}
		
		u.Contacts=list;
		return u;
    	
    }
    
    // deactivate and change order
    public static Ns_User EditAdditionalContacts(Ns_User u,ArrayList<Ns_Additional_Contacts> changes)
    {
    	if (u.Additional_Contacts==null || u.Additional_Contacts.size()==0)
			  return u;

		C_Additional_Contacts c_add = new C_Additional_Contacts();
		ArrayList<Ns_Additional_Contacts> list= c_add.GetAll(" user_id="+u.ID);
		
		if (list==null || list.size()==0) return u;
		
		for (Ns_Additional_Contacts x : list) {
			for (Ns_Additional_Contacts y : changes) {
				if(x.ID==y.ID || (x.group_id==y.group_id || x.User_Id==y.User_Id))
				{
					x.Status=y.Status.toUpperCase();
					x.OrderID=y.OrderID;
					c_add.update(x," id="+x.ID);
					
				}

			}
		}
		
		u.Additional_Contacts=list;
		return u;
    	
    }

    public static ArrayList <Ns_User> GetAllPending()
    {
    	return new C_User().GetAll("status ='PENDING ADMIN' or user_type='SENDER' ");
    }
    
    public static boolean UpdateAccountStatus(Ns_User u,String new_status)
    {
    	
    if(u.User_Type.equals("SUPER")) return false;
    if(u.ID<=0) return false;
    boolean f=false;
    if(u.Status.equals("TRUE")||u.Status.equals("FALSE"))
    {
    	u.Status=new_status.toUpperCase();
    	f=new C_User().update(u," id="+u.ID);
    	ArrayList<Ns_MemberShip> list=new C_MemberShip().GetByUserID(u.ID);
     for (Ns_MemberShip x : list) 
     {
    	 x.Status=new_status.toUpperCase();
    	f&= new C_MemberShip().update(x," user_id="+u.ID);
     }
    	
    }
    else
    {u.Status=new_status.toUpperCase();
	f=new C_User().update(u," id="+u.ID);
    	
    }
    
    return f;
    
    }
    

}
