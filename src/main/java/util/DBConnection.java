package util;

import java.sql.*;

public class DBConnection {
	public static void main(String[] args) {
		System.out.print(getDB());
	}

	public static Connection getDB() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
