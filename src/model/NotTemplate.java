package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_template")
public class NotTemplate {

@Column (name="id",columnDefinition="int",insertable=false)
public int ID;

@Column (name="Tittle",columnDefinition="string")
public String Tittle;


@Column (name="Owner",columnDefinition="int")
public int Owner;

@Column (name="T_TEXT",columnDefinition="string")
public String T_TEXT;

@Column (name="T_Fields",columnDefinition="string")
public String T_Fields;

@Column (name="Start_Date",columnDefinition="date")
public Date Start_Date;

@Column (name="End_Date",columnDefinition="date")
public Date End_Date;

@Column (name="Duration",columnDefinition="string")
public String Duration;

@Column (name="Send_Way",columnDefinition="string")
public String Send_Way;

@Column (name="Escalation",columnDefinition="string")
public String Escalation;


}
