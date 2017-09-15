package team.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.dao.CityDAO;
import team.dao.ConcertDAO;
import team.dto.CityDTO;
import team.dto.ConcertDTO;

public class GetConcertDataController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");
		int cityNum = Integer.parseInt(request.getParameter("cityNum"));
		StringBuilder sb = null;
		
		final int ROW_QUARTER = 4;
		
		try {
			sb = new StringBuilder();
			List<ConcertDTO> cityList = ConcertDAO.getKindsOfCityData(cityNum);
			
			
			/** JSON 데이터 가공하는부분 해야함*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
