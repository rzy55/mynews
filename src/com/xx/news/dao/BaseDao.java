package com.xx.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class BaseDao {

	public int excuteUpdate(String sql,Object... param) throws SQLException {
		Connection conn=DatabaseUtil.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);

		for(int i=0;i<param.length;i++) {
			pstmt.setObject(i+1, param[i]);
		}
		int result=pstmt.executeUpdate();
		return result;		
	}
	
	public ResultSet excuteQuery(String sql,Object... param) throws SQLException {
		Connection conn = DatabaseUtil.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=null;
		for(int i=0;i<param.length;i++) {
			pstmt.setObject(i+1, param[i]);
		}
		rs=pstmt.executeQuery();
		return rs;
		
	}
	
}
