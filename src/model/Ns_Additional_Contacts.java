
package model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_additional_contacts")
public class Ns_Additional_Contacts {
	
	public Ns_Group add_group;
	public Ns_User add_user;
	
	@Column (name="id",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="owner_id",columnDefinition="int")
	public int OwnerId;
	
	@Column (name="user_id",columnDefinition="int")
	public int User_Id;
	
	@Column (name="group_id",columnDefinition="int")
	public int group_id;
	
	@Column (name="order_id",columnDefinition="int")
	public int OrderID;

	@Column (name="Status",columnDefinition="int")
	public String Status;

}
