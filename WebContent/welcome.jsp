<!-- Welcome View -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>

	<c:choose>
		<c:when test="${empty username}">
			<p class="message">
				Already registered? <a href="login.jsp">Sign In</a>
			</p>
			<p class="message">
				Not registered? <a href="registration.jsp">Create an account</a>
			</p>
		</c:when>
		<c:otherwise>
			Welcome ${username}
		</c:otherwise>
	</c:choose>		
			 
	<c:if test="${not empty username}">
		<form action="Logout" method="GET">
			<input type=submit class="logout-submit" value="Logout">
		</form>
		<form action="Discount" method="GET">
			<input type=submit class="new-search" value="Discount">
		</form>
	</c:if>

	<div style="text-align:center">
		Search game (Leave empty if you are not sure!)
	</div>

	<form class="search" method="GET" action="Search">
		<input type="text" name="name" class="login-input" placeholder="Game name" /> 
		<input type="text" name="num_player" class="login-input" placeholder="Number of players" /> 
		<input type="text" name="coop" class="login-input" placeholder="Coop (input true or false)" /> 
		<input type="text" name="console" class="login-input" placeholder="Console" />
		<input type="text" name="year" class="login-input" placeholder="Year" />
		<input type="text" name="genre" class="login-input" placeholder="Genre" /> 
		<input type="text" name="publisher" class="login-input" placeholder="Publisher" /> 
			<c:if test="${not empty error_message}">
				<font color="red"> ${error_message} </font>
			</c:if>
		<input type="submit" value="Search" class="login-submit">
	</form>
</body>
</html>