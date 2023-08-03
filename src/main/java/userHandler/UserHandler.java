package userHandler;

import java.util.ArrayList;

import databaseDriver.DBSQL;

public class UserHandler
{
	public static void createAccount(String uname, String pword, 
			String email, String phone)
	{
		System.out.println(uname);
		System.out.println(pword);
		System.out.println(email);
		System.out.println(phone);
	}
	
	public static void createRequested()
	{
		System.out.println("Create Requested!");
	}
	
	public static boolean loginAccount(String uname, String pword)
	{
		System.out.println(uname);
		System.out.println(pword);
		
		boolean valid=false;
		
		DBSQL sql=new DBSQL("Accounts");
		
		String query="SELECT * FROM endUsers "
				+"WHERE username='"+uname+"';";
				
		System.out.println(query);
		
		ArrayList<Object[]> data=sql.select(query);
		
		if(data.size()!=1)
		{
			System.out.println(1);
			System.out.println("Incorrect information");
			
			valid=false;
		}
		else if(!data.get(0)[2].equals(pword))
		{
			System.out.println(2);
			System.out.println("Incorrect information");
			
			valid=false;
		}
		//This one can make sure size is within specific bounds, as well as 
		//Doesnt contain any bad characters such as quotes
		else if(String.valueOf(data.get(0)[1]).contains("\""))
		{
			System.out.println(3);
			System.out.println("Incorrect information");
			
			valid=false;
		}
		else
		{
			System.out.println(4);
			System.out.println("LOGIN");
			
			valid=true;
		}
		
		return valid;
	}
}