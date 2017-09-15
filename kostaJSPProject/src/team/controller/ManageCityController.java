package team.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.CityDAO;
import team.dto.CityDTO;

public class ManageCityController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/** 삽입, 수정, 삭제 종류*/
		String command = request.getParameter("command");
		
		switch(command){
			case "insert":
				insert(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "delete":
				break;
		}
		response.sendRedirect("manageView/manageCity.jsp");
	}
	

	/**
     * city 테이블 INSERT 메소드
     * 
     * Query : INSERT
     */
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			CityDAO.insert(new CityDTO(
					Integer.parseInt(request.getParameter("cityNum").trim()),
					request.getParameter("cityName").trim()
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * city 테이블 UPDATE 메소드
     * 
     * Query : UPDATE
     */
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			CityDAO.update(
					Integer.parseInt(request.getParameter("cityNum").trim()),
					request.getParameter("cityName").trim()
					);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	public void delete(int cityNum,HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			CityDAO.delete(cityNum);
		} catch (SQLException e) {
		}
	}
	*/
}
