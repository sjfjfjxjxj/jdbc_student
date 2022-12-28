package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentDAO {
    
	public List<Student> selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String sql = "SELECT * FROM STUDENT_TBL";
		//소스코드에 아이디랑 비번이 들어있음!--->보안취약!
		Student student = null;
		List<Student> sList = null;
		try {
			//1. 드라이ㅓ 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. db연결 생성
			Connection conn = DriverManager.getConnection(url,user,password);
			//3. 쿼리문 실행 준비(Statement 생성)
			Statement stmt = conn.createStatement();
			//4. 쿼리문 실행 및 결과 받기
			ResultSet rset =  stmt.executeQuery(sql);
			sList = new ArrayList<Student>(); //애들 넣어줄 공간[택배차] 할당!
			//후처리
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				sList.add(student); //상차! ★☆★이부분 잘 빼먹는대. 중요!
			
			}//얘가 실행되려면 컨트롤러 거쳐서 런으로 가야해
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
		
	}
	
	/**
	 * 데이터 삽입해서 sql로 보내기!
	 * @return
	 */
	public int insertStudent(Student student) {
		
		// 준비 완료
		
		//1. 드라이버 등록
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password ="student";
		
//		String sql = "INSERT INTO STUDENT_TBL VALUES("
//                     + "'"+student.getStudentId()+"',"
//                        + "'"+student.getStudentPwd()+"',"
//	                         + "'"+student.getStudentName()+"',"
//		                        + "'"+student.getGender()+"',"
//		                           + "'" +student.getAge()+","
//			                         	+ "'"+student.getEmail()+"',"
//			                        		+ "'"+student.getPhone()+"',"
//			                        			+ "'"+student.getAddress()+"',"
//			                         				+ "'"+student.getHobby()+"',"
//                                                     + "SYSDATE)";

//		이게 어떻게 이거랑 같아...? 뭐야??????????????? 뭔데이게 ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????  ?????????????????????????????
		String sql = "INSERT INTO STUDENT_TBL VALUES('"+student.getStudentId()+"','"+student.getStudentPwd()+"','"+student.getStudentName()+"','"+student.getGender()+"','"+student.getAge()+"','"+student.getEmail()+"','"+student.getPhone()+"','"+student.getAddress()+"','"+student.getHobby()+"',"+"SYSDATE)";
        //"INSERT INTO STUDENT_TBL
        //VALUES('A', 'B'...)"

		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			//쿼리문실행:DML(INSERT, UPDATE, DELETE)
			//executeUpdate():either (1) the row count for SQL DML statements 
			//or (2) 0 for SQL statements that return nothing ->성공하면 행 개수, 실패하면 0 리턴할거얏
			result = stmt.executeUpdate(sql); //★☆★꼮 int로 받음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
