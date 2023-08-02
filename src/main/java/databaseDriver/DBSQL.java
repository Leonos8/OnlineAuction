package databaseDriver;

import java.sql.SQLException;

public class DBSQL 
{
	public static void main(String[] args)
	{
		System.out.println("HI");
		try {
			DBSQL sql=new DBSQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DBSQL() throws SQLException
	{
		String sqlUname="root";
		String sqlPword="root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void close()
	{
		
	}
	
	public void containsEntry()
	{
		
	}
	
	//Wont delete an entry, but will make an entry invalid
	public void delete()
	{
		
	}
	
	public void insert()
	{
		
	}
	
	public void verifyCredentials()
	{
		
	}
}
