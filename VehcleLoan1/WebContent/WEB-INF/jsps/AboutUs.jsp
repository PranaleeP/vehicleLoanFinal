<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#map{

margin-left: 5%;
margin-top:3%;
}
#address{
float:right;
color:#3d7a66;
margin-top:2%;
margin-right:10%;
}


</style>
</head>
<body>

<header>
<jsp:include page="header.jsp" /> 
</header>
 <h1>About Us</h1>
 <div id="address">
 <pre> 
 LTI (NSE: LTI) is a global technology consulting and digital solutions 
 company helping more than 360 clients succeed in a converging world. 
 With operations in 30 countries, we go the extra mile for our clients 
 and accelerate their digital transformation with LTI’s Mosaic platform 
 enabling their mobile, social, analytics, IoT and cloud journeys.
 
 Founded 20 years ago as the information technology arm of the 
 Larsen & Toubro group, our unique heritage gives us unrivaled 
 real-world expertise to solve the most complex challenges of 
 enterprises across all industries.
 
  Address:Plot No. EL-200, TTC Electronic Zone 
 Shil Phata - Mahape Road Kopar Khairane,
 MIDC Industrial Area,
 Mahape, Navi Mumbai, 
 Maharashtra 400710
 Phone: 022 6795 4545
 </pre>
 
 </div>
 <div id="map" style="width:40%;height:500px; "></div>

<script>
function myMap() {
  var myCenter = new google.maps.LatLng(19.1097,73.0293 );
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 16};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAhIbmowZMNQlsMMMXL0LO96rKHAxpdkVQ&callback=myMap"></script>
 
<footer>
<jsp:include page="footer.jsp" /> 
</footer>
</body>
</html>