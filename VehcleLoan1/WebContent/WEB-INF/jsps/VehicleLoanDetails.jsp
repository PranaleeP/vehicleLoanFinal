<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table{

margin:auto;
}
th{
text-align:left;
}
h1,div{
text-align:center;
}
</style>
</head>
<body>

<header>
<jsp:include page="header.jsp" /> 
</header>

<h1>Loan Details</h1>
<form name="form" action="appform2" method="post" modelAttribute="loanD">
			<table>
			<tr>
						<th>Vehicle Make:</th>
						<td><input type="text" name="vehicleMake" pattern="[A-Za-z\\s]*" required></td>
					</tr>
	
					<tr>
						<th>Vehicle Model:</th>
						<td><input type="text" name="vehicleModel" required></td>
					</tr>
					<tr>
						<th>Ex-Showroom Price:</th>
						<td><input type="number" name="exShowroomPrice" pattern="^[0-9]*$" required></td>
					</tr>
					<tr>
						<th>Loan Amount:</th>
						<td><input type="text" name="loanAmount"  pattern="^[0-9]*$" required></td>
					</tr>
					<tr>
						<th>Loan Tenure:</th>
						<td><input type="text" name="loanTenure" pattern="^[0-9]*$"  required></td>
					</tr>
					<tr>
						<th>Rate of Interest:</th>
						<td><input type="text" name="ROI"  pattern="^[0-9]*$" required ></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="submit" onclick="ValidateEmail(document.form.email)"></td>
					</tr>
				</table>
		</form>
		<div>
		<a href="cancel"><button>Cancel</button></a>
		</div>
		<footer>
<jsp:include page="footer.jsp" /> 
</footer>
</body>
</html>