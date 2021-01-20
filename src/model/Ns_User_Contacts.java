package model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_user_contacts")
public class Ns_User_Contacts {
		
	@Column (name="ID",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="user_id",columnDefinition="int")
	public int User_ID;
	
	@Column (name="con_value",columnDefinition="string")
	public String Contact_Val;
        
	@Column (name="con_type",columnDefinition="string")
	public String Contact_Type;
	
	@Column (name="order_id",columnDefinition="int")
	public int OrderId;
	
	@Column (name="status",columnDefinition="string")
	public String Status;
	
}
