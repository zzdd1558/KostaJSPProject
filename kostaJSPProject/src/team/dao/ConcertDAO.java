package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.dto.AdminDTO;
import team.dto.CityDTO;
import team.dto.ConcertDTO;
import team.utils.DBUtil;

public class ConcertDAO {
	
	/**
	 * 콘서트의 정보를 모두 SELECT해서 가져온다.
	 * 
	 * Query : SELECT
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : List<ConcertDTO>
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static List<ConcertDTO> getAllList() throws SQLException{
		
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT 	idx, name, place, start_date, end_date, start_time, running_time, cast, image_uri, admin_idx, CON.type_num, CON.city_num, CI.city_name, TY.type_name"
							+" FROM concert CON"
							+" INNER JOIN city CI ON CON.city_num = CI.city_num"
							+" INNER JOIN type TY  ON CON.type_num = TY.type_num";
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new ConcertDTO( rset.getInt(1),
									     rset.getString(2).trim(),
									     rset.getString(3).trim(),
									     rset.getString(4).trim(),
									     rset.getString(5).trim(),
									     rset.getString(6).trim(),
									     rset.getString(7).trim(),
									     rset.getString(8).trim(), 
									     rset.getString(9).trim(),
									     rset.getInt(10),
									     rset.getInt(11),
									     rset.getInt(12),
									     rset.getString(13).trim(),
									     rset.getString(14).trim() ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	
	/**
	 * 매개변수 idx로 하나의 콘서트 정보를 가져오는 메소드
	 * 
	 * Query : SELECT
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : ConcertDTO
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static ConcertDTO getJustOne(int idx) throws SQLException{
		
		ConcertDTO list = null;
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query =  "SELECT 	idx, name, place, start_date, end_date, start_time, running_time, cast, image_uri, admin_idx, CON.type_num, CON.city_num, CI.city_name, TY.type_name"
					+" FROM concert CON"
					+" INNER JOIN city CI ON CON.city_num = CI.city_num"
					+" INNER JOIN type TY  ON CON.type_num = TY.type_num"
					+" WHERE idx=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list = new ConcertDTO( rset.getInt(1),
					     rset.getString(2).trim(),
					     rset.getString(3).trim(),
					     rset.getString(4).trim(),
					     rset.getString(5).trim(),
					     rset.getString(6).trim(),
					     rset.getString(7).trim(),
					     rset.getString(8).trim(), 
					     rset.getString(9).trim(),
					     rset.getInt(10),
					     rset.getInt(11),
					     rset.getInt(12),
					     rset.getString(13).trim(),
					     rset.getString(14).trim());
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	

	/**
	 * 
	 * GetKindsOfAreaDataController servler에서 사용
	 * 
	 * 선택 지역의 모든 콘서트의 정보를 가져오는 메소드
	 * 
	 * Query : SELECT
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성
	 * 3. ResultSet 생성 
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : void
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static List<ConcertDTO> getKindsOfCityData(String commandQuery , int num) throws SQLException {
		
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = commandQuery;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);

			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new ConcertDTO( rset.getString(1).trim(),
									     rset.getString(2).trim(),
									     rset.getString(3).trim(),
									     rset.getString(4).trim(),
									     rset.getString(5).trim(),
									     rset.getString(6).trim(),
									     rset.getString(7).trim(),
									     rset.getString(8).trim(), 
									     rset.getString(9).trim(),
									     rset.getString(10).trim(),
									     rset.getInt(11)));
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return list;
	}

	
	/**
	 * 도시이름으로 검색 - 매개변수로 넘어온 값으로 콘서트를 조회한다
	 * 
	 * Query : SELECT
	 * 	- 넘어오는 매개변수 명 : String cityName
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : List<ConcertDTO>
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static List<ConcertDTO> getCityList(String cityName) throws SQLException{
		
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT * FROM concert WHERE city_name=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cityName);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new ConcertDTO( rset.getInt(1),
									     rset.getString(2).trim(),
									     rset.getString(3).trim(),
									     rset.getString(4).trim(),
									     rset.getString(5).trim(),
									     rset.getString(6).trim(),
									     rset.getString(7).trim(),
									     rset.getString(8).trim(), 
									     rset.getString(9).trim(),
									     rset.getInt(10),
									     rset.getInt(11),
									     rset.getInt(12) ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	/**
	 * 공연종류로 검색 - 매개변수로 넘어온 값으로 콘서트를 조회한다
	 * 
	 * Query : SELECT
	 * 	- 넘어오는 매개변수 명 : String typeName
	 * 
	 * 1. Connection 생성 
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송 
	 * 5. close() 
	 * 6. return type : List<ConcertDTO>
	 * 
	 * @throws SQLException
	 * 
	 */
	
