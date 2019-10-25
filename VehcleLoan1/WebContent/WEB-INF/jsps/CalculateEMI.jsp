<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="../css/style.css"> 
 -->    
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 
 <style>
 

table,h1,h3{
margin-top: 50px;
text-align: center;
padding-bottom: 150px;
}
th{
text-align: left;}

#background{
position:absolute;
/* width: 100%;
 */z-index: -1;

}
.slider{
-webkit-appearance: none;
background:black;
width: 100%;
  height: 5px;
   outline: none;
  opacity: 0.7;
}

.slider:hover {
  opacity: 1;
}
.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 25px;
  height: 10px;

  background: white;
  cursor: pointer;
}

 input[type="text"],input[type="number"] {
 background-color: rgba(0,0,0,0);
 
border: 1px ;
border-radius: 4px;
}
#emi
{
 margin-top:50px;
width: 100%; 
z-index: 1;
}
 
 </style>

<script>
	function calculateEmi(){
var LoanAmount = document.getElementById("rangeInput").value;
var LoanTenure = document.getElementById("rangeInput1").value;
var RateOfInterest = document.getElementById("rangeInput2").value;
var emi;

RateOfInterest=(RateOfInterest/(12*100));

 emi= (LoanAmount*RateOfInterest*( (Math.pow(1+RateOfInterest,LoanTenure))/ ((Math.pow(1+RateOfInterest,LoanTenure)-1))));
emi = emi.toFixed(2);
var output = document.getElementById("demo");
output.innerHTML = emi;

}
</script>
</head>
<body>

<header>
<jsp:include page="header.jsp" /> 
</header>
<div id="background" ">
<img src="<c:url value="/resources/image/car.jpg" />" style="width:100%;">
</div>
<div id="emi">
 <form>
	<table>
	<tr>
		<th>Loan Amount:</th>
<!-- 	<td><input type="number" name="loanAmount" required></td>-->		
 		<td>
    		<input class="slider" id="rangeInput" value="20000" type="range" min="20000" max="10000000" step="1000" oninput="loanAmount.value=rangeInput.value"required />
    	</td>	
    	<td>	<input name="loanAmount" id="loanAamount" type="number" value="10000" min="0" max="10000000" step="1000" oninput="rangeInput.value=amount.value"required />
		</td>
 	</tr>
	<tr>
		<th>Loan Tenure:</th>
<!-- 	<td><input type="number" name="loanTenure"  min="12" max="84" required></td>-->		
 		<td>
		    <input class="slider" id="rangeInput1" type="range" min="12" max="84" value="12" oninput="tenureAmount.value=rangeInput1.value" />
    		</td>	
    	<td><input name="loanTenure" id="tenureAmount" type="number" value="12" min="12" max="84" oninput="rangeInput1.value=tenureAmount.value" />
 		</td>
 	</tr>
	<tr>
		<th>Rate of Interest:</th>
<!-- 	<td><input type="number" name="rateOfInterest"  value="9" required  readonly="true"></td>-->			<td>
			<input class="slider" id="rangeInput2" type="range" value="9" min="9" max="20" oninput="rangeAmount.value=rangeInput2.value" />
    		
    		</td>	
    	<td><input name="rateOfInterest" id="rangeAmount" type="number" value="9" min="9" max="20" oninput="rangeInput2.value=rangeAmount.value" />
 		</td>
	</tr>
	<tr>
		<td colspan="2"><button type="button" onclick="calculateEmi()">Calculate Emi</button></td>
	</tr>
	<tr>
	<th><p>Equated Monthly Installment (EMI) will be</p></th>
	<th><p id="demo"></p></th>
	
	</tr>
	
		
	</table>
	</form>
	</div>
	
<footer>
		<jsp:include page="footer.jsp" /> 
</footer>
    

</body>
</html>