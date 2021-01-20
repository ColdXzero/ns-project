package Group_Management;

import model.*;
import Controller.*;




public class Group_manage {
	
	

	public static model.Ns_Group Add_Group(String group_name,String group_description, Ns_User owner, String status)
	{
		C_Group group = new C_Group();
		
		if (group_name == null || status== null)
			{
			  return null;
			  			
			}
		else
			{
			 Ns_Group new_group =new Ns_Group();
			 if (owner==null)
			 new_group =group.create_group(group_name, group_description, 0, status);
			
			 else		
				 
		     new_group =group.create_group(group_name, group_description, owner.ID, status);
			 
			 return new_group;
			}
		
	}
	
	public static model.Ns_Group update_Group(Ns_Group g,String name,String description, Ns_User owner, String status)
	{
		C_Group group = new C_Group();
		
		if (g == null ||name==null|| status== null)
			return null;
		else
			{
			 Ns_Group new_group =new Ns_Group();
			 new_group.ID=g.ID;
			 new_group.Name=name;
			 new_group.Description=description;
			 new_group.Status=status;
			 
			 if (owner==null)
				 new_group.OwnerID=0;
			 else		
				 new_group.OwnerID=owner.ID;
			 
			 Ns_Group upgroup=group.update_group(new_group);
			 
			 return upgroup;
			}
		
	}
	
	
}

