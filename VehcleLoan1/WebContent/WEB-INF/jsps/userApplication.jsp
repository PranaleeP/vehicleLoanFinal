<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $("#btnPrint").live("click", function () {
            var divContents = $("#dvContainer").html();
            var printWindow = window.open('', '', 'height=400,width=800');
            printWindow.document.write('<html><head><title>Loan Application</title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        });
    </script>
</head>
<body>
<form id="form1">
  <div id="dvContainer">
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
    <tr>
    	<th>Application Status</th>
    	<td>${sd.status}</td>
    </tr>
    <tr>
    	<th>Description</th>
    	<td>${sd.description}</td>
    </tr>
    <tr>
    	<th>Loan Amount </th>
    	<td> ${sd.loanAmount}</td>
    </tr>
    <tr>
    	<th>EMI </th><td>${sd.emi}</td>
    </tr>
    </table>
  </div>
 <input type="button" value="Print " id="btnPrint" />
    </form>
</body>
</html>