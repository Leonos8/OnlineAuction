<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Online Auction</title>
		
		<style>
			.btn 
			{
  				background-color: white;
  				/*border: none; *//* Remove borders */
  				padding: 12px 16px; /* Some padding */
  				font-size: 16px; /* Set a font size */
  				cursor: pointer; /* Mouse pointer on hover */
  				position: absolute;
  				right: 0.5em;
			}
			
			.dropbtn
			{
				position: relative;
				display: inline-block;
				float: right;
			}
			
			.list
			{
				display: none;
				position: absolute;
				background-color: blue;
				min-width: 158px;
				z-index: 1;
			}
			
			.list a:hover
			{
				background-color: blue;
				color: #green;
			}

			
			/* Darker background on mouse-over */
			.btn:hover .list
			{
  				display: block;
  				background-color: LightGray;
			}
			
			.btn:hover .dropbtn
			{
				background-color: transparent;
			}
			
			
		</style>
	</head>
	<body>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<div class="dropbtn">
			<button class="btn"><i class="fa fa-user"></i>User</button>
			<div class="list">
				<a href="#">Logout</a>
			</div>
		</div>
		
	</body>
</html>