<%@page import="team.dao.TypeDAO"%>
<%@page import="team.dto.TypeDTO"%>
<%@page import="team.dao.CityDAO"%>
<%@page import="team.dto.CityDTO"%>
<%@page import="team.dto.ConcertDTO"%>
<%@page import="java.util.List"%>
<%@page import="team.dao.ConcertDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<title>공연 관리</title>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../stylesheets/w3.css">
<link rel="stylesheet" href="../stylesheets/fonts_googleapis.css">
<link rel="stylesheet" href="../stylesheets/common.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="../javascripts/jquery-3.2.1.min.js"></script>
<body>

	
	<!-- Top menu -->
	<jsp:include page="top.jsp"/>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1250px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center ">
			<div class="w3-panel w3-padding-32">공연 관리</div>
			<%
				List<ConcertDTO> concertList = ConcertDAO.getAllList();
				pageContext.setAttribute("concertList", concertList);
			%>
			<table class="w3-table w3-bordered" style="font-size:small;">
				<tr>
					<th>공연명</th>
					<th>분류</th>
					<th>지역</th>
					<th>장소</th>
					<th>시작일</th>
					<th>종료일</th>
					<td></td>
					<td></td>
				</tr>
				<c:forEach items="${pageScope.concertList}" var="data">
					<tr>
						<td>${pageScope.data.name}</td>
						<td>${pageScope.data.joinTypeName}</td>
						<td>${pageScope.data.joinCityName}</td>
						<td>${pageScope.data.place}</td>
						<td>${pageScope.data.startDate}</td>
						<td>${pageScope.data.endDate}</td>
						<td>
							<a href="updateConcert.jsp?idx=${pageScope.data.idx}">
							<button class="w3-button w3-green w3-round">수정</button>
							</a>
						</td>
						<td>
							<a href="#">
							<button class="w3-button w3-red w3-round">삭제</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="w3-panel w3-padding-32">
				<button class="w3-button w3-indigo w3-round">추가하기</button>
			</div>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp"/>

		<!-- End page content -->
	</div>

	

</body>
</html>
