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
<%-- 콘서트 , 도시 , 타입 정보를 보여주는 페이지 --%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<body>
	<!-- Top menu -->
	<jsp:include page="top.jsp"/>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1200px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center " id="food">
			<div class="w3-third" style="height: 500px;">
			
				<div class="w3-panel w3-padding-32">공연 관리</div>
				<%
					/** 콘서트의 모든 정보를 가져와 pageContext에 concert key값으로 저장  */
					List<ConcertDTO> concertList = ConcertDAO.getAllList();
					pageContext.setAttribute("consertList", concertList);
				%>
				<table class="w3-table w3-bordered">
					<c:forEach begin="0" end="5" var="data">
					<tr>
						<td>${pageScope.consertList[data].name}</td>
						<td>${pageScope.consertList[data].place}</td>
					</tr>
					</c:forEach>
				</table>
				<div class="w3-panel w3-padding-32">
					<a href="manageConcert.jsp">
						<button class="w3-button w3-black w3-round">더보기</button>
					</a>
				</div>
				
			</div>
			<div class="w3-third" style="height: 600px;">
				<div class="w3-panel w3-padding-32">지역 관리</div>
				<%
					/** 지역에 대한 모든 정보를 가져와 pageContext에 cityList key값으로 저장*/
					List<CityDTO> cityList = CityDAO.getAllList();
					pageContext.setAttribute("cityList", cityList);
				%>
				<table class="w3-table w3-bordered">
					<c:forEach begin="0" end="5" var="data">
					<tr><td>
						${pageScope.cityList[data].cityNum}&nbsp;&nbsp;&nbsp;
						${pageScope.cityList[data].cityName}
					</td></tr>
					</c:forEach>
				</table>
				<div class="w3-panel w3-padding-32">
					<a href="manageCity.jsp">
						<button class="w3-button w3-black w3-round">더보기</button>
					</a>
				</div>
			</div>
			<div class="w3-third" style="height: 600px;">
				<div class="w3-panel w3-padding-32">타입 관리</div>
				<%
					/** 콘서트 종류에 대한 모든 정보를 가져와 pageContext에 typeList key 값으로 저장*/
					List<TypeDTO> typeList = TypeDAO.getAllList();
					pageContext.setAttribute("typeList", typeList);
				%>
				<table class="w3-table w3-bordered">
					<c:forEach begin="0" end="5" var="data">
					<tr><td>
						${pageScope.typeList[data].typeNum}&nbsp;&nbsp;&nbsp;
						${pageScope.typeList[data].typeName}
					</td></tr>
					</c:forEach>
				</table>
				<div class="w3-panel w3-padding-32">
					<a href="manageType.jsp">
						<button class="w3-button w3-black w3-round">더보기</button>
					</a>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</div>


</body>
</html>
