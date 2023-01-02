package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {

	/**
	 * 전체회원 목록 출력
	 * 
	 * @return
	 */
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}

	/**
	 * 받은 이름과 같은 전체목록 출력
	 * 
	 * @param memberName
	 * @return
	 */
	public List<Member> printAllByName(String memberName) {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAllByName(memberName);
		return mList;
	}

	/**
	 * 받은 아이디와 매칭되는 목록 출력
	 * 
	 * @param memberId
	 * @return
	 */
	public Member printOneById(String memberId) {
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}
	
	
    /**
     * 가입받기
     * @param member
     * @return
     */
	public int registerMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}

	
	/**
	 * 해당 계정 요소 여러가지 수정하기
	 * @param member
	 * @return
	 */
	public int modifyMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result;
	}

	
	/**
	 * 아이디 받아서 삭제하기
	 * @param memberId
	 * @return
	 */
	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}

	/**
	 * 로그인정보
	 * @param member
	 * @return
	 */
	public int CheckInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.logInMember(member);
		return result; // int나(있냐없냐만) member로 담아와야해->다오로가
	}

}
