package team.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.ConcertDAO;
import team.dto.ConcertDTO;

public class ManageConcertController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		
		System.out.println(command);
		
		switch(command){
		case"insert":
			insert(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(Integer.parseInt(request.getParameter("idx").trim()),request, response);
			break;
		}
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			ConcertDAO.insert(new ConcertDTO(
					Integer.parseInt(request.getParameter("idx").trim()),
					request.getParameter("name"),
					request.getParameter("place"),
					request.getParameter("startDate"),
					request.getParameter("endDate"),
					request.getParameter("startTime"),
					request.getParameter("runningTime"),
					request.getParameter("cast"),
					request.getParameter("imageUri"),
					Integer.parseInt(request.getParameter("adminIdx").trim()),
					Integer.parseInt(request.getParameter("typeNum").trim()),
					Integer.parseInt(request.getParameter("cityNum").trim())
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("manageView/manageConcert.jsp");
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			ConcertDAO.update(new ConcertDTO(
					Integer.parseInt(request.getParameter("idx").trim()),
					request.getParameter("name"),
					request.getParameter("place"),
					request.getParameter("startDate"),
					request.getParameter("endDate"),
					request.getParameter("startTime"),
					request.getParameter("runningTime"),
					request.getParameter("cast"),
					request.getParameter("imageUri"),
					Integer.parseInt(request.getParameter("adminIdx").trim()),
					Integer.parseInt(request.getParameter("typeNum").trim()),
					Integer.parseInt(request.getParameter("cityNum").trim())
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("manageView/manageConcert.jsp");
	}
	public void delete(int idx,HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			ConcertDAO.delete(idx);
		} catch (SQLException e) {
		}
		response.sendRedirect("manageView/manageConcert.jsp");
	}
}




















