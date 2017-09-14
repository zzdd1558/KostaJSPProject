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
	
	public static List<AdminDTO> getAllList() throws SQLException{
		List<AdminDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from admin";
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new AdminDTO( rset.getInt(1),
									   rset.getString(2).trim(),
									   rset.getString(3).trim(),
									   rset.getString(4).trim(),
									   rset.getString(5).trim() ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static void insert(AdminDTO admin) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into admin values (?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, admin.getAdminIdx());
			pstmt.setString(2, admin.getId());
			pstmt.setString(3, admin.getPassword());
			pstmt.setString(4, admin.getPhoneNum());
			pstmt.setString(5, admin.getEmail());
			
			int result = pstmt.executeUpdate();
			System.out.println("admin 1행 정상 삽입");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void update(String id, String password, String phoneNum, String email) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "update admin set password=?, phonenum=?, email=? where id=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			int result = pstmt.executeUpdate();
			System.out.println("admin 1행 정상 수정");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	

}
