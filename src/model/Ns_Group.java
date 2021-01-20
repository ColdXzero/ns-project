package model;



import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_group")
public class Ns_Group {
	
	public ArrayList <Ns_User> users;
	
	@Column (name="id",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="owner",columnDefinition="int",insertable=false)
	public int OwnerID;
	
	@Column (name="Name",columnDefinition="string")
	public String Name;
	
	@Column (name="status",columnDefinition="string")
	public String Status;
	
	@Column (name="Description",columnDefinition="string")
	public String Description;

}



