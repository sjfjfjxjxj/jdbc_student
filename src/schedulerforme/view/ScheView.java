package schedulerforme.view;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import schedulerforme.controller.ScheController;
import schedulerforme.model.Schedule;

public class ScheView {
//	 SCHE_TITLE VARCHAR2(30) PRIMARY KEY,
//    SCHE_DEADLINE NUMBER,
//    SCHE_OFFICIALCHECK VARCHAR2(10) CHECK(SCHE_OFFICIALCHECK IN('공식','개인')),
//    SCHE_TODO VARCHAR2(30) NOT NULL,
//    SCHE_WITHWHOM VARCHAR2(30),
//    SCHE_TOWHERE VARCHAR2(30),
//    SCHE_SYSDATE TIMESTAMP DEFAULT SYSDATE  
//
	
	public int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------심플스케줄러-------------");
		System.out.println("1. 나의 전체 일정 보기");
		System.out.println("2. 날짜별 일정 보기");
		System.out.println("3. 『개인』일정만 보기");
		System.out.println("4. 『공식』일정만 보기");
		System.out.println("5. 시간 순서로 일정 보기");
		System.out.println("6. 새 일정 추가하기");
		System.out.println("7. 일정 수정하기");
		System.out.println("8. 일정 삭제하기");
		System.out.println("9. 프로그램 종료");
		System.out.print("[메뉴선택] : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showAll(List<Schedule> scheList) {
		System.out.println("------------나의 전체 일정 조회------------");
		for(Schedule singleSche : scheList) {
			System.out.println("일정 제목: " + singleSche.getScheTitle());
			System.out.print("☆ "+singleSche.getScheDeadline());
			System.out.println(singleSche.getScheOfficialCheck()+"일정 ☆");
			System.out.print("【"+singleSche.getScheTodo()+"】을/를 ");
			System.out.print("【"+singleSche.getScheWithWhom()+"】(이)랑 ");
			System.out.println("【"+singleSche.getScheToWhere()+"】에서 할 예정이에요.");
			System.out.println("기록:" +singleSche.getScheSysdate());
		}
	}
	
	
	public int searchSche(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		int deadline = sc.nextInt();
		return deadline;
	}
	
	
	
	public Schedule insertSche() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------나의 일정 입력하기------------");
		System.out.println("일정 제목이 뭔가요? : ");
		String scheTitle = sc.next();
		System.out.println("그게 언제죠?(yyyymmdd 입력) : ");
		int scheDeadline = sc.nextInt();
		System.out.println("공식/개인 여부를 알려주세요 : ");
		String scheOfficialCheck = sc.next();
		System.out.println("무엇을 하나요? : ");
		String scheTodo = sc.next();
		System.out.println("누구랑 할 건가요?(혼자라면 '나'라고 입력해주세요) : ");
		String scheWithWhom = sc.next();
		System.out.println("어디서 할 건가요? : ");
		String scheToWhere = sc.next();
		Schedule schedule = new Schedule(scheTitle, scheDeadline, scheOfficialCheck, scheTodo, scheWithWhom, scheToWhere, null);
		return schedule;
	}
	
	
	
//private String scheTitle;
//private int deadline;
//private String scheOfficialCheck;
//private String scheTodo;
//private String withWhom;
//private String toWhere;
//private Timestamp schSysdate;
	
	
	
	
	
	public String printSuccess(String msg) {
		System.out.println("[성공] : " + msg);
		return msg;
	}
	
	public String printFail(String msg) {
		System.out.println("[오류] : " + msg);
		return msg;
	}
	
	
}
