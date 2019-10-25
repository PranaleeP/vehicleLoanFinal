<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="email-validation.js"></script>
<style type="text/css">
table,h1,h3,div{
margin: auto;
text-align: center;
}
</style>
</head>
<body>

<header>
<jsp:include page="header.jsp" /> 
</header>
<h1>Application Form</h1>
<h3>Personal Details</h3>
<!-- 		<a href="home">Back</a>
 -->	
	 <form name="form" action="appform1"  method="post" modelAttribute="personalD">
			<table>
			<tr>
						<th>User Name:</th>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<th>First Name:</th>
						<td>${user.firstName}</td>
					</tr>
					<tr>
						<th>Last Name:</th>
						<td>${user.lastName}</td>
					</tr>
					<tr>
						<th>Date of Birth:</th>
						<td><input type="date" name="dob" min="1954-01-01" max="1997-12-31" required></td>
					</tr>
					<tr>
						<th>Gender:</th>
						<td>male<input type="radio" name="gender" value="male"  checked required >female<input type="radio" name="gender" value="female"></td>
					</tr>
					<tr>
						<th>Phone Number:</th>
						<td>${user.phoneNo}</td>
					</tr>
					<tr>
						<th>Email:</th>
						<td>${user.email}</td>
					</tr>
					<tr>
						<th>Address:</th>
						<td><textarea rows="4" cols="22" name="address" required></textarea></td>
					</tr>
					<tr>
						<th>State:</th>
						<td><input type="text" name="state" pattern="[A-Za-z\\s]*"></td>
					</tr>
					<tr>
						<th>City:</th>
						<td><input type="text" name="city" pattern="[A-Za-z\\s]*"></td>
					</tr>
					<tr>
						<th>Pin Code:</th>
						<td><input type="text" name="pincode" pattern="[1-9]{1}[0-9]{5}"></td>
					</tr>
					<tr>
						<th>Type of Employment:</th>
						<td><select name="employment">
					  <option value="Salaried" name="employment">Salaried</option>
					  <option value="Self Employed"  name="employment">Self Employed</option>
					  <option value="Self Employed Professional"  name="employment">Self Employed Professional</option>
			</select></td>
					</tr>
					<tr>
						<th>Annual Salary:</th>
						<td><input type="text" name="annualSalary" pattern="^[0-9]*$" required></td>
					</tr>
					<tr>
						<th>Existing EMI:</th>
						<td><input type="text" name="existingEmi" pattern="^[0-9]*$" required></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" onclick="ValidateEmail(document.form.email)"></td>
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