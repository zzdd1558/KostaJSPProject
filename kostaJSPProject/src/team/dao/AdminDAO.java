package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import team.dto.AdminDTO;
import team.utils.DBUtil;

public class AdminDAO {

	/**
     * Admin계정을 모두 SELECT 해서 가지고 온다.
     * 
     * Query : SELECT
     * 
     * 1. Connection 생성
     * 2. PreparedStatement 생성
     * 3. ResultSet 생성
     * 4. 쿼리 전송
     * 5. close()
     * 6. return type : List<AdminDTO> 
     * 
     * @throws SQLException
     */
	public static List<AdminDTO> getAllList() throws SQLException {

		List<AdminDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			String query = "SELECT * FROM admin";
			
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new AdminDTO(rset.getInt(1), rset.getString(2).trim(), rset.getString(3).trim(),
						rset.getString(4).trim(), rset.getString(5).trim()));
			}

		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	
	/**
     * AdminDTO객체를 매개변수로 받아 INSERT하는 메소드
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
	public static void insert(AdminDTO admin) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String query = "INSERT INTO admin VALUES (admin_SEQ.nextval,?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			pstmt.setString(3, admin.getPhoneNum());
			pstmt.setString(4, admin.getEmail());

			int result = pstmt.executeUpdate();
			System.out.println("admin " + result + "행 정상 삽입");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	
	/**
     * admin계정을 수정하는 메소드
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
	public static void update(String id, String password, String phoneNum, String email) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String query = "UPDATE admin SET password=?, phonenum=?, email=? WHERE id=?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, email);
			pstmt.setString(4, id);

			int result = pstmt.executeUpdate();
			System.out.println("admin " + result + "행 정상 수정");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	

	/**
     * admin계정을 삭제하는 메소드
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
	public static void delete(String id) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			String query = "DELETE FROM admin WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			int result = pstmt.executeUpdate();
			System.out.println("admin " + result + "행 정상 삭제");

		} finally {
			DBUtil.close(con, pstmt);
		}
	}

}
