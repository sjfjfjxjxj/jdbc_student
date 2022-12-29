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
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	/**
	 * db에서 데이터 가져올수있게준비!
	 * 
	 * @return
	 */
	public List<Student> selectAll() {

		String sql = "SELECT * FROM STUDENT_TBL";
		// 소스코드에 아이디랑 비번이 들어있음!--->보안취약!
		Student student = null;
		List<Student> sList = null;
		try {
			// 1. 드라이ㅓ 등록
			Class.forName(DRIVER_NAME);
			// 2. db연결 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. 쿼리문 실행 준비(Statement 생성)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및 결과 받기
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>(); // 애들 넣어줄 공간[택배차] 할당!
			// 후처리
			while (rset.next()) {
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
				sList.add(student); // 상차! ★☆★이부분 잘 빼먹는대. 중요!

			} // 얘가 실행되려면 컨트롤러 거쳐서 런으로 가야해
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList; //컨트롤러에 있는 프린트올로 보낸다

	}

	public List<Student> selectAllByName(String studentName) {// 입력받은 이름이랑 같은 값 전부 리턴
		List<Student> sList = null;
		Student student = null;
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME ='" + studentName + "'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>(); // 항상 널이 아닌 상태...!
			while (rset.next()) {
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
				sList.add(student);
			}
			rset.close();
			conn.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;

	}

	public Student selectOneById(String studentId) {
		Student student = null;
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_ID ='" + studentId + "'";
		try {
			// 드라이버등록
			Class.forName(DRIVER_NAME);
			// db 연결객체 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// Statement생성, 쿼리문 실행준비 완료
			Statement stmt = conn.createStatement();
			// 쿼리문 실행, 결과 받기
			ResultSet rset = stmt.executeQuery(sql);
			// 후처리
			if (rset.next()) {
				
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
			}
			rset.close();
			conn.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student; // 얜 컨트롤러에 printOneBy로 감
	}

	/**
	 * 데이터 삽입해서 sql로 보내기!
	 * 
	 * @return
	 */
	public int insertStudent(Student student) {

		// 준비 완료

//		String sql = "INSERT INTO STUDENT_TBL VALUES("
//                     + "'"+student.getStudentId()+"',"
//                        + "'"+student.getStudentPwd()+"',"
//	                         + "'"+student.getStudentName()+"',"
//		                        + "'"+student.getGender()+"',"
//		                           + "'" +student.getAge()+","
//			                         	+ "'"+student.getEmail()+"',"
//			                        		+ "'"+student.getPhone()+"',"
//			                        			+ "'"+student.getAddress()+"'
//			                         				+ "'"+student.getHobby()+"',"
//                                                     + "SYSDATE)";

//		이게 어떻게 이거랑 같아...? 뭐야??????????????? 뭔데이게 ????????? 이해함!
		String sql = "INSERT INTO STUDENT_TBL VALUES('" + student.getStudentId() + "','" + student.getStudentPwd()
				+ "','" + student.getStudentName() + "','" + student.getGender() + "','" + student.getAge() + "','"
				+ student.getEmail() + "','" + student.getPhone() + "','" + student.getAddress() + "','"
				+ student.getHobby() + "'," + "SYSDATE)";
		// "INSERT INTO STUDENT_TBL VALUES('A', 'B'...)"; 틀 잊지말기☆★☆

		int result = 0;
		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 쿼리문실행:DML(INSERT, UPDATE, DELETE)
			// executeUpdate():either (1) the row count for SQL DML statements
			// or (2) 0 for SQL statements that return nothing ->성공하면 행 개수, 실패하면 0 리턴할거얏
			result = stmt.executeUpdate(sql); // ★☆★꼮 int로 받음
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public int deleteStudent(String studentId) {
		int result = 0;
		String sql = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID ='" +studentId+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int updateStudent(Student student) {
		int result = 0;
//		String sql = "UPDATE STUDENT_TBL SET "
//				+ "STUDENT_PWD = '"+student.getStudentPwd()+"', "
//						+ "EMAIL = '"+student.getEmail()+"', "
//								+ "PHONE = '"+student.getPhone()+"', "
//										+ "ADDRESS = '"+student.getAddress()+"', "
//												+ "HOBBY = '"+student.getHobby()+"' "
//														+ "WHERE STUDENT_ID = '"+student.getStudentId()+"'";
		String sql = "UPDATE STUDENT_TBL SET STUDENT_PWD = '"+student.getStudentPwd()+"', EMAIL = '"+student.getEmail()+"', PHONE = '"+student.getPhone()+"', ADDRESS = '"+student.getAddress()+"', HOBBY = '"+student.getHobby()+"'WHERE STUDENT_ID ='"+student.getStudentId()+"'";                  
		//"UPDATE STUDENT_TBL
		//SET STUDENT_PWD = '"+뭐+"',
		//    PHONE = '"+뭐+"',
		//WHERE STUDENT_ID = '"+뭐+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}









