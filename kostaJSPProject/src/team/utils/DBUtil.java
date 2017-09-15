package team.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds;
	
	/** DBCP 설정 초기화 */
	static {
		try {
			Context initContext = new InitialContext();
			//
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			// web.xml <res-ref-name></res-ref-name> 값과 동일
			ds = (DataSource) envContext.lookup("jdbc/orcl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/** DBCP로 연결된 Connection 객체 반환*/
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/** Connection , Statement , ResultSet 객체 반환 메소드*/
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/** Connection , Statement 객체 반환하는 메소드*/
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
