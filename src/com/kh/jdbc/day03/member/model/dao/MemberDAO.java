package com.kh.jdbc.day03.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberDAO {

	private Properties prop;//멤버변수 선언
	public MemberDAO() {
		prop = new Properties();//멤버변수 초기화는 생성자 안에서!
		try {
			FileReader reader = new FileReader("resources/query.properties");
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Member> selectAll(Connection conn) {
		List<Member> mList = null;
		try {
			String sql = prop.getProperty("selectAll");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			mList = new ArrayList<Member>();
			while (rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}

	public List<Member> selectAllByName(Connection conn, String memberName) {
		String sql = prop.getProperty("selectAllByName");
		List<Member> mList = null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");
			ResultSet rset = pstmt.executeQuery();
			mList = new ArrayList<Member>();
			while (rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	
	public Member selectOneById(Connection conn, String memberId) {
		String sql = prop.getProperty("selectOneById");
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		// Class.forname();
		// Connection conn = DriverManager...
		int result = 0;

		String sql = prop.getProperty("insertMember");
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		// UPDATE MEMBER_TBL SET MEMBER_PWD=?, MEMBER_EMAIL=?, MEMBER_PHONE=?,
		// MEMBER_ADDRESS=?, MEMBER_HOBBY=? WHERE MEMBER_ID =?
		// Class.forName();
		// Connection conn =~~~ --->템플릿에 다 만들어놓음
		int result = 0;
		String sql = prop.getProperty("updateMember");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int dropMember(Connection conn, String memberId) {
		String sql = prop.getProperty("dropMember");
		int result = 0;
		 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Member logInMember(Connection conn, Member memberInfo) {
		String sql = prop.getProperty("logInMember");
		Member member = null;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getMemberId());
			pstmt.setString(2, memberInfo.getMemberPwd());
			ResultSet rset  = pstmt.executeQuery();
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

}
