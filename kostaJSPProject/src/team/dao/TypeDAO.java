package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.dto.TypeDTO;
import team.utils.DBUtil;

public class TypeDAO {

	/**
	 * 공연의 종류를 SELECT 해서 전부 가지고 온다.
	 * 
	 * Query : SELECT
	 * 
	 * 1. Connection 생성
	 * 2. PreparedStatement 생성 
	 * 3. ResultSet 생성
	 * 4. 쿼리 전송
	 * 5. close() 
	 * 6. return type : List<TypeDTO>
	 * 
	 * @throws SQLException
	 */
	
	public static List<TypeDTO> getAllList() throws SQLException {
		
		List<TypeDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			String query = "SELECT * FROM type";
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new TypeDTO(rset.getInt(1), rset.getString(2).trim()));
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	/**
	 * 공연의 종류를 추가하는 메소드
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
	 */
	
	public static void insert(TypeDTO type) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "INSERT INTO type VALUES (type_SEQ.nextval,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type.getTypeName());

			int result = pstmt.executeUpdate();
			System.out.println("type " + result + "행 정상 삽입");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	
	/**
	 * 공연의 데이터 값을 수정하는 메소드
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
	 */
	
	public static void update(int typeNum, String typeName) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "UPDATE type SET type_name=? WHERE type_num=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, typeName);
			pstmt.setInt(2, typeNum);

			int result = pstmt.executeUpdate();
			System.out.println("type " + result + "행 정상 수정");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	/**
	 * 공연의 데이터 값을 삭제하는 메소드
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
	 */

	public static void delete(String typeName) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM type WHERE type_name=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, typeName);

			int result = pstmt.executeUpdate();
			System.out.println("type " + result + "행 정상 삭제");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

}