	public static List<ConcertDTO> getTypeList(String typeName) throws SQLException{
		
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT * FROM concert WHERE type_num=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, typeName);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new ConcertDTO( rset.getInt(1),
									     rset.getString(2).trim(),
									     rset.getString(3).trim(),
									     rset.getString(4).trim(),
									     rset.getString(5).trim(),
									     rset.getString(6).trim(),
									     rset.getString(7).trim(),
									     rset.getString(8).trim(), 
									     rset.getString(9).trim(),
									     rset.getInt(10),
									     rset.getInt(11),
									     rset.getInt(12) ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	/**
	 * 콘서트 삽입 - 매개변수로 넘어온 콘서트 정보로 데이터 INSERT
	 * 
	 * Query : INSERT
	 * 	- 넘어오는 매개변수 명 : ConcertDTO concert
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
	
	public static void insert (ConcertDTO concert) throws SQLException{
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String query = "INSERT INTO concert VALUES (concert_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, concert.getName());
			pstmt.setString(2, concert.getPlace());
			pstmt.setString(3, concert.getStartDate());
			pstmt.setString(4, concert.getEndDate());
			pstmt.setString(5, concert.getStartTime());
			pstmt.setString(6, concert.getRunningTime());
			pstmt.setString(7, concert.getCast());
			pstmt.setString(8, concert.getImageUri());
			pstmt.setInt(9, concert.getAdminIdx());
			pstmt.setInt(10, concert.getTypeNum());
			pstmt.setInt(11, concert.getCityNum());
			
			
			int result = pstmt.executeUpdate();
			System.out.println("concert "+ result + "행 정상 삽입");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	
	/**
	 * 콘서트 수정 - 매개변수로 넘어온 콘서트 정보로 데이터 UPDATE
	 * 
	 * Query : INSERT
	 * 	- 넘어오는 매개변수 명 : ConcertDTO concert
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
	
	public static void update (ConcertDTO concert) throws SQLException{
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE concert SET name=?, place=?, start_date=?, end_date=?, start_time=?, running_time=?, cast=?, image_uri=?, type_num=?, city_num=? WHERE idx=?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, concert.getName());
			pstmt.setString(2, concert.getPlace());
			pstmt.setString(3, concert.getStartDate());
			pstmt.setString(4, concert.getEndDate());
			pstmt.setString(5, concert.getStartTime());
			pstmt.setString(6, concert.getRunningTime());
			pstmt.setString(7, concert.getCast());
			pstmt.setString(8, concert.getImageUri());
			pstmt.setInt(9, concert.getTypeNum());
			pstmt.setInt(10, concert.getCityNum());
			pstmt.setInt(11, concert.getIdx());
			
			int result = pstmt.executeUpdate();
			System.out.println("concert "+ result + "행 정상 수정");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	
	/**
	 * 콘서트 삭제 - 매개변수로 넘어온 idx로 콘서트 정보 삭제
	 * 
	 * Query : DELETE
	 * 	- 넘어오는 매개변수 명 : int idx
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
	
	public static void delete (int idx) throws SQLException{
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROm concert WHERE idx=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			int result = pstmt.executeUpdate();
			System.out.println("concert "+ result + "행 정상 삭제");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	
	
}
