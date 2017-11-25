<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
<link rel="stylesheet" href="css/responsive.css">
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
	
	<a href="welcome.jsp">
	   	<button class="new-search">Search</button>
	</a>
	<br></br>
	
	<c:forEach items="${game_results}" var="game">

		<div class="fix single_content floatleft">
		<b><c:out value="${game.game_name}" /></b>
			<img src="${game.front_box_art}" alt="front_box_art" />
			<h2>
				${game.console}
			</h2>
			<h2>
				Special discount: ${game.discount}%
			</h2>
			<span class="text">
				<a href="">${game.game_description}</a>
			</span>
			<div class="view_item">
				<form action="Selector" method="POST">
					<input type="hidden" name="game_name" value="${game.game_name}">
					<input type="submit" class="new-search" value="View">
				</form>
			</div>
		</div>
	</c:forEach>
</body>
</html>