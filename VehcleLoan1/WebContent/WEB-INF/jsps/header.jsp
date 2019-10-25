<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
 <link  href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<!-- <link rel="stylesheet" href="../css/style.css"> 
 --></head>
<body>
 <% String User=(String)session.getAttribute("userName");
 String normalUser=(String)session.getAttribute("userName");
 String temp="admin";%>
<div class="topnav" id="myTopnav">
<%if (User==null )
{%>
 <a href="home" >Home</a>
 <a href="about" >About Us</a>
 <a href="emiCalculatorPage" >Calculate EMI</a>
 <a href="checkE">check eligibility</a>
<a  href="login">login</a>
<a href="registerPage">Register</a>
<%} %>
 
   
<% 
if(User!=null)
{%>


<!--  <a href="documentsUploadPage">Upload Documents</a>
 -->
  <a href="home" >Home</a>
 <a href="about" >About Us</a>
 <a href="emiCalculatorPage" >Calculate EMI</a>
 <a href="checkE">check eligibility</a>
 <a href="appForm">Apply Now</a>
 <a  href="logout">logOut</a>
 
 
<%} %>


   
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <img src="../images/4.png" style="width:20px; height:20px" >
  </a>
</div>

 

<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
</body>
</html>