package model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_membership")
public class Ns_MemberShip {
 	 
	@Column (name="ID",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="user_id",columnDefinition="int") 	
	public int UserID;
	
	@Column (name="group_id",columnDefinition="int")
	public int GroupID;
	
	@Column (name="status",columnDefinition="string")
	public String Status;
}
