<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link  href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

</head>
<body>

<% String User=(String)session.getAttribute("userName");
 String normalUser=(String)session.getAttribute("userName");
 String temp="admin";%>
 <div class="topnav" id="myTopnav">
 
  <% 
if(temp.equals(User))
{%>
<!--   <a href="home" >Home</a> -->
      <a href="getUserList">User List</a>
  
  <a href="getApplicationList">Application List</a>
  
    <a href="getApprovedApplications">Approved Application</a>
        <a href="getRejectedApplications">Rejected Application</a>
    
  
 <a  href="logout">logOut</a>
 

<%} %>
</div>

</body>
</html>