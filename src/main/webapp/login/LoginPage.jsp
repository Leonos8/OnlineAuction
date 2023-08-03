<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Online Auction Login</title>
		
		<style>
			body {font-family: Arial, Helvetica, sans-serif;}
			form {border: 3px solid #f1f1f1;}

			input[type=text], input[type=password] 
			{
  				width: 100%;
  				padding: 12px 20px;
  				margin: 8px 0;
  				display: inline-block;
  				border: 1px solid #ccc;
  				box-sizing: border-box;
			}

			button 
			{
  				background-color: #1B7CED;
  				color: white;
  				padding: 14px 20px;
  				margin: 8px 0;
  				border: none;
  				cursor: pointer;
  				width: 10%;
  				font-size: 16px;
			}

			button:hover 
			{
  				opacity: 0.8;
			}

			.imgcontainer 
			{
  				text-align: center;
  				margin: 24px 0 12px 0;
			}

			.container 
			{
  				padding: 16px;
			}

			.psw 
			{
  				float: right;
  				padding-top: 16px;
			}
			
			.createAccountBtn 
  			{
  				float: right;
     			width: 100%;
  			}
		</style>
	</head>

	<body>
		<h2>Login</h2>
		<form action="LProcessing.jsp" method="post">
  			<div class="container">
    			<label for="uname"><b>Username</b></label>
    			<input type="text" placeholder="Enter Username" name="uname" required>
				
    			<label for="psw"><b>Password</b></label>
    			<input type="password" placeholder="Enter Password" name="psw" required>
        		
        		<p>
        			<button class="submit" type="submit">Login</button>
        			
        			<div>
        				<a class="createAccountBtn" href="CreateAccountPage.jsp">Create Account</a>
        			</div>
    			</p>
  			</div>
		</form>
	</body>
</html>