<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="AdminHeader.jsp" /> 
</header>
<table border=0px solid black>
    <tr>
		<th>User Name</th>
		<th>Aplication Id</th>
		<th>Age </th>
		<th>Gender</th>
		<th>Address</th>
		<th>State</th>
		<th>City</th>
		<th>Pin code</th>
		<th>Ttpe of Employment</th>
		<th>Annual Salary</th>
		<th>Existing Emi</th>
		</tr>
		 <c:forEach items="${pdList}" var="Application">
	<tr>
		<td>${Application.userName}</td>
		<td>${Application.applicationId}</td>
		<td>${Application.age}</td>
		<td>${Application.gender}</td>
		<td>${Application.address}</td>	
		<td>${Application.state}</td>
		<td>${Application.city}</td>
		<td>${Application.pincode}</td>
		<td>${Application.employment}</td>
		<td>${Application.annualSalary}</td>
		<td>${Application.existingEmi}</td>
		<td><a href="allDetails?uName=${Application.userName}&applicationId=${Application.applicationId}">View Application</a></td>
    </tr>
  </c:forEach>
</table>
<h3>${message}</h3>
</body>
</html>