package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopConnention {
	static final private String url="jdbc:mysql://localhost:3306/spring_shop";
	static final private String user="root";
	static final private String pw="mysql";
	static final private String driver="com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn=null;
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, pw);
		return conn;
	}
	//���� �׽�Ʈ�Ҷ��� ���
//	public static void main(String[]args) {
//		try {
//			System.out.println(ShopConnention.getConnection());
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	} 
}
