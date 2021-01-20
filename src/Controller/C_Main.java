package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Table;

import DBA.MysqlConnection;

public class C_Main implements Icontroller {
	
	public <T> int insert (T t)
	{
		Connection con = MysqlConnection.getConnection();
		Class c =t.getClass();
		Table ta =(Table)c.getAnnotation(Table.class);
		String stmt="insert into "+ta.name()+" (";
		Field [] f=c.getDeclaredFields();
		try {
		for (Field field : f) {
			Column co=field.getAnnotation(Column.class);
		if(co!=null && field.get(t)!=null && field.getAnnotation(Column.class).name()!=null&& co.insertable())
			stmt+=" "+field.getAnnotation(Column.class).name()+" , ";
		}
		stmt=stmt.substring(0, stmt.length()-2);
		stmt+=" ) values (";
		for (Field field : f) {
			Column co=field.getAnnotation(Column.class);
			if(co!=null){
			if(field.get(t)!=null && co.insertable()){
			if(co.columnDefinition().equals("int"))
					stmt+=" "+field.get(t)+" , ";
			if(co.columnDefinition().equals("string"))
				stmt+=" \""+field.get(t)+"\" , ";
			if(co.columnDefinition().equals("date_time"))
			{ Date d = (Date)field.get(t);
			SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
				stmt+=" \""+ft.format(d)+"\" , ";
			}
		if(co.columnDefinition().equals("date"))
			{Date d = (Date)field.get(t);
			SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
			
			stmt+=" \""+ft.format(d)+"\" , ";
		
		}}
			}

			
		}
		stmt=stmt.substring(0, stmt.length()-2);
		stmt+=" )";

		java.sql.Statement st =  con.createStatement();
		st.executeUpdate(stmt,Statement.RETURN_GENERATED_KEYS); 
		ResultSet res = st.getGeneratedKeys(); 
		if(res.next())
		return res.getInt(1);
		
		} catch (Exception e) {
			System.out.println(stmt);

			e.printStackTrace();
			
		}
		 	
		return -1;
	}

	public <T> Boolean update (T t,String where)
	{	Class c =t.getClass();
		Table ta =(Table)c.getAnnotation(Table.class);
		String stmt="update "+ta.name()+ " set ";
		int id=-1;
		try {

			Connection con = MysqlConnection.getConnection();
				
		for (Field f : c.getDeclaredFields()) {
			if(f.getAnnotation(Column.class)!=null){if(f.getAnnotation(Column.class).insertable() && f.get(t)!=null){
				if(f.getAnnotation(Column.class).columnDefinition().equals("int"))
				stmt+=f.getAnnotation(Column.class).name()+" = "+f.get(t)+" , ";
			if(f.getAnnotation(Column.class).columnDefinition().equals("string"))
				
			{
				stmt+=f.getAnnotation(Column.class).name()+" = \""+f.get(t)+"\" , ";}
			if(f.getAnnotation(Column.class).columnDefinition().equals("date")){
				 Date d = (Date)f.get(t);
					SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
					
				stmt+=f.getAnnotation(Column.class).name()+" = \""+ft.format(d)+"\" , ";}
		if(f.getAnnotation(Column.class).columnDefinition().equals("date_time")){	 Date d = (Date)f.get(t);
		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			stmt+=f.getAnnotation(Column.class).name()+" = \""+ft.format(d)+"\" , ";
		}}}

		
		}
		
		stmt=stmt.substring(0,stmt.length()-2);
		stmt+= " where "+where;
		
		java.sql.Statement st =  con.createStatement();
		st.executeUpdate(stmt,Statement.RETURN_GENERATED_KEYS); 
		ResultSet res = st.getGeneratedKeys(); 
		System.out.println(stmt);
		if(res.next())
			id= res.getInt(1);
		
		} catch (Exception e) {
			System.out.println(stmt);

		 return false;
		}
		return true;
	}
	
	public <T> boolean delete (Class c,String where)
	{	Table ta =(Table)c.getAnnotation(Table.class);
		String stmt="delete from "+ta.name()+ " ";
		int id=-1;
		try {

			Connection con = MysqlConnection.getConnection();
		stmt+= " where "+where;
		
		java.sql.Statement st =  con.createStatement();
		st.executeUpdate(stmt,Statement.RETURN_GENERATED_KEYS); 
		
		
		} catch (Exception e) {
		 return false;
		}
		return true;
	}

	public <T> boolean deleteByID (Class c,int id)
	{	
		return delete(c," ID ="+id);
	}
	
	public <T> boolean delete (T t)
	{	
		Class c =t.getClass();
		try {
		for (Field f : c.getDeclaredFields()) {
			if (f.getAnnotation(Column.class).name().equals("id"))
				return deleteByID(t.getClass(),f.getInt(t));
		}

		} catch (Exception e) {
			
		} 
		return false;
	}
	
