<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String uname=request.getParameter("uname");
	String pword=request.getParameter("psw");
	
	userHandler.UserHandler.loginAccount(uname, pword);
	
	databaseDriver.DBSQL sql=new databaseDriver.DBSQL();
	
	String query="SELECT * FROM endUsers "
			+"WHERE username='"+uname+"';";
			
	System.out.println(query);
	
	java.util.ArrayList<Object[]> data=sql.select(query);
	
	if(data.size()!=1)
	{
		System.out.println(1);
		System.out.println("Incorrect information");
		
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
		</html>
		
		<%
	}
	else if(!data.get(0)[2].equals(pword))
	{
		System.out.println(2);
		System.out.println("Incorrect information");
		
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
		</html>
		
		<%
	}
	//This one can make sure size is within specific bounds, as well as 
	//Doesnt contain any bad characters such as quotes
	else if(String.valueOf(data.get(0)[1]).contains("\""))
	{
		System.out.println(3);
		System.out.println("Incorrect information");
		
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
		</html>
		
		<%
	}
	else
	{
		System.out.println(4);
		System.out.println("LOGIN");
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='.../auction/HomePage.jsp'" />
		</html>
		
		<%
		
		//Make this open the HomePage.jsp
		/*
		<html>
	<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
</html>
		*/
	}
%>