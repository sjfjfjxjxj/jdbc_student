package com.kh.jdbc.day03.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDAO;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberService {
	
	
	private MemberDAO mDao;
	private JDBCTemplate jdbcTemplate;
	
	public MemberService() { //이걸 또 생성자로 담네잉... 생략하지 말기
		jdbcTemplate = JDBCTemplate.getDriverLoad();
		mDao = new MemberDAO();
	}
    
	public List<Member> selectAll() {
    	List<Member> mList = null;
//    	MemberDAO mDao = new MemberDAO();
//    	JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad(); //메소드마다 객체생성 안해도 된다!
    	Connection conn = jdbcTemplate.getConnection();          //-->메모리애낀다! -->위로 올려버려
    	mList = mDao.selectAll(conn);
    	//conn.close();
    	jdbcTemplate.close(conn);
    	
    	return mList;
    }
	
	public List<Member> selectAllByName(String memberName) {
		List<Member> mList = null;
		Connection conn = jdbcTemplate.getConnection();
		mList = mDao.selectAllByName(conn, memberName);
		return mList;
	}
	
	
	public Member selectOneById(String memberId) {
	    Connection conn = jdbcTemplate.getConnection();
	    Member member = mDao.selectOneById(conn,memberId);
	    jdbcTemplate.close(conn);
		return member;
	}
	
	
	public int insertMember(Member member) {
//		MemberDAO mDao = new MemberDAO();
//		JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
		Connection conn = jdbcTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		}else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	
	public int updateMember(Member member) {
		Connection conn = jdbcTemplate.getConnection();
		int result = mDao.updateMember(conn, member);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		}else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}

	public int dropMember(String memberId) {
		Connection conn = jdbcTemplate.getConnection();
		int result = mDao.dropMember(conn, memberId);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		}
		jdbcTemplate.rollback(conn);
		return result;
	}


}
