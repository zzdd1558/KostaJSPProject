package team.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.api.scripting.JSObject;
import team.dao.CityDAO;
import team.dto.CityDTO;


public class GetAllDataController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");
		StringBuilder sb = null;
		try {
			sb = new StringBuilder();
			sb.append("{\"first\":[ ");
			List<CityDTO> cityList = CityDAO.getAllList();
			for (int i = 0; i < cityList.size(); i++) {
				sb.append("{\"cityNum\":\"");
				sb.append(String.valueOf(cityList.get(i).getCityNum()));
				sb.append("\",\"cityName\":\"");
				sb.append(cityList.get(i).getCityName());
				if(i == cityList.size()-1){
					sb.append("\"}]}");
				}else{
					sb.append("\"},");	
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println(sb.toString());*/
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		
		
	}

}
