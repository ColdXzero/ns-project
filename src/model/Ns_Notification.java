package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Table(name="ns_notification")
public class Ns_Notification {

	@Column (name="id",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="template_id",columnDefinition="int")
	public int TemplateID;
	
	@Column (name="sender_id",columnDefinition="int")
	public int SenderID;
	
	@Column (name="reciever_id",columnDefinition="int")
	public Integer RecieverID;
	
	@Column (name="reciever_group_id",columnDefinition="int")
	public Integer RecieverGroupID;
	
	@Column (name="send_date",columnDefinition="date")
	public Date SendDate;
	
	@Column (name="send_way",columnDefinition="int")
	public int SendWay;
	
	@Column (name="escalation",columnDefinition="string")
	public String Escalation;
	
	@Column (name="not_fields",columnDefinition="string")
	public String NotFields;
	
	@Column (name="code",columnDefinition="string")
	public String Code;


	@Column (name="priority",columnDefinition="int")
	public int priority;
	
	@Column (name="status",columnDefinition="int")
	public int status; // 1: wait, 2: in_sending_list, 3: sent_from_list 
		
	public NotTemplate Template;
	public Ns_User SenderUser;
	public Ns_User RecievedUser;
	public Ns_Group RecievedGroup;

}
