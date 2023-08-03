<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Online Auction</title>
	</head>
	
	<body>
		<nav>
			<ul>
				<li>
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
					<a href="#"><i class="fa fa-user"></i>User</a>				
					<ul class="dropdown">
						<li><a href="../login/LoginPage.jsp">Log Out</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</body>
	
	<style>
	
		*{
	
			padding: 0;
			margin: 1;
			font-family: sans-serif;
			
		}
	
		ul{
			list-style: none;
			backgrond: black;
			
		}
	
		ul li{
			display: inline-block;
			position: relative;
			border: 2px solid black;
			
		}
	
		ul li a{
			display: block;
			padding: 13px 16px;
			color: black;
			text-decoration: none;
			text-align: center;
			font-size: 16px;
		
		}
	
		ul li ul.dropdown li{
			display: block;
			
		}
		
		ul li ul.dropdown{
			width: 100%;
			background: white;
			position: absolute;
			z-index: 1;
			display: none;
			
		}
	
		ul li a:hover{
			background: blue;
		}
	
		ul li:hover ul.dropdown{
			display: block;
		}
	
	</style>
	
</html>