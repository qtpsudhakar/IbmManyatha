package com.files.handle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteData_DB {

	public static void main(String[] args) throws SQLException {
		String sqldb_url = "jdbc:mysql://localhost:3307/company";
		String sqldb_uname = "root";
		String sqldb_pass = "admin";

		Connection db = DriverManager.getConnection(sqldb_url, sqldb_uname, sqldb_pass);
		Statement st = db.createStatement();
		
		st.execute("INSERT INTO emp VALUES (32, 'ibmin',100,20000);");
		//ResultSet rs = st.executeQuery("select * from emp");

		db.close();
	}

}
