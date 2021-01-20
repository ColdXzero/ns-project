package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_log")
public class Ns_log {
	
@Column (name="id",columnDefinition="int",insertable=false)
public int ID;

@Column (name="user_id",columnDefinition="int")
public int user_id;

@Column (name="name_function",columnDefinition="string")
public String name_function;

@Column (name="parameters",columnDefinition="string")
public String parameters;

@Column (name="date_time",columnDefinition="date_time")
public Date date_time;

@Column (name="result",columnDefinition="string")
public String result;

}
