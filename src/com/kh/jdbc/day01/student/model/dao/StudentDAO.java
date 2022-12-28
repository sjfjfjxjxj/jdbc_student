package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
    
	public void selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String sql = "SELECT * FROM STUDENT_TBL";
		//소스코드에 아이디랑 비번이 들어있음!
		try {
			//1. 드라이ㅓ 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. db연결 생성
			Connection conn = DriverManager.getConnection(url,user,password);
			//3. 쿼리문 실행 준비(Statement 생성)
			Statement stmt = conn.createStatement();
			//4. 쿼리문 실행 및 결과 받기
			ResultSet rset =  stmt.executeQuery(sql);
			//후처리
			while(rset.next()) {
				System.out.println("ID : "+rset.getNString("STUDENT_ID")); //필드값 
			}//얘가 실행되려면 컨트롤러 거쳐서 런으로 가야해
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
