package team.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.dao.AdminDAO;

public class LoginCheck extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터로 넘어온  값 저장.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = null;
		
		try {
			
			/** 아이디와 비번으로 조회시 일치하면  : 1 불일치 : 0*/
			int result = AdminDAO.loginCheck(id, pw);
			
			if(result != 0){
				
				/** 세션 있어도 생성 없어도 생성. */
				session = request.getSession();
				
				/** 세션에 key:id value: id값 담음.*/
				session.setAttribute("id", id);
				response.sendRedirect("manageView/admin.jsp");
			}else{
				
				//로그인 실패시 index.jsp로 이동
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}