package com.kh.jdbc.day03.member.controller;

import java.util.List;

import com.kh.jdbc.day03.member.model.service.MemberService;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberController {

	private MemberService mService;
	
	public MemberController() {
	    mService = new MemberService(); //까먹지말기. 널포인트익셉션의 주요원인ㅠ
	}
	
	/**
	 * 전체회원조회
	 * @return List<Member>
	 */
	public List<Member> printAll() {
		List<Member> mList = mService.selectAll();
		return mList;
	}
	
	/**
	 * 이름으로 계정 조회
	 * @param memberName
	 * @return List<Member>
	 */
	public List<Member> printAllByName(String memberName){
		List<Member> mList = mService.selectAllByName(memberName);
		return mList;
	}
	
	/**
	 * 아이디로 계정 조회
	 * @param memberId
	 * @return Member
	 */
	public Member printOneById(String memberId) {
		Member member = mService.selectOneById(memberId);
		return member;
	}
	
	/**
	 * 가입
	 * @param member
	 * @return int
	 */
    public int registerMember(Member member) {
    	int result = mService.insertMember(member);
    	return result;
    			
    }
    
    /**
     * 아이디 받아서 한번에 수정
     * @param member
     * @return int
     */
    public int modifyMember(Member member) {
    	int result =mService.updateMember(member);;
    	return result;
    }

    /**
     * 아이디 받아서 삭제
     * @param memberId
     * @return int
     */
	public int deleteMember(String memberId) {
		int result = mService.dropMember(memberId);
		return result;
	}

    /**
     * 아이디비번받아 로그인
     * @param memberInfo
     * @return Member
     */
	public Member logIn(Member memberInfo) {
		Member member = mService.logInMember(memberInfo);
		return member;
	}


	
}
