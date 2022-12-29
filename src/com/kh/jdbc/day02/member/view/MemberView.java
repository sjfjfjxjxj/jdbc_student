package com.kh.jdbc.day02.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberView {
	
	
	/**
	 * 메뉴출력
	 * @return
	 */
    public int mainMenu() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("=============회원관리프로그램=============");
    	System.out.println("1. 회원 전체 조회");
    	System.out.println("2. 회원 아이디로 조회");
    	System.out.println("3. 회원 이름으로 조회");
    	System.out.println("4. 회원 가입");
    	System.out.println("5. 회원 정보 수정");
    	System.out.println("6. 회원 탈퇴");
    	System.out.println("0. 프로그램 종료");
    	System.out.print("메뉴 선택 : ");
    	int choice = sc.nextInt();
    	return choice;
    }
    /**
     * 전체멤버정보조회
     * @param members
     */
    public void showAll(List<Member> members) {
    	System.out.println("---------------전체멤버정보조회--------------");
    	for(Member mOne : members) {
    		System.out.println("아이디:"+ mOne.getMemberId());
    		System.out.println("비밀번호:"+ mOne.getMemberPwd());
    		System.out.println("이름:"+ mOne.getMemberName());
    		System.out.println("성별:"+ mOne.getMemberGender());
    		System.out.println("나이:"+ mOne.getMemberAge());
    		System.out.println("이메일:"+ mOne.getMemberEmail());
    		System.out.println("전화번호:"+ mOne.getMemberPhone());
    		System.out.println("주소:"+ mOne.getMemberAddress());
    		System.out.println("취미:"+ mOne.getMemberHobby());
    		System.out.println("가입일:"+ mOne.getMemberDate());
    	}
    }
    
    public Member inputMember() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("아이디 : ");
    	String memberId = sc.next();
    	System.out.print("비밀번호 : ");
    	String memberPwd = sc.next();
    	System.out.print("이름 : ");
    	String memberName = sc.next();
    	System.out.print("성별 : ");
    	String memberGender = sc.next();
    	System.out.print("나이 : ");
    	String memberAge = sc.next();
    	System.out.print("이메일 : ");
    	String memberEmail = sc.next();
    	System.out.print("전화 : ");
    	String memberPhone = sc.next();
    	System.out.print("주소 : ");
    	sc.nextLine();
    	String memberAddress = sc.nextLine();
    	System.out.print("취미 : ");
    	String memberHobby = sc.next();
    	Member member = new Member(memberId, memberPwd, memberName, memberGender, memberAge, memberEmail, memberPhone, memberAddress, memberHobby, null);
    	return member;
    }
    
    public String searchMember(String message) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(message + " 입력해 주세요.");
    	String searchedStudent = sc.next();
    	return searchedStudent;
    }
    
    
    public void showOne(Member member) {
    	System.out.println("아이디 : " + member.getMemberId());
    	System.out.println("비밀번호 : " + member.getMemberPwd());
    	System.out.println("이름 : " + member.getMemberName());
    	System.out.println("성별 : " + member.getMemberGender());
    	System.out.println("나이 : " + member.getMemberAge());
    	System.out.println("이메일 : " + member.getMemberEmail());
    	System.out.println("전화 : " + member.getMemberPhone());
    	System.out.println("주소 : " + member.getMemberAddress());
    	System.out.println("취미 : " + member.getMemberHobby());
    }
    
    
    public Member modifyMember(Member member) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("수정할 비밀번호 입력: ");
		String memberPwd = sc.next();
		System.out.println("수정할 이메일 입력: ");
		String memberEmail = sc.next();
		System.out.println("수정할 전화번호 입력: ");
		String memberPhone = sc.next();
		System.out.println("수정할 주소 입력: ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.println("수정할 취미 입력: ");
		String memberHobby = sc.next();
		member.setMemberPwd(memberPwd);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);
		return member;
    }
    
    
    
    
    
    
    
    
    
    public void printMessage(String msg) {
    	System.out.println(msg);
    }
    
    
    public void displaySuccess(String msg) {
    	System.out.println("성공이요"+ msg);
    }
    
    
    public void displayError(String msg) {
    	System.out.println("실패요"+ msg);
    }
    
}
