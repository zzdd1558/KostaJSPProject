<%@page import="team.dao.TypeDAO"%>
<%@page import="team.dto.TypeDTO"%>
<%@page import="team.dao.CityDAO"%>
<%@page import="team.dto.CityDTO"%>
<%@page import="team.dto.ConcertDTO"%>
<%@page import="java.util.List"%>
<%@page import="team.dao.ConcertDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<title>공연 관리</title>
<meta charset="UTF-8">
<body>


	<!-- Top menu -->
	<jsp:include page="top.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1250px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center ">
			<div class="w3-panel w3-padding-32">공연 수정</div>
			<%
				ConcertDTO concert = ConcertDAO.getJustOne(Integer.parseInt(request.getParameter("idx").trim()));
				pageContext.setAttribute("concert", concert);

				List<CityDTO> cityList = CityDAO.getAllList();
				pageContext.setAttribute("cityList", cityList);

				List<TypeDTO> typeList = TypeDAO.getAllList();
				pageContext.setAttribute("typeList", typeList);
			%>
			<form action="${pageContext.request.contextPath}/manageConcert"
				method="post">
				<table class="w3-table">
					<tr>
						<td>등록번호</td>
						<td><div class="w3-input w3-border">${pageScope.concert.idx}</div></td>
					</tr>
					<tr>
						<td>공연명</td>
						<td><input class="w3-input w3-border" type="text" name="name"
							value="${pageScope.concert.name}"></td>
					</tr>
					<tr>
						<td>분류</td>
						<td><select class="w3-select w3-border" name="typeNum">
								<option value="${pageScope.concert.typeNum}" disabled selected>${pageScope.concert.joinTypeName}</option>
								<c:forEach items="${pageScope.typeList}" var="data">
									<option value="${data.typeNum}">${data.typeName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>지역</td>
						<td><select class="w3-select w3-border" name="cityNum">
								<option value="${pageScope.concert.cityNum}" disabled selected>${pageScope.concert.joinCityName}</option>
								<c:forEach items="${pageScope.cityList}" var="data">
									<option value="${data.cityNum}">${data.cityName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>장소</td>
						<td><input class="w3-input w3-border" type="text"
							name="place" value="${pageScope.concert.place}"></td>
					</tr>
					<tr>
						<td>시작일</td>
						<td><input class="w3-input w3-border" type="text"
							name="startDate" value="${pageScope.concert.startDate}"></td>
					</tr>
					<tr>
						<td>종료일</td>
						<td><input class="w3-input w3-border" type="text"
							name="endDate" value="${pageScope.concert.endDate}"></td>
					</tr>
					<tr>
						<td>시작시간</td>
						<td><input class="w3-input w3-border" type="text"
							name="startTime" value="${pageScope.concert.startTime}"></td>
					</tr>
					<tr>
						<td>진행시간</td>
						<td><input class="w3-input w3-border" type="text"
							name="runningTime" value="${pageScope.concert.runningTime}"></td>
					</tr>
					<tr>
						<td>출연진</td>
						<td><input class="w3-input w3-border" type="text" name="cast"
							value="${pageScope.concert.cast}"></td>
					</tr>
					<tr>
						<td>이미지URI</td>
						<td><input class="w3-input w3-border" type="text"
							name="imageUri" value="${pageScope.concert.imageUri}"></td>
					</tr>
					<tr>
						<td>관리자</td>
						<td>${sessionScope.id}</td>
					</tr>
				</table>
				<div class="w3-padding-32">
					<input type="submit" class="w3-button w3-green w3-round"
						value="수정완료"> <input type="reset"
						class="w3-button w3-green w3-round" value="원래대로"> <input
						class="w3-button w3-green w3-round" type="button" value="뒤로가기"
						Onclick="location.href='manageConcert.jsp'">
				</div>
				<input type="hidden" name="command" value="update"> <input
					type="hidden" name="idx" value="${pageScope.concert.idx}">
				<input type="hidden" name="adminIdx"
					value="${pageScope.concert.adminIdx}">
			</form>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp" />

		<!-- End page content -->
	</div>

</body>
</html>