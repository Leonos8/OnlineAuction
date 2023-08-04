package userHandler;

import java.util.ArrayList;

import databaseDriver.DBSQL;

public class UserHandler
{
	public static int createAccount(String uname, String pword, 
			String email, String phone)
	{
		System.out.println(uname);
		System.out.println(pword);
		System.out.println(email);
		System.out.println(phone);
		
		int valid=-1;
		
		DBSQL sql=new DBSQL("Accounts");
		
		String query="SELECT * FROM endUsers "
				+"WHERE username='"+uname+"';";
				
		System.out.println(query);
		
		ArrayList<Object[]> data=sql.select(query);
		
		String tmpQuery="SELECT * FROM endUsers "
				+"WHERE username='"+email+"';";
		ArrayList<Object[]> tmpData=sql.select(query);
		
		if(data.size()!=0)
		{
			System.out.println(0);
			System.out.println("Username taken!");
			
			valid=0; //Username taken error
		}
		else if(tmpData.size()!=0)
		{
			System.out.println(1);
			System.out.println("Email taken!");
			
			valid=1; //Email taken error
		}
		else if(String.valueOf(data.get(0)[1]).contains("\"")//username
				|| String.valueOf(data.get(0)[1]).contains("\'")
				|| String.valueOf(data.get(0)[1]).length()>32
				|| String.valueOf(data.get(0)[1]).length()<4)
		{
			System.out.println(2);
			System.out.println("Username doesnt meet criteria");
				
			valid=2; //Username doesnt meet criteria
		}
		else if(String.valueOf(data.get(0)[2]).contains("\"")//Password
				|| String.valueOf(data.get(0)[2]).contains("\'")
				|| String.valueOf(data.get(0)[2]).length()>32
				|| String.valueOf(data.get(0)[2]).length()<4)
		{
			System.out.println(3);
			System.out.println("Password doesnt meet criteria");
				
			valid=3; //Password doesnt meet criteria
		}
		else if(String.valueOf(data.get(0)[3]).contains("\"")//email
				|| String.valueOf(data.get(0)[3]).contains("\'")
				|| String.valueOf(data.get(0)[3]).length()>64
				|| String.valueOf(data.get(0)[3]).length()<4)
		{
			System.out.println(4);
			System.out.println("Email doesnt meet criteria");
				
			valid=4; //Email doesnt meet criteria
		}
		else if(String.valueOf(data.get(0)[4]).contains("\"")//Phone
				|| String.valueOf(data.get(0)[4]).contains("\'")
				|| String.valueOf(data.get(0)[4]).length()>32
				|| String.valueOf(data.get(0)[4]).length()<4)
		{
			System.out.println(5);
			System.out.println("Phone number doesnt meet criteria");
				
			valid=5; //Phone number doesnt meet criteria
		}
		else
		{
			//Insert into endUsers VALUES (1, 'Admin', 'root', 'Admin@gmail.com', '6090001111', true, '2001-01-01 00:00:00', true);
			
			System.out.println(6);
			System.out.println("Account Created");
			
			
			System.out.println(sql.getRowCount("endUsers"));
			
			valid=6; //Account created
		}
		
		return valid;
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
		//This one can make sure size is within specific bounds, as 
		//well as Doesnt contain any bad characters such as quotes
		else if(String.valueOf(data.get(0)[1]).contains("\"")
			|| String.valueOf(data.get(0)[1]).contains("\'")
			|| String.valueOf(data.get(0)[1]).length()>32)
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