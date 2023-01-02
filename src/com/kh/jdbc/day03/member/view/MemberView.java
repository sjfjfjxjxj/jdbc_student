package com.kh.jdbc.day03.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day03.member.model.vo.Member;

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
    	System.out.println("7. 회원 로그인");
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
    	System.out.println("---------------멤버정보조회--------------");
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
    		System.out.println("----------------------------------------------");
    	}
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
		System.out.println("가입날짜 : " + member.getMemberDate());
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
    	int memberAge = sc.nextInt();
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
    
//    public Member inputLoginInfo(String memberId, String memberPwd) {
//    	Scanner sc = new Scanner(System.in);
//    	System.out.print("아이디 :");
//    	String MemberId = sc.next();
//    	System.out.print("비밀번호 :");
//    	String MemberPwd = sc.next();
//    	Member memberIdPwd = new Member(memberId, memberPwd);
//    	return memberIdPwd; //컨트롤러로 가
//    }
    
    //선생님 로그인
    public Member inputLoginInfo() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("-----로그인정보입력-------");
    	System.out.print("아이디 :");
    	String memberId = sc.next();
    	System.out.print("비밀번호 :");
    	String memberPwd = sc.next();
        Member member= new Member();
        member.setMemberId(memberId);
        member.setMemberPwd(memberPwd);
        return member;
    }
    
    
    public Member modifyMember(String memberId) {
    	Scanner sc = new Scanner(System.in);
    	Member member = new Member();
    	member.setMemberId(memberId); //중요!!!!
    	System.out.print("수정할 비밀번호 입력: ");
		member.setMemberPwd(sc.next());
		System.out.print("수정할 이메일 입력: ");
		member.setMemberEmail(sc.next());
		System.out.print("수정할 전화번호 입력: ");
		member.setMemberPhone(sc.next());
		System.out.print("수정할 주소 입력: ");
		sc.nextLine();
		member.setMemberAddress(sc.nextLine());
		System.out.print("수정할 취미 입력: ");
		member.setMemberHobby(sc.next());
		//코드 줄이기! 객체 생성 안하고 바로 입력받은거 세터로 저장
		return member;
    }
    
    public Member deleteMember(String memberId) {
    	Member member = new Member();
    	member.setMemberId(memberId);
    	return member;
    }
    
    
    
    
    
    
    
    
    public void printMessage(String msg) {
    	System.out.println(msg);
    }
    
    
    public void displaySuccess(String msg) {
    	System.out.println("성공이요 : "+ msg);
    }
    
    
    public void displayError(String msg) {
    	System.out.println("실패요 : "+ msg);
    }
    
}
