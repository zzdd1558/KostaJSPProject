package team.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.TypeDAO;
import team.dto.TypeDTO;

public class ManageTypeController extends HttpServlet {
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
			break;
		}
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			TypeDAO.insert(new TypeDTO(
					Integer.parseInt(request.getParameter("typeNum").trim()),
					request.getParameter("typeName").trim()
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("manageView/manageType.jsp");
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			TypeDAO.update(
					Integer.parseInt(request.getParameter("typeNum").trim()),
					request.getParameter("typeName").trim()
					);

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("manageView/manageType.jsp");
	}
	
//	public void delete(int typeNum,HttpServletRequest request, HttpServletResponse response) throws IOException{
//		try {
//			TypeDAO.delete(typeNum);
//		} catch (SQLException e) {
//		}
//		response.sendRedirect("manageView/manageConcert.jsp");
//	}
}
