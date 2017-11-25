<!-- Registration View -->

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
		<form class="login" method="POST" action="Registration">
			<input type="text" name="username" class="login-input" placeholder="Email/Username" required>
			<input type="password" name="password" class="login-input" placeholder="Password" required> 
			<input type="text" name="firstname" class="login-input" placeholder="First name" required> 
			<input type="text" name="lastname" class="login-input" placeholder="Last name" required> 
			<input type="text" name="address1" class="login-input" placeholder="Address 1" required> 
			<input type="text" name="address2" class="login-input" placeholder="Address 2" required> 
			<input type="text" name="city" class="login-input" placeholder="City" required> 
			<input type="text" name="state" class="login-input" placeholder="State" required> 
			<input type="text" name="zip" class="login-input" placeholder="Postal code" required> 
			<input type="text" name="country" class="login-input" placeholder="Country" required> 
			<select name="credit_card_type" class="login-input" required>
			  <option value="mastercard">Master card</option>
			  <option value="visa">Visa</option>
			  <option value="discoverycard">Discovery card</option>
			</select>
			<input type="number" name="credit_card_number" class="login-input" placeholder="Credit card number" required> 
			<input type="number" name="credit_card_cvv" class="login-input" placeholder="Credit card CVV" required> 
			<!-- Input type month is not supported in Firefox or IE 11 -->
			<input type="month" name="credit_card_expiry" class="login-input" placeholder="Credit card expiry" required> 
			<input type="submit" value="Create" class="login-submit">
			<c:choose>
				<c:if test="${not empty error_message}">
        			<font color="red">
        				${error_message}
        			</font>
    			</c:if>
			</c:choose>
			<p class="message">
				Skip login, <a href="welcome.jsp">search game</a>
			</p>
			<p class="message">
				Already registered? <a href="login.jsp">Sign In</a>
			</p>
		</form>
	</div>
</body>
</html>