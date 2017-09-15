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
			<div class="w3-panel w3-padding-32">지역명 수정</div>
			<%
				List<CityDTO> cityList = CityDAO.getAllList();
				pageContext.setAttribute("cityList", cityList);
				String cityName = null;
				for(int i=0; i < cityList.size() ; i++){
					if(cityList.get(i).getCityNum() == Integer.parseInt(request.getParameter("cityNum").trim())){
						cityName = cityList.get(i).getCityName();
					}
				}
			%>
			<form action="${pageContext.request.contextPath}/manageCity"
				method="post">
				<table class="w3-table">
					<tr>
						<td>지역번호</td>
						<td><div class="w3-input w3-border"><%=request.getParameter("cityNum") %></div></td>
					</tr>
					<tr>
						<td>지역명</td>
						<td><input class="w3-input w3-border" type="text" name="cityName"
							value="${pageScope.concert.name}"></td>
					</tr>
				</table>
				<div class="w3-padding-32">
					<input type="submit" class="w3-button w3-green w3-round"
						value="수정완료"> <input type="reset"
						class="w3-button w3-green w3-round" value="원래대로"> <input
						class="w3-button w3-green w3-round" type="button" value="뒤로가기"
						Onclick="location.href='manageCity.jsp'">
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