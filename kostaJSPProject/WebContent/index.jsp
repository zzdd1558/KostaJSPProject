<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./stylesheets/w3.css">
<link rel="stylesheet" href="./stylesheets/fonts_googleapis.css">
<link rel="stylesheet" href="./stylesheets/common.css" />
<script type="text/javascript" src="./javascripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./javascripts/startGetAllData.js"></script>
<script type="text/javascript" src="./javascripts/kindsOfAreaGetData.js"></script>
<body>
	<nav
		class="w3-sidebar w3-bar-block w3-card-2 w3-top w3-large w3-animate-left"
		style="display: none; z-index: 2; width: 20%; min-width: 300px;"
		id="mySidebar"></nav>

	<!-- Top menu -->
	<div class="w3-top">
		<div class="w3-white w3-xlarge"
			style="max-width: 1200px; margin: auto">
			<div class="w3-button w3-padding-16 w3-left" onclick="w3_open()"
				id="openNav">☰</div>
			<div class="w3-right w3-padding-16">
			<%-- login, logout Session check --%>
				<%
					if (session.getAttribute("id") == null) {
				%>
				<a href="adminLogin.jsp"> <img src="images/icons/login.png"
					style="height: 30px;">
				</a>
				<%
					} else {
				%>
				<a href="${pageContext.request.contextPath}/manageView/admin.jsp"> <img src="images/icons/admin.png"
					style="height: 30px;"></a>
				<a href="Logout"> <img src="images/icons/logout.png"
					style="height: 30px;"></a>
				<%
					}
				%>
			</div>

			<div class="w3-center w3-padding-16">
				<a href="/kostaJSPProject/index.jsp"><img src="images/icons/logo.png"
					style="width: 200px"></a>
			</div>
		</div>
	</div>


	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1200px; margin-top: 100px" data-content="content">
		<div id="div-content"></div>

		<footer class="w3-row-padding w3-padding-32">
			<div class="w3-third">
				<h3>Introduce</h3>
				<p>안녕하세요 이용진 , 최윤진입니다</p>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</div>

			<div class="w3-third">
				<h3>Creator</h3>
				<ul class="w3-ul w3-hoverable">
					<li class="w3-padding-16"><img
						src="images/creatorImages/yongjin.jpg"
						class="w3-left w3-margin-right" style="width: 70px;" alt="용진">
						<span class="w3-large">이용진</span><br> 휴대폰 : <span>010-3262-5257</span><br>
						이메일 : <span>lyj8270@naver.com</span></li>
					<li class="w3-padding-16"><img
						src="images/creatorImages/yunjin.jpg"
						class="w3-left w3-margin-right" style="width: 70px;" alt="윤진">
						<span class="w3-large">최 윤진</span><br> 휴대폰 : <span>010-7759-9183</span><br>
						이메일 : <span>zzdd1558@naver.com</span></li>
				</ul>
			</div>

			<div class="w3-third w3-serif">
				<h3>5강의실</h3>
				<p>
					<span class="w3-tag w3-black w3-margin-bottom">김 혜경</span> <span
						class="w3-tag w3-black w3-margin-bottom">박 주엽</span> <span
						class="w3-tag w3-dark-grey w3-small w3-margin-bottom">임 대호</span>
					<span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">이
						보영</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">김
						동근</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">김
						정규</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">홍
						민보</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">최
						순규</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">이
						용진</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">오
						주석</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">정
						태준</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">양
						현모</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">최
						윤진</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">김
						창욱</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">신
						승엽</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">이
						진선</span>
				</p>
			</div>
		</footer>
	</div>
</body>
</html>
