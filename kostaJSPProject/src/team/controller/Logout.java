package team.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/** 세션을 얻어온다 세션이 없다면 생성 안하고 null */
		HttpSession session = request.getSession(false);
		
		/** session이 null이 아니면 세션 초기화후 null로 변경*/
		if(session != null){
			session.invalidate();
			session = null;
		}
		
		//로그아웃후 index.jsp로 redirect
		response.sendRedirect("index.jsp");
	}
}
