package com.kh.jdbc.day01.student.run;

import java.util.List;

import com.kh.jdbc.day01.student.controller.StudentController;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day01.student.view.StudentView;

public class StudentRun {
    public static void main(String [] args) {
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
    	done :
    	while(true) {
    		int choice = sView.mainMenu();
    		switch(choice) {
    		case 1 : //전체조회
    			sList = sCon.printAll();
    			sView.showAll(sList);
    			break;
    		case 2 : break;
    		case 3 : break;
    		case 4 : //회원가입
    			student = sView.inputStudent();
    			int result = sCon.registerStudent(student);
    			if(result > 0) {
    				//성공메세지
    				sView.displaySuccess("가입 완료!");
    			} else {
    				//실패메시지
    				sView.displayError("가입 실패!");
    			}
    			break;
    		case 5 : break;
    		case 6 : break;
    		case 0 : break done;
    		default :
    			sView.printMessage("잘못입력하셨습니다. 1~6 사이의 숫자를 입력해주세요");
    			break;
    		}
    	}
        
    }
}
