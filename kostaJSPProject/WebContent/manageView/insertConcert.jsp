<%@page import="team.dao.AdminDAO"%>
<%@page import="team.dto.AdminDTO"%>
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
<meta charset="UTF-8">
<body>


	<!-- Top menu -->
	<jsp:include page="top.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1250px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center ">
			<div class="w3-panel w3-padding-32">공연 입력</div>
			<%
				/** city list option 에 사용하기 위해 호출*/
				List<CityDTO> cityList = CityDAO.getAllList();
				pageContext.setAttribute("cityList", cityList);

				/** type list option 에 사용하기 위해 호출  */
				List<TypeDTO> typeList = TypeDAO.getAllList();
				pageContext.setAttribute("typeList", typeList);
				
				/** admin list option 에 사용하기 위해 호출*/
				List<AdminDTO> adminList = AdminDAO.getAllList();
				pageContext.setAttribute("adminList", adminList);
			%>
			<form action="${pageContext.request.contextPath}/manageConcert"
				method="post">
				<table class="w3-table">
					<tr>
						<td>공연명</td>
						<td><input class="w3-input w3-border" type="text" name="name" required></td>
					</tr>
					<tr>
						<td>분류</td>
						<td><select class="w3-select w3-border" name="typeNum" required>
								<c:forEach items="${pageScope.typeList}" var="data">
									<option value="${data.typeNum}">${data.typeName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>지역</td>
						<td><select class="w3-select w3-border" name="cityNum" required>
								<c:forEach items="${pageScope.cityList}" var="data">
									<option value="${data.cityNum}">${data.cityName}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>장소</td>
						<td><input class="w3-input w3-border" type="text" name="place" required></td>
					</tr>
					<tr>
						<td>시작일</td>
						<td><input class="w3-input w3-border" type="text" name="startDate" required></td>
					</tr>
					<tr>
						<td>종료일</td>
						<td><input class="w3-input w3-border" type="text" name="endDate" required></td>
					</tr>
					<tr>
						<td>시작시간</td>
						<td><input class="w3-input w3-border" type="text" name="startTime" required></td>
					</tr>
					<tr>
						<td>진행시간</td>
						<td><input class="w3-input w3-border" type="text" name="runningTime" required></td>
					</tr>
					<tr>
						<td>출연진</td>
						<td><input class="w3-input w3-border" type="text" name="cast" required></td>
					</tr>
					<tr>
						<td>이미지URI</td>
						<td><input class="w3-input w3-border" type="text" name="imageUri" required></td>
					</tr>
					<tr>
						<td>관리자</td>
						<td><select class="w3-select w3-border" name="adminIdx" required>
								<c:forEach items="${pageScope.adminList}" var="data">
									<option value="${data.adminIdx}">${data.id}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
				<div class="w3-padding-32">
					<input type="submit" class="w3-button w3-green w3-round"
						value="입력완료"> <input type="reset"
						class="w3-button w3-green w3-round" value="초기화"> <input
						class="w3-button w3-green w3-round" type="button" value="뒤로가기"
						Onclick="location.href='manageConcert.jsp'">
				</div>
				<input type="hidden" name="command" value="insert">
				<input type="hidden" name="idx" value="0">
			</form>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp" />

		<!-- End page content -->
	</div>

</body>
</html>