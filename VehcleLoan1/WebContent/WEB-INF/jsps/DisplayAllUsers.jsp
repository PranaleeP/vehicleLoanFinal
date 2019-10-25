<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link  href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="AdminHeader.jsp" /> 
</header>
<%--  <% String User=(String)session.getAttribute("userName");
 String normalUser=(String)session.getAttribute("userName");
 String temp="admin";%>
 <div class="topnav" id="myTopnav">
 
  <% 
if(temp.equals(User))
{%>
  <!-- <a href="home" >Home</a> -->
      <a href="getUserList">User List</a>
  
  <a href="getApplicationList">Application List</a>
  
    <a href="#">Approved Application</a>
        <a href="#">Rejected Application</a>
    
  
 <a  href="logout">logOut</a>
 

<%} %>
</div> --%>
<table border=0px solid black>
    <tr>
		<th>User Name</th>
		<th>First Name </th>
		<th>Last Name</th>
		<th>Email Id</th>
		<th>contact</th>
		</tr>
		 <c:forEach items="${appList}" var="Application">
	<tr>
		<td>${Application.userName}</td>
		<td>${Application.firstName}</td>
		<td>${Application.lastName}</td>
		<td>${Application.email}</td>	
		<td>${Application.phoneNo}</td>
		<%-- <td><a href="appDetails?uName=${Application.userName}">View Details</a></td> --%>
    </tr>
  </c:forEach>
</table>

</body>
</html>