package com.kh.jdbc.day00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCRun {
    public static void main(String [] args) {
    	/*
    	 *1. 드라이버 등록
    	 *2. dbms 연결--연결된상태
    	 *3. statement 객체 생성--쿼리문 실행 준비
    	 *4. sql 전송--쿼리문 실행된 상태
    	 *5. 결과값 받기--result set 받은 상태->후처리
    	 *6. 자원 해제(close())
    	 * 
    	 */
    	
    	try {
    		String url = "jdbc:oracle:thin:@localhost:1521:xe";
    		              //여기 오타안나게 조심하라. 안바뀜
    		String user = "KH";
    		String password = "KH";
    		String sql = "SELECT * FROM EMPLOYEE";
    		//1.드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			               //여기 오타안나게 조심하라. 안바뀜
			//2. DB연결 생성
			Connection conn = DriverManager.getConnection(url,user,password);
			//3. 쿼리문 실행준비(Statement 객체 생성)
			Statement stmt = conn.createStatement();
			//4. 쿼리문 실행
			ResultSet rset = stmt.executeQuery(sql);
			//후처리 - DB에서 가져온 데이터 사용
			while(rset.next()) {
				System.out.println("사원 아이디 : " + rset.getString("EMP_ID"));
			}                    //겟스트링메소드로 컬럼명 넘겨주면(컬럼번호가능) 필드값 나온다 
			// 자원 해제
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
