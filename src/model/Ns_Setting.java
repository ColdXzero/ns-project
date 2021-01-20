package model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name="ns_setting")
public class Ns_Setting {

		@Column (name="id",columnDefinition="int",insertable=false)
		public int ID;
		
		@Column (name="s_type",columnDefinition="string")
		public String Type;
		
		@Column (name="s_value",columnDefinition="string")
		public String Value;

}
