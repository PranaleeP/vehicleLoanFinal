<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employees Details</h1>

<table border=1px solid black>
    <tr>
		<th>EMP ID</th>
		<th>FIRST NAME</th>
		<th>LAST NAME</th>
		<th>EMAIL </th>
		<th>HIRE DATE</th>
		<th>JOB ID</th>
	</tr>
	<tr>
				<td>${requestScope.empList.empId}</td>
		
		<td>${requestScope.empList.firstName}</td>
				<td>${requestScope.empList.lastName}</td>
		
				<td>${requestScope.empList.email}</td>
		
				<td>${requestScope.empList.hireDate}</td>
		
				<td>${requestScope.empList.jobId}</td>
		
		
		
	</tr>	
	</table>
	<a href="empList">Back</a>
</body>
</html>