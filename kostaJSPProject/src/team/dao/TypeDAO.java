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
	
	public static List<TypeDTO> getAllList() throws SQLException{
		List<TypeDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from type";
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new TypeDTO( rset.getInt(1),
									  rset.getString(2).trim() ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static void insert (TypeDTO type) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into type values (type_SEQ.nextval,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, type.getTypeName());
			
			int result = pstmt.executeUpdate();
			System.out.println("type "+ result + "행 정상 삽입");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void update (int typeNum, String typeName) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "update type set type_name=? where type_num=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, typeName);
			pstmt.setInt(2, typeNum);
			
			int result = pstmt.executeUpdate();
			System.out.println("type "+ result + "행 정상 수정");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void delete (String typeName) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from type where type_name=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, typeName);
			
			int result = pstmt.executeUpdate();
			System.out.println("type "+ result + "행 정상 삭제");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

}
