package com.files.handle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData_ColByCol_DB {

	public static void main(String[] args) throws SQLException {
		String sqldb_url = "jdbc:mysql://localhost:3307/company";
		String sqldb_uname = "root";
		String sqldb_pass = "admin";
		
		Connection db = DriverManager.getConnection(sqldb_url, sqldb_uname, sqldb_pass);
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");
		
		ResultSetMetaData rsm = rs.getMetaData();
		int cc = rsm.getColumnCount();
		
		for(int c=1;c<=cc;c++) {
			System.out.println(rsm.getColumnName(c));
			
			while(rs.next()) {
				System.out.println(rs.getString(c));
			}
			rs.beforeFirst();
		}

		db.close();
	}

}





