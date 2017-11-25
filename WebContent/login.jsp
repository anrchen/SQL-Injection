<!-- Login View -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div>
		<form action="Login" class="login" method="POST">
			<input type="text" name="username" class="login-input" placeholder="Email" /> 
			<input type="password" name="password" class="login-input" placeholder="Password" />
			<c:choose>
				<c:if test="${not empty error_message}">
        			<font color="red">
        				${error_message}
        			</font>
    			</c:if>
			</c:choose>
			<input type="submit" value="Login" class="login-submit">
			<p class="message">
				Skip login, <a href="welcome.jsp">search game</a>
			</p>
			<p class="message">
				Not registered? <a href="registration.jsp">Create an account</a>
			</p>
		</form>
	</div>
</body>
</html>