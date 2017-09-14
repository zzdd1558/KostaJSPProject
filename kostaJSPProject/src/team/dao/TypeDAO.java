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

}
