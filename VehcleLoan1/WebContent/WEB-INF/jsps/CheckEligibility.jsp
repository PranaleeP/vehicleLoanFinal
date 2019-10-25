<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
table,h1{
text-align:center;
padding :10px;
margin: auto;
}
th{
float:left;
}
</style>
<script>
function ValidateAge(age) 
{
 if (test(myForm.age.value)>21 && test(myForm.age.value)<=65 )
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}

</script>
<link rel="stylesheet" href="../css/style.css"> 
 

</head>
<body>

<header>
<jsp:include page="header.jsp" /> 
</header>


<body>

	<h1>Check Eligibility</h1>
<!-- 		<a href="home">Back</a>
 -->	
 <form name="myForm" action="checkEligibility" onSubmit="return ValidateAge()">
	<table>    
	<tr>
			<th colspan="2">Vehicle Details</th>
	</tr>
	<tr>
			<th>Vehicle Make:</th>
			<td><input type="text" name="carMake" required></td>
		</tr>
		<tr>
			<th>Vehicle Model:</th>
			<td><input type="text" name="carModel" required></td>
		</tr>
		<tr>
			<th>Ex-Showroom Price:</th>
			<td><input type="text" name="showroomPrice" required></td>
		</tr>
	
	<tr>
			<th colspan="2">Applicant Details</th>
	</tr>
	<tr>
			<th>First Name:</th>
			<td><input type="text" name="firstName" required></td>
		</tr>
		<tr>
			<th>Last Name:</th>
			<td><input type="text" name="lastName" required></td>
		</tr>
		<tr>
			<th>Age:</th>
			<td><input id="age" type="text" name="age" required></td>
		</tr>
		<tr>
			<th>Gender:</th>
			<td>male<input type="radio" name="gender" value="male" required>female<input type="radio" name="gender" value="female"></td>
		</tr>
		<tr>
			<th>Email:</th>
			<td><input type="email" name="email" required></td>
		</tr>
		<tr>
			<th>Contact:</th>
			<td><input type="text" name="contact" pattern="[789]{1}[0-9]{9}" ></td>
		</tr>
		<tr>
			<th colspan="2">Employment Details</th>
	</tr>
		
		<tr>
			<th>Employment Type:</th>
			<td><input type="text" name="employment" required></td>
		</tr>
		<tr>
			<th>Annual Salary:</th>
			<td><input type="text" name="annualSalary" required></td>
		</tr>
		<tr>
			<th>Existing EMI:</th>
			<td><input type="text" name="existingEmi" required`></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="CheckEligibility"></td>
		</tr>
		
	</table>
	</form>
	
	<footer>
<jsp:include page="footer.jsp" /> 
</footer>
    
</body>
</html>