package com.kh.jdbc.day03.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDAO;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberService {
	
	
	private MemberDAO mDao;
	//private JDBCTemplate jdbcTemplate;
	
	public MemberService() { //이걸 또 생성자로 담네잉... 생략하지 말기
		//jdbcTemplate = JDBCTemplate.getDriverLoad();
		              //스태틱은 클래스로 바로 접근 가능
		mDao = new MemberDAO();
	}
    
	/**
	 * 전체 조회 service
	 * @return List<Member>
	 */
	public List<Member> selectAll() {
    	List<Member> mList = null;
//    	MemberDAO mDao = new MemberDAO();
//    	JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad(); //메소드마다 객체생성 안해도 된다!
    	Connection conn = JDBCTemplate.getConnection();          //-->메모리애낀다! -->위로 올려버려
    	mList = mDao.selectAll(conn);
    	//conn.close();
    	JDBCTemplate.close(conn);
    	
    	return mList;
    }
	
	/**
	 * 이름으로 조회 service
	 * @param memberName
	 * @return List<Member>
	 */
	public List<Member> selectAllByName(String memberName) {
		List<Member> mList = null;
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectAllByName(conn, memberName);
		return mList;
	}
	
	/**
	 * 아이디로 조회 service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId) {
	    Connection conn = JDBCTemplate.getConnection();
	    Member member = mDao.selectOneById(conn,memberId);
	    //jdbcTemplate.close(conn);
		return member;
	}
	
	/**
	 * 가입 service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member) {
//		MemberDAO mDao = new MemberDAO();
//		JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	/**
	 * 수정 service
	 * @param member
	 * @return int
	 */
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.updateMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//jdbcTemplate.close(conn);
		return result;
	}

	/**
	 * 삭제 service
	 * @param memberId
	 * @return int
	 */
	public int dropMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.dropMember(conn, memberId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	/**
	 * 로그인
	 * @param memberInfo
	 * @return Member
	 */
	public Member logInMember(Member memberInfo) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = mDao.logInMember(conn,memberInfo);
		return member;
	}


}
