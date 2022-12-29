package com.kh.jdbc.day01.student.run;

import java.util.List;

import com.kh.jdbc.day01.student.controller.StudentController;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day01.student.view.StudentView;

public class StudentRun {
	public static void main(String[] args) {
//    	StudentController sCon = new StudentController();
//    	StudentView sView = new StudentView();
////		List<Student> sList = sCon.printAll();
////	     sView.showAll(sList);
//    	
//    	//데이터 준비
//    		Student student = sView.inputStudent();	
//    		
//        
//        int result = sCon.registerMember(student);
//        if(result > 0) {
//        	System.out.println("F.I.N.A.L.L.Y. SUCCESS");
//        }else {
//        	System.out.println("FAILED AGAIN^^");
//        }
		StudentView sView = new StudentView();
		StudentController sCon = new StudentController();
		Student student = null;
		List<Student> sList = null;
		String studentId = "";
		String studentName = "";
		int result = 0;
		done: while (true) {
			int choice = sView.mainMenu();
			switch (choice) {
			case 1: // 전체조회
				sList = sCon.printAll();
				if (!sList.isEmpty()) {
					sView.showAll(sList);
				} else {
					sView.displayError("데이터가 존재하지 않습니다");
				}
				break;
			case 2: // 아이디로 회원정보조회
				studentId = sView.inputStudentId("검색");
				student = sCon.printOneById(studentId);
				if (student != null) { // DAO에 있는 값이 null
					sView.showOne(student);
				} else {
					sView.displayError("학셍 데이터가 없습니다");
				}
				break;
			case 3: // 이름으로 회웡정보조회-동명이인 가능->리스트로 가져와야
				studentName = sView.inputStudentName("검색");
				sList = sCon.printAllByName(studentName);
				// sList는 항상 Null아님. StudentDAO line76
				if (!sList.isEmpty()) { // :리스트가 비어있지 않다면
					sView.showAll(sList);
				} else {
					sView.displayError("일치하는 데이터가 없습니다");
				}

				break;
			case 4: // 회원가입
				student = sView.inputStudent();
				result = sCon.registerStudent(student);
				if (result > 0) {
					// 성공메세지
					sView.displaySuccess("가입 완료!");
				} else {
					// 실패메시지
					sView.displayError("가입 실패!");
				}
				break;
			case 5: //회원정보 수정
				studentId = sView.inputStudentId("수정");
				student = sCon.printOneById(studentId);
				if(student != null) {
					student = sView.modifyStudent(student);
					//student.setStudentId(studentId);
					sCon.modifyStudent(student);
				} else {
					sView.displayError("일치하는 학생이 없습니다");;
				}
				break;
			case 6: // 삭제: 탈퇴
			    studentId = sView.inputStudentId("삭제");
			    result = sCon.removeStudent(studentId);
			    if(result > 0) {
			    	sView.displaySuccess("탈퇴 완료");
			    }else {
			    	sView.displayError("탈퇴 실패");
			    }
				break;
			case 0:
				break done;
			default:
				sView.printMessage("잘못입력하셨습니다. 1~6 사이의 숫자를 입력해주세요");
				break;
			}
		}

	}
}
