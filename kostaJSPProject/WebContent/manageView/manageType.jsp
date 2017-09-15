<%@page import="team.dao.TypeDAO"%>
<%@page import="team.dto.TypeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<title>타입 관리</title>
<meta charset="UTF-8">

<body>
	<!-- Top menu -->
	<jsp:include page="top.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding" style="max-width: 600px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center">
			<div class="w3-panel w3-padding-32">타입 관리</div>
			<%
				List<TypeDTO> typeList = TypeDAO.getAllList();
				pageContext.setAttribute("typeList", typeList);
			%>
			<table class="w3-table w3-bordered" style="font-size: small;">
				<tr>
					<th>타입번호</th>
					<th>타입명</th>
					<td></td>
					<td></td>
				</tr>
				<c:forEach items="${pageScope.typeList}" var="data">
					<tr>
						<td>${pageScope.data.typeNum}</td>
						<td>${pageScope.data.typeName}</td>
						<td><a href="updateType.jsp?typeNum=${pageScope.data.typeNum}">
								<button class="w3-button w3-green w3-round">수정</button>
						</a></td>
						<td>
							<form action="${pageContext.request.contextPath}/manageType" method="post">
								<input type="hidden" name="command" value="delete"> <input
									type="hidden" name="typeNum" value="${pageScope.data.typeNum}">
								<input type="button" class="w3-button w3-red w3-round"
									value="삭제">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="w3-panel w3-padding-32">
				<form action="${pageContext.request.contextPath}/manageType" method="post">
					<table class="w3-table w3-center">
						<tr>
							<td>타입명</td>
							<td><input class="w3-input w3-border" type="text" name="typeName" required></td>
						</tr>
					</table>
					<input type="hidden" name="typeNum" value="0">
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
