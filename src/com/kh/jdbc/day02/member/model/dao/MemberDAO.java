package com.kh.jdbc.day02.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day02.member.model.vo.Member;


public class MemberDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";		

	/**
	 * 전체회원 정보List<Member> 꺼내오기
	 * @return
	 */
	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER_TBL";
		Member member = null;
		List<Member> sList = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Member>(); //Member 하나가 가진 정보들을 담는 공간 마련!
			while(rset.next()) { //리절트셋이 존재하면 계속계속 꺼내와줘!
				member = new Member();
				//멤버클래스로 저장해서 리절트셋에서 꺼내오자
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getString("MEMBER_DATE"));
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
	
	/**
	 * 가입정보Member member 저장
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		                                              //물음표 위치가 인덱스값이 됨
//		String sql = "INSERT INTO MEMBER_TBL VALUES('"
//		                +member.getMemberId()+
//		                "','"+member.getMemberPwd()+
//		                "','"+member.getMemberName()+
//		                "','"+member.getMemberGender()+
//		                "','"+member.getMemberAge()+
//		                "','"+member.getMemberEmail()+
//		                "','"+member.getMemberPhone()+
//		                "','"+member.getMemberAddress()+
//		                "','"+member.getMemberHobby()+
//		                "',"+"DEFAULT)";                         
		//"INSERT INTO MEMBER_TBL VALUES('A', 'B', C) ";
		//홑따옴표지옥 안쓰고 PreparedStatement해볼거야
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			Statement stmt = conn.createStatement();
			// 시험문제☆ 셋뭐시기 메소드 순서는 상관이 없고 걍 위치홀더 인덱스값만 맞으면 됨
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby());
			//여기까지가 쿼리문 실행 준비(길다!)
//			result = stmt.executeUpdate(sql);
			result = pstmt.executeUpdate();
			//매개변수로 sql이 안들어간다! 컴파일할때(요위에) sql이 다 들어가서 필요없다
			conn.close();
//			stmt.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		// DML(INSERT, UPDATE, DELETE)은 executeUpdate() -> int 반환

	}
	
	public Member selectOneById(String memberId) {
		Member member = null;
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID ='"+ memberId+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			//입력받은 정보 아이디로 꺼내와서 출력용으로 가공하자
			if (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				//얘는 택배상자!
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
	
	public List<Member> selectAllByName(String memberName) {
		List<Member> mList = null;
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME ='"+ memberName+"'";		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			mList = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("Member_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				mList.add(member); //얘는 택배차!
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	public int deleteMember(String memberId) {
		//이렇게 전달값 있는애는 Statement보다 PreparedStatement가 낫지!
		int result = 0;
		//String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID='"+memberId+"'";
		String sql ="DELETE FROM MEMBER_TBL WHERE MEMBER_ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, memberId);
			//↑준비
			result = pstmt.executeUpdate();
			//↑실행
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateMember(Member member) {
		int result = 0;
		String sql = "UPDATE MEMBER_TBL SET MEMBER_PWD = '"+member.getMemberPwd()+"', MEMBER_EMAIL = '"+member.getMemberEmail()+"', MEMBER_PHONE = '"+member.getMemberPhone()+"', MEMBER_ADDRESS = '"+member.getMemberAddress()+"', MEMBER_HOBBY = '"+member.getMemberHobby()+"'WHERE MEMBER_ID ='"+member.getMemberId()+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	
	public int logInMember(Member member) {
		int result = 0;
		String sql = "SELECT COUNT(*) AS M_COUNT FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
		//SELECT COUNT(*) AS M_COUNT ☆우와!!!!!!!!!! 컬럼명이 있어야하니 별칭주기ㅇㅇ
		//FROM MEMBER_TBL
		//WHERE MEMBER_ID = 'A' AND MEMBER_PWD = 'B';
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("M_COUNT");
				
			}
			rset.close();
			pstmt.close();
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
	
}
