<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<title>관리자 페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/fonts_googleapis.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/removdData.js"></script>
<body>

	<!-- Top menu -->
	<div class="w3-top">
		<div class="w3-white w3-xlarge"
			style="max-width: 1200px; margin: auto">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
			<div class="w3-right w3-padding-16">
				<a href="../Logout"> <img src="../images/icons/logout.png"
					style="height: 30px;">
				</a>
			</div>
			<div class="w3-center w3-padding-16">
				<a href="admin.jsp"> 
					<img src="../images/icons/logo.png"	style="width: 200px">
				</a>
			</div>
		</div>
	</div>
	<!-- Sidebar (hidden by default) -->
	<nav
		class="w3-sidebar w3-bar-block w3-card-2 w3-top w3-xlarge w3-animate-left"
		style="display: none; z-index: 2; width: 20%; min-width: 300px;"
		id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()"
			class="w3-button w3-right">x</a> 
			
			<a
			href="${pageContext.request.contextPath}/index.jsp"
			onclick="w3_close()" class="w3-bar-item w3-button">메인으로</a>
			
			<a
			href="${pageContext.request.contextPath}/manageView/manageConcert.jsp"
			onclick="w3_close()" class="w3-bar-item w3-button">공연 관리</a> <a
			href="${pageContext.request.contextPath}/manageView/manageCity.jsp"
			onclick="w3_close()" class="w3-bar-item w3-button">지역 관리</a> <a
			href="${pageContext.request.contextPath}/manageView/manageType.jsp"
			onclick="w3_close()" class="w3-bar-item w3-button">타입 관리</a>
			
	
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
