package util;





import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class jdbctest {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn =  DatabaseUtil.getConnection();
			String sql="select * from news";
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("内容："+rs.getString("ntitle")+"\t"+
						           "时间："+rs.getDate("ncreateDate"));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		try {
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeAll(conn, pstmt, rs);
		}
		
	}
}
