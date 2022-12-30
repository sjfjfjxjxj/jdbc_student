package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {
    
	
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
	
	
	public List<Member> printAllByName(String memberName) {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAllByName(memberName);
		return mList;
	}


	public Member printOneById(String memberId) {
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}


	public int registerMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}
	
	public int modifyMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member); 
		return result;
	}


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
		return result; //int나(있냐없냐만) member로 담아와야해->다오로가
	}
	
	
}
