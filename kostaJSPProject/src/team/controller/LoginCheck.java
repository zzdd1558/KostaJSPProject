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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = null;
		
		try {
			int result = AdminDAO.loginCheck(id, pw);
			
			if(result != 0){
				session = request.getSession();
				session.setAttribute("id", id);
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}else{
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
