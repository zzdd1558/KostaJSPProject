<!-- 
	1. model1
		- jsp : view + controller + biz 혼용 개발
	2. model2
		-mvc라면 현 대세는 model2 방식
		- jsp : view
		- 
	 -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="team.utils.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dept");
		ResultSet rs = pstmt.executeQuery();

	%>

	<table border="1">
		<tr>
			<th>deptNo</th>
			<th>dName</th>
			<th>loc</th>
		</tr>
		<c:forEach var="list" items="${ pageScope.list }">
			<tr>
				<td>${ list.deptNo }</td>
				<td>${ list.dName }</td>
				<td>${ list.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>