package com.kh.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

	private static Properties prop; //이거 선언하고 소스폴더우클릭->뉴->소스폴더->리소시스라는 이름 하나만들자
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "student";
	private static final String PASSWORD = "student";
	
//	private static JDBCTemplate instance; --->다 스태틱처리했으니까 얜 필요가 없다ⓐ
	private static Connection conn;
	private JDBCTemplate() {}
	
//	public JDBCTemplate() {
//		try {//생성자에 꼭 해줘야하는것 넣어주기--->이게 instance에 담기게끔ㅇㅇ
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public static JDBCTemplate getDriverLoad() {-->얘도 필요없ㄷⓑ
//		if(instance ==null) { //만약 제디비씨템플릿 타입의 객체가 없으면 
//			instance = new JDBCTemplate(); //객체를생성허고
//		}
//		return instance; //있으면 고대로 반환하라
//	}//---->딱 한번만 생성되게 하는 코드!
	

//	public static Connection getConnectionSingle() {
//		if(connection == null) {
//			connection = new Connection();
//		}
//		return connection;
//	}
	
	
	public static Connection getConnection() {
			try {                               
				prop = new Properties();//스트림 열어서 파일 읽어갖고...
				FileReader reader = new FileReader("resources/dev.properties");
				prop.load(reader);
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				if(conn == null || conn.isClosed()) { //이즈클로즈드 없으면 한번 실행하고 닫아버려서 오류남
					Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false); //오토커밋 해제하는 방법!
			} 
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		return conn;
	}
	
	//커밋
	public static void commit(Connection conn) {
		try {
			if(conn!=null && conn.isClosed())
			    conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//롤백
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && conn.isClosed())
		    	conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//연결해제
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
			    conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
