package com.kh.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";
	
	private static JDBCTemplate instance;
//	private static Connection connection;
	
	public JDBCTemplate() {
		try {//생성자에 꼭 해줘야하는것 넣어주기--->이게 instance에 담기게끔ㅇㅇ
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JDBCTemplate getDriverLoad() {
		if(instance ==null) { //만약 제디비씨템플릿 타입의 객체가 없으면 
			instance = new JDBCTemplate(); //객체를생성허고
		}
		return instance; //있으면 고대로 반환하라
	}//---->딱 한번만 생성되게 하는 코드!
	

//	public static Connection getConnectionSingle() {
//		if(connection == null) {
//			connection = new Connection();
//		}
//		return connection;
//	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); //오토커밋 해제하는 방법!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void commit(Connection conn) {
		try {
			if(conn!=null && conn.isClosed())
			    conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection conn) {
		try {
			if(conn!=null && conn.isClosed())
		    	conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
