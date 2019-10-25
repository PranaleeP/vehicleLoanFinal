<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
		th{
		text-align: left;
		}
		a:visited {
	display: none;
}
		</style>
</head>
<body>
<header>
<jsp:include page="AdminHeader.jsp" /> 
</header>

<table border=0px solid black>
    <tr>
    <th colspan="2" style="text-align: center;">Personal Details</th>
    </tr>
    <tr>
    	<th>User Name</th>
    	<td>${user.userName}</td>
    </tr>
    <tr>
    	<th>Application Id</th>
<td>${pd.applicationId}</td>
</tr>
    <tr>
    	<th>Loan ID</th>
    	<td>${loanDetails.loanId}</td>
    </tr>
    <tr>
    	<th>First Name</th>
    	<td>${user.firstName}</td>
    </tr>
    <tr>
    	<th>Last Name</th>
    	<td>${user.lastName}</td>
    </tr>
    <tr>
    	<th>Email ID</th>
    	<td>${user.email}</td>
    </tr>
    <tr>
    	<th>Contact</th>
    	<td>${user.phoneNo}</td>
    </tr>
    <tr>
    	<th>Age</th>
<td>${pd.age}</td>
    </tr>
    <tr>
    	<th>Gender</th>
    	<td>${pd.gender}</td>
    </tr>
    <tr>
    	<th>Address</th>
    	<td>${pd.address}</td>	
    </tr>
    <tr>
    	<th>State</th>
    	<td>${pd.state}</td>
    </tr>
    <tr>
    	<th>City</th>
    	<td>${pd.city}</td>
    </tr>
    <tr>
    	<th>Pin Code</th>
    	<td>${pd.pincode}</td>
    </tr>
    <tr>
        <th colspan="2" style="text-align: center;">Employment Details</th>
    </tr>
    <tr>
    	<th>Type Of Employment</th>
    	<td>${pd.employment}</td>
    </tr>
    <tr>
    	<th>Annual Salary</th>
    	<td>${pd.annualSalary}</td>
    </tr>
    <tr>
    	<th>Exixting EMI</th>
    	<td>${pd.existingEmi}</td>
    </tr>
    <tr>
        <th colspan="2" style="text-align: center;">Vehicle Details</th>
    </tr>
    <tr>
    	<th>Vehicle Make</th>
    	<td>${loanDetails.vehicleMake}</td>
    </tr>
        <tr>
    	<th>Vehicle Model</th>
    <td>${loanDetails.vehicleModel}</td>
    </tr>
        <tr>
    	<th>Ex-Showroom Price</th>
    	<td>${loanDetails.exShowroomPrice }</td>
    </tr>
        <tr>
    	<th>Loan Amount</th>
    	<td>${loanDetails.loanAmount}</td>
    </tr>
    	    <tr>
    	<th>Loan Tenure</th>
    	<td>${loanDetails.loanTenure}</td>
    </tr>
        <tr>
    	<th>ROI</th>
    	<td>${loanDetails.ROI}</td>
    </tr>
    </table>
<button onclick="CheckEligibility()">check Eligibility</button>
<p id ="print"></p>
<form action="approveApplication" >
Description:<input type="text" name="description" required><br><br>
Status:<select name="status">
<option value="Approve" name="status">Approve</option>
<option  value="Reject" name="status">Reject</option>
</select><br><br>
<input type="submit" value="Submit"> 
</form>
	<script>
		function CheckEligibility(){

			var annualIncome = ${pd.annualSalary};
			var existingEmi = ${pd.existingEmi};
			annualIncome = annualIncome - (existingEmi*12);
			var totalEmi = (annualIncome * 0.43 * 7);
			if(${loanDetails.loanAmount}<totalEmi){ 
			alert( "This applicant is Eligible");
 				document.getElementById("approve").disabled = false;
				document.getElementById("reject").disabled =false;
			}
			else{
				alert( "This applicant is not Eligible");
				document.getElementById("reject").disabled = false;
			} 
		}
		</script>
</body>
</html>