<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>EMPLOYEES LIST</h1>

<table border=1px solid black>
    <tr>
		<th>EMP ID</th>
		<th>FIRST NAME</th>
		<th>Operations</th>
		</tr>
		 <c:forEach items="${requestScope.empList}" var="emp">
	<tr>
		<td>${emp.empId}</td>
				<td>${emp.firstName}</td>
			<td><a href="empDetails?id=${emp.empId}">View Details</a></td>
    </tr>
  </c:forEach>
</table>




</body>
</html>