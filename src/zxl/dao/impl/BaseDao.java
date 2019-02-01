package zxl.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BaseDao {
	
	private static final String url = "jdbc:mysql://localhost:3306/zxl_ts?useUnicode=true&characterEncoding=UTF8&useSSL=false";
	private static final String username = "root";
	private static final String password = "root";
	
	public PreparedStatement getPreparedStmt(String sql) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("未能获取PreparedStatement");
		}
	}
	
	public Statement getStmt() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("未能获取PreparedStatement");
		}
	}
	
	public StringBuilder insertSQL(String tableName, String[] columns) {
		StringBuilder inserSql = new StringBuilder(" INSERT INTO ");
		inserSql.append(tableName).append(" (");
		StringBuilder valueSql = new StringBuilder(" VALUES ( ");
		for (int i=0; i<columns.length; i++) {
			if (i == columns.length - 1) {
				inserSql.append(" ").append(columns[i]);
				valueSql.append(" ").append("?");
				continue;
			}
			inserSql.append(" ").append(columns[i]).append(",");
			valueSql.append(" ").append("?").append(",");
		}
		inserSql.append(" )");
		valueSql.append(" );");
		return inserSql.append(valueSql);
	}
	
	public StringBuilder deleteSql(String tableName) {
		StringBuilder deleteSql = new StringBuilder(" DELETE FROM ");
		deleteSql.append(tableName).append(" WHERE 1=1 ");
		return deleteSql;
	}
	
	public StringBuilder getSql(String tableName) {
		StringBuilder getSql = new StringBuilder(" SELECT * FROM ");
		getSql.append(tableName);
		getSql.append(" WHERE 1=1 ");
		return getSql;
	}
	
	
}
