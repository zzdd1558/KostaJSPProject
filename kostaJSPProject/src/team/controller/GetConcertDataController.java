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
		
		
		
		try {
			sb = new StringBuilder();
			
			/**
			 * resultList를 통해 가져와야할 값
			 * Type : Concert DTO
			 *  변수 : 
			 * 		String name;
			 * 		String place;
			 * 		String joinCityName
			 * 		String joinTypeName
			 * 		String startDate
			 * 		String endDate
			 * 		String startTime
			 * 		Start runningTime
			 * 		String cast
			 * 		String imageUri
			 * 
			 * */
			List<ConcertDTO> resultList = ConcertDAO.getKindsOfCityData(cityNum);
			
			// 사용자에게 보여줄 컬럼갯수
			final int ROW_QUARTER = 4;
			
			// 넘어온 데이터의 size
			int resultSize = resultList.size();
			
			// 데이터의 size를 row당 4개씩 표현해주기 위해 row의 갯수를 잡음.
			int rowCount = (int)(Math.ceil((double)resultSize / ROW_QUARTER));
			int columnCount=0;
			
			/** JSON 데이터 가공하는부분*/
			sb.append("{ \"result\":[");
			for (int i = 0; i < rowCount; i++) {
				columnCount = (i+1) * ROW_QUARTER;
				if(columnCount > resultSize){
					columnCount = resultSize;
				}
				ConcertDTO dataDTO = null;
				sb.append("[");
				for (int j = i* ROW_QUARTER; j < columnCount; j++) {
					
					dataDTO = resultList.get(j);
					
					sb.append("{\"name\":\"" + dataDTO.getName() + "\"");
					sb.append(",\"place\":\"" + dataDTO.getPlace() + "\"");
					sb.append(",\"cityName\":\"" + dataDTO.getJoinCityName() + "\"");
					sb.append(",\"typeName\":\"" + dataDTO.getJoinTypeName() + "\"");
					sb.append(",\"startDate\":\"" + dataDTO.getStartDate() + "\"");
					sb.append(",\"endDate\":\"" + dataDTO.getEndDate() + "\"");
					sb.append(",\"startTime\":\"" + dataDTO.getStartTime() + "\"");
					sb.append(",\"runningTime\":\"" + dataDTO.getRunningTime() + "\"");
					sb.append(",\"cast\":\"" + dataDTO.getCast() + "\"");
					sb.append(",\"imageUri\":\"" + dataDTO.getImageUri() + "\"");
					sb.append(",\"cityNum\":\"" + dataDTO.getCityNum() + "\"");
					
					
					if(j == columnCount-1){
						sb.append("}");
					}else{
						sb.append("},");
					}
				}
				sb.append("\n");
				if(i == rowCount-1){
					sb.append("]");	
				}else{
					sb.append("],");
				}
			}
			sb.append("]}");
			System.out.println(sb.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println(sb.toString());
	}

}
