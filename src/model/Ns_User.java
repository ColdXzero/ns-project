package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Table(name="ns_user")
public class Ns_User {
	 	 		
	@Column (name="ID",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="user_name",columnDefinition="string") 	
	public String User_Name;
	
	@Column (name="status",columnDefinition="string") 	
	public String Status;
	
	@Column (name="user_password",columnDefinition="string")
	public String User_Password;
	
	@Column (name="send_rate",columnDefinition="string")
	public String Send_rate;
	
	@Column (name="user_key",columnDefinition="string")
	public String User_Key;
	
	@Column (name="user_type",columnDefinition="string")
	public String User_Type;

	public ArrayList<Ns_User_Contacts> Contacts = new ArrayList<Ns_User_Contacts>();
	public ArrayList<Ns_Additional_Contacts> Additional_Contacts =new ArrayList<Ns_Additional_Contacts>();

}
