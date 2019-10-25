<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

window.history.forward();
function noBack() { window.history.forward(); }
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="../css/style.css"> 
 
<style type="text/css">

table,h1{
margin: auto;
text-align: center;
}
</style>
</head>
<BODY onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">

<header>
<jsp:include page="header.jsp" /> 
</header>
<h1>Login</h1>
<form action="rlogin" method="post">
		<table>
			<tr>
						<th>User Name:</th>
						<td><input type="text" name="userName" required></td>
					</tr>
					<tr>
						<th>Password:</th>
					<td><input type="password" name="password" requied></td>
				</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login"></td>
		</tr>
		</table>
</form>
<h5 style="text-align:center ; color:red;">${message}</h5>
	<footer>
<jsp:include page="footer.jsp" /> 
</footer>
    
</body>
</html>