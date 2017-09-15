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
	<div class="w3-main w3-content w3-padding"
		style="max-width: 1250px; margin-top: 100px">
		<div class="w3-row-padding w3-padding-16 w3-center ">
			<div class="w3-panel w3-padding-32">타입명 수정</div>
			<%
				List<TypeDTO> typeList = TypeDAO.getAllList();
				pageContext.setAttribute("typeList", typeList);
				String typeName = null;
				for(int i=0; i < typeList.size() ; i++){
					if(typeList.get(i).getTypeNum() == Integer.parseInt(request.getParameter("typeNum").trim())){
						typeName = typeList.get(i).getTypeName();
					}
				}
			%>
			<form action="${pageContext.request.contextPath}/manageType"
				method="post">
				<table class="w3-table">
					<tr>
						<td>타입번호</td>
						<td><div class="w3-input w3-border"><%=request.getParameter("typeNum")%></div></td>
					</tr>
					<tr>
						<td>타입명</td>
						<td><input class="w3-input w3-border" type="text" name="typeName" value="<%=typeName%>" required></td>
					</tr>
				</table>
				<div class="w3-padding-32">
					<input type="submit" class="w3-button w3-green w3-round" value="수정완료"> <input type="reset"
						class="w3-button w3-green w3-round" value="원래대로"> <input
						class="w3-button w3-green w3-round" type="button" value="뒤로가기"
						Onclick="location.href='manageType.jsp'">
				</div>
				<input type="hidden" name="command" value="update"> 
				<input type="hidden" name="typeNum" value="<%=request.getParameter("typeNum")%>">
			</form>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp" />

		<!-- End page content -->
	</div>

</body>
</html>