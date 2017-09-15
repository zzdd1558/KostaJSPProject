<%@page import="team.dao.CityDAO"%>
<%@page import="team.dto.CityDTO"%>
<%@page import="java.util.List"%>
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
	<div class="w3-main w3-content w3-padding" style="max-width: 400px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center">
			<div class="w3-panel w3-padding-32">지역 관리</div>
			<%
				List<CityDTO> cityList = CityDAO.getAllList();
				pageContext.setAttribute("cityList", cityList);
			%>
			<table class="w3-table w3-bordered" style="font-size: small;">
				<tr>
					<th>지역번호</th>
					<th>지역명</th>
					<td></td>
				</tr>
				<c:forEach items="${pageScope.cityList}" var="data">
					<tr>
						<td>${pageScope.data.cityNum}</td>
						<td>${pageScope.data.cityName}</td>
						<td><a href="updateCity.jsp?cityNum=${pageScope.data.cityNum}">
								<button class="w3-button w3-green w3-round">수정</button>
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="w3-panel w3-padding-32">
				<form action="${pageContext.request.contextPath}/manageCity" method="post">
					<table class="w3-table w3-center">
						<tr>
							<td>지역명</td>
							<td><input class="w3-input w3-border" type="text" name="cityName" required></td>
						</tr>
					</table>
					<input type="hidden" name="cityNum" value="0">
					<input type="hidden" name="command" value="insert">
					<input type="submit" class="w3-button w3-indigo w3-round" value="추가하기">
				</form>
			</div>
		</div>

	</div>
	<div class="w3-main w3-content w3-padding" style="max-width: 1200px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center">
			<!-- Footer -->
			<jsp:include page="footer.jsp" />
		</div>
	</div>

</body>
</html>
