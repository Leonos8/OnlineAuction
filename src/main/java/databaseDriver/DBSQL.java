package databaseDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class DBSQL 
{
	Connection connection;
	
	public static void main(String[] args)
	{
		DBSQL sql=new DBSQL();
	}
	
	public DBSQL()
	{
		String host=null;
		Integer port=3306;
		String database="Accounts";
		String sqlUID="root";
		String sqlPID="root";
		
		connection=createConnection(host, port, database, sqlUID, 
				sqlPID);
	}
	
	public void close()
	{
		
	}
	
	public void containsEntry()
	{
		
	}
	
	public Connection createConnection(String host, Integer port, 
			String database, String sqlUID, String sqlPID)
	{
		Connection dbConnection=null;
		
		String connectionString="jdbc:mysql:";
		
		if(host==null)
		{
			connectionString+="//localhost";
		}
		else
		{
			connectionString+="//"+host;
		}
		
		if(port!=null)
		{
			connectionString+=":"+String.valueOf(port);
		}
		
		if(database!=null)
		{
			connectionString+="/"+database;
		}
		
		//In case connection uses unicode. Unlikely, but no harm
		connectionString+="?autoReconnect=true&useUnicode=true&"
				+ "characterEncoding=UTF8";
		
		//Load the driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(ClassNotFoundException ex)
        {
        	ex.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dbConnection=DriverManager.getConnection
					(connectionString, sqlUID, sqlPID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbConnection;
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
