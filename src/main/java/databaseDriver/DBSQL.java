package databaseDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBSQL 
{
	Connection connection;
	
	public static void main(String[] args)
	{
		System.out.println("1");
		
		DBSQL sql=new DBSQL();
		
		String query="SELECT username FROM endUsers";
		
		ArrayList<Object[]> data=sql.select(query);
		
		System.out.println("2");
		
		for(int i=0; i<data.size(); i++)
		{
			for(int j=0; j<data.get(i).length; j++)
			{
				System.out.println(data.get(i)[j]);
			}
		}
	}
	
	public DBSQL()
	{
		String host=null;
		Integer port=3306;
		String database="Accounts";
		String sqlUID="root";
		String sqlPID="root";
		
		connection=getConnection(host, port, database, sqlUID, 
				sqlPID);
	}
	
	public void close()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void containsEntry()
	{
		
	}
	
	//Wont delete an entry, but will make an entry invalid
	public void delete()
	{
		
	}
	
	public Connection getConnection(String host, Integer port, 
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
	
	public void insert()
	{
		
	}
	
	public ArrayList<Object[]> select(String query)
	{
		Statement statement;
		
		int colCount;
		
		ArrayList<Object[]> data=new ArrayList<Object[]>();
		Object[] row;
		
		try
		{
			statement=connection.createStatement();
			
			ResultSet rs=statement.executeQuery(query);
			
			try
			{
				colCount=rs.getMetaData().getColumnCount();
				
				while(rs.next())
				{
					if(rs.getMetaData().getColumnCount()!=colCount)
					{
						throw new Exception("Wrong # of Columns: "
					+colCount+" v.s. RS="
								+rs.getMetaData().getColumnCount());
					}
					
					row=new Object[colCount];
					
					for(int i=0; i<colCount; i++)
					{
						row[i]=rs.getObject(i+1);
					}
					
					data.add(row);
				}
			}finally
			{
				try
				{
					rs.close();
				}catch(Exception ignore) {}
			}
			
			statement.close();
		}catch(SQLSyntaxErrorException ex)
		{
			System.out.println("SQL Syntax Error");
			ex.printStackTrace();
		}catch(SQLException ex)
		{
			System.out.println("SQL Exception error");
			ex.printStackTrace();
		}catch(Exception ex)
		{
			System.out.println("Uncaught Exception: "+ex.getClass());
			ex.printStackTrace();
		}
		
		return data;
	}
	
	public void verifyCredentials()
	{
		
	}
}
