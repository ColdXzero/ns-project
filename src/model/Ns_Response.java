package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_response")
public class Ns_Response {
	
	public Ns_User user;
	public Ns_Notification notification;
	
	@Column (name="id",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="not_id",columnDefinition="int")
	public int Not_ID;
	
	@Column (name="user_id",columnDefinition="int")
	public int User_ID;
	
	@Column (name="response_date",columnDefinition="date_time")
	public Date Response_date;
	
}
