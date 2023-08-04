<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String uname=request.getParameter("uname");
	String pword=request.getParameter("psw");
	String email=request.getParameter("eml");
	String phone=request.getParameter("pn");
	
	// uh=new userHandler.UserHandler();
	System.out.println(userHandler.UserHandler.createAccount(uname, pword, email, phone));
	
	if(userHandler.UserHandler.createAccount(uname, pword, email, phone)!=6)
	{
		System.out.println("Not 6");
		
		%>

		<html>
			<meta http-equiv="Refresh" content="0; url='CreateAccountPage.jsp'" />
		</html>
		
		<%
	}
	else if(userHandler.UserHandler.createAccount(uname, pword, email, phone)==6)
	{
		System.out.println(6);
		
		%>

		<html>
			<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
		</html>
		
		<%
	}
%>
