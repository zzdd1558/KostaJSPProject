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
	
	public static List<ConcertDTO> getAllList() throws SQLException{
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from concert";
		
		try {
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
									     rset.getInt(12) ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static List<ConcertDTO> getCityList(int cityNum) throws SQLException{
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from concert where city_num=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cityNum);
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
	
	public static List<ConcertDTO> getTypeList(int typeNum) throws SQLException{
		List<ConcertDTO> list = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from concert where type_num=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, typeNum);
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
	
	public static void insert (ConcertDTO concert) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into concert values (concert_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
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
	
	public static void update (int idx, String name, String place, String startDate, String endDate, String startTime, String runningTime, 
								String cast, String imageUri, int adminIdx, int typeNum, int cityNum) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "update concert set name=?, place=?, start_date=?, end_date=?, start_time=?, running_time=?, cast=?, image_uri=?, admin_idx=?, type_num=?, city_num=? where idx=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, place);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			pstmt.setString(5, startTime);
			pstmt.setString(6, runningTime);
			pstmt.setString(7, cast);
			pstmt.setString(8, imageUri);
			pstmt.setInt(9, adminIdx);
			pstmt.setInt(10, typeNum);
			pstmt.setInt(11, cityNum);
			pstmt.setInt(12, idx);
			
			int result = pstmt.executeUpdate();
			System.out.println("concert "+ result + "행 정상 수정");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	public static void delete (int idx) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from concert where idx=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			int result = pstmt.executeUpdate();
			System.out.println("concert "+ result + "행 정상 삭제");
			
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
	
	
}
