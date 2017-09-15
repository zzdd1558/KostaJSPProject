package team.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		/** insert , update , delete 종류*/
		String command = request.getParameter("command");
		
		switch(command){
			case"insert":
				insert(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
		}
		
		//데이터 처리후 manageConcert.jsp 페이지로 redirect
		response.sendRedirect("manageView/manageConcert.jsp");
	}
	
	/** Concert 테이블에 데이터 INSERT 하는 메소드 */
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
		
	}
	
	/** Concert 테이블에 데이터 UPDATE 하는 메소드 */
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
	}
	
	
	// 넘어온 getParameter("table") 에 따라 삭제되는 부분. 
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			response.setContentType("text/text; charset=UTF-8");
			String table = request.getParameter("table");
			int idx = Integer.parseInt(request.getParameter("idx").trim());
			
			
			/** 삭제할 부분이 추가된다면
			* 삭제할 부분의 태그 id = removeBtn
			* 아래 보이는 3개의 속성을 태그에 추가해주면 된다.
			* $(this).attr("data-command");
			* $(this).attr("data-idx");
			 $(this).attr("data-table");*/
			
			//table이 concert이면 concert 테이블 삭제
			if("concert".equals(table)){
				ConcertDAO.delete(idx);
			}
			
			
		} catch (SQLException e) {
		}
		
		/** 삭제후 alert로 띄어줄 Message */
		response.getWriter().println("삭제되었습니다.");
	}
}




















