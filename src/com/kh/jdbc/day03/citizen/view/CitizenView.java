package com.kh.jdbc.day03.citizen.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day03.citizen.model.vo.Citizen;

public class CitizenView {

	public int printMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------전체메뉴출력-----------");
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

	public void printAll(List<Citizen> cList) {
		System.out.println("~~~~~~회원전체조회~~~~~~");
		for (Citizen cOne : cList) {
			System.out.println("아이디 : " + cOne.getCitizenId());
			System.out.println("비밀번호 : " + cOne.getCitizenPwd());
			System.out.println("이름 : " + cOne.getCitizenName());
			System.out.println("성별 : " + cOne.getCitizenGender());
			System.out.println("나이 : " + cOne.getCitizenAge());
			System.out.println("전화번호 : " + cOne.getCitizenPhone());
			System.out.println("주소 : " + cOne.getCitizenAddress());
			System.out.println("가입일시 : " + cOne.getCitizenDate());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

	public void successMsg(String msg) {
		System.out.println("[성공!] " + msg);
	}

	public void failMsg(String msg) {
		System.out.println("[실패!] " + msg);
	}
}
