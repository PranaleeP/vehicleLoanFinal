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
</header><br><br>
<table border=4px solid black>
    <tr>
		<th>User Name</th>
		<th>Application Id</th>
		<th>Loan Id</th>
		<th>Status</th>
		<th>description</th>
		<th>Date of Rejection</th>
		</tr>
		
		<c:forEach items="${rejected}" var="status">
		<tr>
		<td>${status.userName}</td>
		<td>${status.applicationId}</td>
		<td>${status.loanId}</td>
		<td>${status.status}</td>	
		<td>${status.description}</td>
		<td>${status.dateofApproval}</td>
		<%-- <td><a href="appDetails?uName=${Application.userName}">View Details</a></td> --%>
    </tr>
  </c:forEach>
</table>
</body>
</html>