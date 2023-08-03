<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String uname=request.getParameter("uname");
	String pword=request.getParameter("psw");
	
	if(userHandler.UserHandler.loginAccount(uname, pword))
	{
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='../auction/HomePage.jsp'" />
		</html>
		
		<%
	}
	else
	{
		%>
		
		<html>
			<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
		</html>
		
		<%
	}
%>