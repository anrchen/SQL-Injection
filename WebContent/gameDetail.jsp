<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${aGame.game_name}</title>
<link rel="stylesheet" href="css/detail.css">
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
	
	<div class="detail">
		<b><c:out value="${aGame.game_name}" /></b> <br></br>
			<img src="${aGame.front_box_art}" class="column front-art" alt="front_box_art" />
			<a href="${aGame.front_box_art}" class="art"> Front Boxart </a>
			<c:choose>
			    <c:when test="${empty aGame.back_box_art}">
			    </c:when>
			    <c:otherwise>
			       <a href="${aGame.back_box_art}" class="art"> Back Boxart </a>
			    </c:otherwise>
			</c:choose>		
			<div class="column">
				<c:choose>
				    <c:when test="${not empty aGame.logo}">	
						<img src="${aGame.logo}" class="logo" style="background-color:#e3e6e8"></img>
				    </c:when>
				    <c:otherwise>
				    </c:otherwise>
				</c:choose>	
				<hr>
				<span style="color:grey"><b>Price: </b></span>$${aGame.price} </br>
				<span style="color:grey"><b>Discount: </b></span> ${aGame.discount}%
				<hr>
				<b>Console: </b>
				<h2>
					${aGame.console}
				</h2>
				<hr>
				<b>Description: </b>
				<span>
					${aGame.game_description}
				</span>
				<hr>
				<span style="color:grey">Player:</span> ${aGame.num_players}</br>
				<c:choose>
  					<c:when test="${aGame.coop == false}">
						<span style="color:grey">Coop:</span> No </br>
  					</c:when>
  					<c:otherwise>
				   		<span style="color:grey">Coop:</span> Yes </br>
				  </c:otherwise>
				</c:choose>
				<span style="color:grey">Genre:</span> ${aGame.genre} </br>
				<span style="color:grey">Release date:</span> ${aGame.release_date} </br>
				<span style="color:grey">Publisher:</span> ${aGame.publisher} </br>
				<span style="color:grey">Developer:</span> ${aGame.developer} </br>
				<c:choose>
				    <c:when test="${not empty aGame.logo}">	
						<img src="${aGame.developer_logo}" class="logo" style="background-color:#e3e6e8"></img> </br>
				    </c:when>
				    <c:otherwise>
				    </c:otherwise>
				</c:choose>	
			</div>
	</div>
</body>
</html>