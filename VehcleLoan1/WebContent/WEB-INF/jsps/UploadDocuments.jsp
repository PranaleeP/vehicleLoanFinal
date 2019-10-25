<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table{

margin:auto;
}
th{
text-align:left;
}
h1{
text-align:center;
}
</style>
<script type="text/javascript">
window.history.forward();
function noBack() 
{ 
	window.history.forward();
	}
	function success()
	{
		alert("Form Submitted Successfully");
	}
</SCRIPT>
</head>
<body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">

<header>
<jsp:include page="header.jsp" /> 
</header>
<h1>Documents Upload</h1>

<form method="post" action="save" modelAttribute="uploadForm" enctype="multipart/form-data" 
onSubmit="return success()">
		 
		    <p style="text-align:center;">Select files to upload. Press Add button to add more file inputs.</p>
		 
	    <table id="fileTable">
		        <tr><th>Photo: </th>
		        
		            <td><input name="files" type="file" required /></td>
		        </tr>
		        <tr><th>Adhar Card: </th>
		            <td><input name="files" type="file" required /></td>
		        </tr>
		        <tr><th>PAN Card: </th>
		            <td><input name="files" type="file" required/></td>
		        </tr>
		        <tr><th>Salary Slip: </th>
		            <td><input name="files" type="file" required /></td>
		        </tr>
		        <tr>
		        <td colspan="2" style="float:center;">
		        <input type="submit" value="Upload" />
		        </td>
		        </tr>
		    </table>
		    <br/>
		</form>

<footer>
<jsp:include page="footer.jsp" /> 
</footer>
</body>

</html>