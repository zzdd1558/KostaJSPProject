package team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.dto.AdminDTO;
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
	
	
	
	
	
	

}
