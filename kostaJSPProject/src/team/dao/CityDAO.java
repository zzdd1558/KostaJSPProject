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
	
	public static List<CityDTO> getAllList() throws SQLException{
		List<CityDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from city";
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				list.add(new CityDTO( rset.getInt(1),
									  rset.getString(2).trim() ));
				System.out.println("num : " + rset.getInt(1) + " , name : " + rset.getString(2).trim());
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static void insert (CityDTO city) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into city values (city_SEQ.nextval,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, city.getCityName());
			
			int result = pstmt.executeUpdate();
			System.out.println("city "+ result + "행 정상 삽입");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void update (int cityNum, String cityName) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "update city set city_name=? where city_num=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cityName);
			pstmt.setInt(2, cityNum);
			
			int result = pstmt.executeUpdate();
			System.out.println("city "+ result + "행 정상 수정");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void delete (String cityName) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from city where city_name=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cityName);
			
			int result = pstmt.executeUpdate();
			System.out.println("city "+ result + "행 정상 삭제");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
}
