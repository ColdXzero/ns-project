package model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Table(name="ns_template_privilege")
public class Ns_Template_Privillege {

	@Column (name="ID",columnDefinition="int",insertable=false)
	public int ID;
	
	@Column (name="user_id",columnDefinition="int")
	public int UserID;

	@Column (name="template_id",columnDefinition="int")
	public int TemplateID;
	
	@Column (name="status",columnDefinition="string")
	public String Status;
}