	public <T> int updateWhere (T t,String field,Object obj)
	{	Class c =t.getClass();
		Table ta =(Table)c.getAnnotation(Table.class);
		String stmt="update "+ta.name()+ " set ";
		
		try {

			Connection con = MysqlConnection.getConnection();
				
		for (Field f : c.getDeclaredFields()) {
			if(f.getAnnotation(Column.class)!=null){
			if(f.getAnnotation(Column.class).insertable() && f.get(t)!=null){
			if(f.getAnnotation(Column.class).columnDefinition().equals("int"))
				stmt+=f.getAnnotation(Column.class).name()+" = "+f.get(t)+" , ";
			if(f.getAnnotation(Column.class).columnDefinition().equals("string"))
				stmt+=f.getAnnotation(Column.class).name()+" = \'"+f.get(t)+"\' , ";
		
			if(f.getAnnotation(Column.class).columnDefinition().equals("date"))
			{
				Date d = (Date)f.get(t);
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
				stmt+=f.getAnnotation(Column.class).name()+" = \'"+ft.format(d)+"\' , ";
			}
		
			if(f.getAnnotation(Column.class).columnDefinition().equals("date_time"))
			{
				Date d = (Date)f.get(t);
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
				stmt+=f.getAnnotation(Column.class).name()+" = \'"+ft.format(d)+"\' , ";
			}
			}
		}
		}
		stmt=stmt.substring(0,stmt.length()-2);
		for (Field f : c.getDeclaredFields()) {
			if(f.getAnnotation(Column.class)!=null){
			if(f.getName().equals(field)){
			if(f.getAnnotation(Column.class).columnDefinition().equals("int"))
				stmt+= " where "+ta.name()+"."+f.getName()+" = "+obj;
			if(f.getAnnotation(Column.class).columnDefinition().equals("string"))
				stmt+= " where "+ta.name()+"."+f.getName()+" = \'"+obj+"\'";

			if(f.getAnnotation(Column.class).columnDefinition().equals("date"))
			{
				Date d = (Date)f.get(t);
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
				stmt+= " where "+ta.name()+"."+f.getName()+" = \'"+ft.format(d)+"\'";
			}

			if(f.getAnnotation(Column.class).columnDefinition().equals("date_time"))
			{				
				Date d = (Date)f.get(t);
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
				stmt+= " where "+ta.name()+"."+f.getName()+" = \""+ft.format(d)+"\"";
			}
			}
			}
		}		
		java.sql.Statement st =  con.createStatement();
		st.executeUpdate(stmt,Statement.RETURN_GENERATED_KEYS); 
		ResultSet res = st.getGeneratedKeys(); 
		if(res.next())
		return res.getInt(1);
		else
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		System.out.println(stmt);	
		return -1;
		} 
		
	}
	
	public <T> T GetByID(Class c,int id)
	{
		try {
			return (T) this.GetAll(c," id ="+id).get(0);
		} catch (Exception e) {
			
			return null; 
		} 
	}

	public <T> ArrayList<T> GetAll(Class c,String where)
	{
		String stmt="select ";
		ArrayList<Object> list = new ArrayList<Object>();

		try {
			
		Table ta =(Table)c.getAnnotation(Table.class);
		
		for (Field f : c.getDeclaredFields()) {
			
			if(f.getAnnotation(Column.class)!=null)
			stmt+= " "+f.getAnnotation(Column.class).name()+" , ";
		}
		
		stmt=stmt.substring(0,stmt.length()-2);
		stmt+= " from "+ta.name();
		if(where != null && where.length()>1) stmt+= " where "+where;
		
		Connection con = MysqlConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet res= st.executeQuery(stmt);
		
		while (res.next())
		{
			Constructor<T> co= c.getConstructors()[0];
			Object obj= co.newInstance(null);
			
			for (Field f : c.getDeclaredFields()) {

				//2018-12-05 06:00:00
				if(f.getAnnotation(Column.class)!=null){
				if(f.getAnnotation(Column.class).columnDefinition().equals("int"))
				{
					f.set(obj, res.getInt(f.getAnnotation(Column.class).name()));
				}
				
				if(f.getAnnotation(Column.class).columnDefinition().equals("string"))
				{
					f.set(obj, res.getString(f.getAnnotation(Column.class).name()));
				}
				
				if(f.getAnnotation(Column.class).columnDefinition().equals("date_time"))
				{
					f.set(obj, res.getDate(f.getAnnotation(Column.class).name()));
				}
				if(f.getAnnotation(Column.class).columnDefinition().equals("date"))
				{
					f.set(obj, res.getDate(f.getAnnotation(Column.class).name()));
				}}
			}
				
			list.add(obj);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(stmt);
			System.out.println("Error in Main:"+e.getMessage());
			return null;
		}  
		System.out.println(stmt);
		
		return (ArrayList<T>) list;
	}
}
