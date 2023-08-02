<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String uname=request.getParameter("uname");
	String pword=request.getParameter("psw");
	String email=request.getParameter("eml");
	String phone=request.getParameter("pn");
	
	userHandler.UserHandler.createAccount(uname, pword, email, phone);
%>

<html>
	<meta http-equiv="Refresh" content="0; url='LoginPage.jsp'" />
</html>