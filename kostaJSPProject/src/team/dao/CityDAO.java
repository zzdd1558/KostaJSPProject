package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.dto.AdminDTO;
import team.dto.CityDTO;
import team.utils.DBUtil;

public class CityDAO {

	/**
	 * 도시의 정보를 전부 SELECT해서 가지고 온다
	 * 
	 * Query : SELECT
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : List<CityDTO>
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static List<CityDTO> getAllList() throws SQLException {
		
		List<CityDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			String query = "SELECT * FROM city";
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new CityDTO(rset.getInt(1), rset.getString(2).trim()));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	
	/**
	 * 도시를 추가하는 메소드
	 * 
	 * Query : INSERT
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. 쿼리 전송 
	 * 4. close() 
	 * 5. return type : void
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static void insert(CityDTO city) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String query = "INSERT INTO city VALUES (city_SEQ.nextval-1,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, city.getCityName());

			int result = pstmt.executeUpdate();
			System.out.println("city " + result + "행 정상 삽입");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	
	/**
	 * 도시의 정보를 수정하는 메소드
	 * 
	 * Query : UPDATE
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. 쿼리 전송 
	 * 4. close() 
	 * 5. return type : void
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static void update(int cityNum, String cityName) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE city SET city_name=? WHERE city_num=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cityName);
			pstmt.setInt(2, cityNum);

			int result = pstmt.executeUpdate();
			System.out.println("city " + result + "행 정상 수정");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	
	/**
	 * 도시의 정보를 삭제하는 메소드
	 * 
	 * Query : DELETE
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. 쿼리 전송 
	 * 4. close() 
	 * 5. return type : void
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static void delete(int cityNum) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM city WHERE city_num=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cityNum);

			int result = pstmt.executeUpdate();
			System.out.println("city " + result + "행 정상 삭제");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
