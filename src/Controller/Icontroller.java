package Controller;

import java.util.ArrayList;

public interface Icontroller {

	public <T> int insert (T t);

	public <T> Boolean update (T t,String where);

	public <T> boolean delete (Class c,String where);

	public <T> boolean deleteByID (Class c,int id);
	
	public <T> boolean delete (T t);

	public <T> int updateWhere (T t,String field,Object obj);

	public <T> T GetByID(Class c,int id);

	public <T> ArrayList<T> GetAll(Class c,String where);
}
