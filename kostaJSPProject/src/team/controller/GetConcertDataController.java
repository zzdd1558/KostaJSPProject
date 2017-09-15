package team.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");

		String command = request.getParameter("command");
		String queryData = null;
		if ("start".equals(command)) {
			String commandQuery = "select * from (  SELECT name, place , CI.city_name , TY.type_name ,start_date , end_date , start_time , running_time , cast , image_uri, CI.city_num FROM concert CON INNER JOIN city CI ON CON.city_num = CI.city_num INNER JOIN type TY  ON CON.type_num = TY.type_num    order by DBMS_RANDOM.RANDOM) where rownum <= ?";
			final int num = 12;
			try {
				List<ConcertDTO> resultList = ConcertDAO.getKindsOfCityData(commandQuery, num);
				queryData = resultConcertList(resultList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("area".equals(command)) {
			int cityNum = Integer.parseInt(request.getParameter("cityNum"));
			try {
				String commandQuery = "SELECT name, place , CI.city_name , TY.type_name ,start_date , end_date , start_time , running_time , cast , image_uri, CI.city_num FROM concert CON INNER JOIN city CI ON CON.city_num = CI.city_num INNER JOIN type TY  ON CON.type_num = TY.type_num   WHERE CON.city_num = ?";
				List<ConcertDTO> resultList = ConcertDAO.getKindsOfCityData(commandQuery,cityNum);
				queryData = resultConcertList(resultList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.getWriter().println(queryData);
		
	}

	private String resultConcertList(List<ConcertDTO> resultList) throws SQLException {

		// 사용자에게 보여줄 컬럼갯수
		final int ROW_QUARTER = 4;

		// 넘어온 데이터의 size
		int resultSize = resultList.size();

		// 데이터의 size를 row당 4개씩 표현해주기 위해 row의 갯수를 잡음.
		int rowCount = (int) (Math.ceil((double) resultSize / ROW_QUARTER));
		int columnCount = 0;
		StringBuilder sb = null;
		sb = new StringBuilder();

		/** JSON 데이터 가공하는부분 */
		sb.append("{ \"result\":[");
		for (int i = 0; i < rowCount; i++) {
			columnCount = (i + 1) * ROW_QUARTER;
			if (columnCount > resultSize) {
				columnCount = resultSize;
			}
			ConcertDTO dataDTO = null;
			sb.append("[");
			for (int j = i * ROW_QUARTER; j < columnCount; j++) {

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

				if (j == columnCount - 1) {
					sb.append("}");
				} else {
					sb.append("},");
				}
			}
			sb.append("\n");
			if (i == rowCount - 1) {
				sb.append("]");
			} else {
				sb.append("],");
			}
		}
		sb.append("]}");
		return sb.toString();
	}
}
