package com.kh.jdbc.day02.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day02.member.model.vo.Member;


public class MemberDAO {

	
	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER_TBL";
		Member member = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";		
		List<Member> sList = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Member>(); //Member 하나가 가진 정보들을 담는 공간 마련!
			while(rset.next()) { //리절트셋이 존재하면 계속계속 꺼내와줘!
				member = new Member();
				//멤버클래스로 저장해서 리절트셋에서 꺼내오자
				member.setMemberId(rset.getNString("MEMBER_ID"));
				member.setMemberPwd(rset.getNString("MEMBER_PWD"));
				member.setMemberName(rset.getNString("MEMBER_NAME"));
				member.setMemberGender(rset.getNString("MEMBER_GENDER"));
				member.setMemberAge(rset.getNString("MEMBER_AGE"));
				member.setMemberEmail(rset.getNString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getNString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getNString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getNString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getNString("MEMBER_DATE"));
				//
				sList.add(member); //전부다 꺼냈으면 실어 옮겨
			}
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
	
	public int insertMember(Member member) {
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String sql = "INSERT INTO MEMBER_TBL VALUES('"
		                +member.getMemberId()+
		                "','"+member.getMemberPwd()+
		                "','"+member.getMemberName()+
		                "','"+member.getMemberGender()+
		                "','"+member.getMemberAge()+
		                "','"+member.getMemberEmail()+
		                "','"+member.getMemberPhone()+
		                "','"+member.getMemberAddress()+
		                "','"+member.getMemberHobby()+
		                "',"+"DEFAULT)";                         
		//"INSERT INTO MEMBER_TBL VALUES('A', 'B',C) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public Member selectOneById(String memberId) {
		Member member = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String sql = "SELECT * FROM STUDENT_TBL WHERE MEMBER_ID ='"+ memberId+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			//입력받은 정보 아이디로 꺼내와서 출력용으로 가공하자
			if (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getNString("STUDENT_ID"));
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
		return member;
		
	}
	
	
	
}