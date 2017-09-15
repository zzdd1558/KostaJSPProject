<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../stylesheets/w3.css">
<link rel="stylesheet" href="../stylesheets/fonts_googleapis.css">
<link rel="stylesheet" href="../stylesheets/common.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="../javascripts/jquery-3.2.1.min.js"></script>
<body>

	<!-- Sidebar (hidden by default) -->
	<nav
		class="w3-sidebar w3-bar-block w3-card-2 w3-top w3-xlarge w3-animate-left"
		style="display: none; z-index: 2; width: 20%; min-width: 300px;" id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-right">x</a> 
		
		<a href="${pageContext.request.contextPath}/manageView/manageConcert.jsp" onclick="w3_close()" class="w3-bar-item w3-button">공연 관리</a>
		<a href="${pageContext.request.contextPath}/manageView/manageCity.jsp" onclick="w3_close()" class="w3-bar-item w3-button">지역 관리</a>
		<a href="${pageContext.request.contextPath}/manageView/manageType.jsp" onclick="w3_close()" class="w3-bar-item w3-button">타입 관리</a>
	</nav>

	<script>
		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
		}
	</script>

</body>
</html>
