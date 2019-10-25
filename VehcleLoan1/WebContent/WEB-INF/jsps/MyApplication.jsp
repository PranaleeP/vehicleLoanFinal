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
table{text-align:center ;}
</style>
</head>
<body>
<header>
<jsp:include page="header.jsp" /> 
</header>
<br><br>
<table border=4px solid black>
    <tr>
		<th>User Name</th>
		<th>Aplication Id</th>
		<th>Loan Id</th>
		<th>Status</th>
		<th>description</th>
		<th>Date of Approval</th>
		<th>Loan Amount</th>
		<th>Monthly Emi</th>
		<th>View Application</th>
		</tr>
		
		<c:forEach items="${sd}" var="sdlist">
		<tr>
		<td>${sdlist.userName}</td>
		<td>${sdlist.applicationId}</td>
		<td>${sdlist.loanId}</td>
		<td>${sdlist.status}</td>	
		<td>${sdlist.description}</td>
		<td>${sdlist.dateofApproval}</td>
		<td>${sdlist.loanAmount}</td>
		<td>${sdlist.emi}</td>
		 <td><a href="viewApplication?uName=${sdlist.userName}&appId=${sdlist.applicationId}">View Details</a></td> --%>
    </tr>
  </c:forEach>
</table>
</body>
</html>