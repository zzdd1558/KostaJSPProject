package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
}
