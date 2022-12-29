package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {
    public static void main(String [] args) {
    	List<Member> mList = null;
    	MemberController mCon = new MemberController();
    	MemberView mView = new MemberView();
    	int result = 0;
    	String memberId = "";
    	String memberName ="";
    	Member member = null; //초기화!
    	//Member member = new Member(); ->이러면 쓸데없이 메모리할당(주소 생김)이 되니깐!
    	goodbye :
    	while(true) {
    		int choice = mView.mainMenu();
    		switch(choice) {
    		case 0 : break goodbye;
    		case 1 :  //전체 출력해보자(컨트롤러->다오->뷰)
    			mList = mCon.printAll();
    			if(!mList.isEmpty()) {
    				mView.showAll(mList);
    			}else {
    				mView.displayError("아무 것도 없소");
    			}
    			break;
    		case 2 : //아이디 받아서 검색하기
    			memberId = mView.searchMember("검색할 아이디를");//아이디 입력해서 뷰에 넘기기
    			member = mCon.printOneById(memberId);
    			//뷰가 컨트롤러로 넘긴거 다오에서 꺼내갖고 받기
    			break;
    		case 3 : // 이름 받아서 검색하기
    			memberName = mView.searchMember("검색할 이름을");
    			mList = mCon.printAllByName(memberName);
    			break;
    		case 4 : //회원가입
    			member = mView.inputMember(); //아이디를 입력해서 member 변수에 담고
    			result = mCon.registerMember(member);//register등록을 해야혀 <-dao에서 인서트
    			if(result > 0) {
    				mView.displaySuccess("가입추카추");
    			}else {
    				mView.displayError("너는가입할수없다");
    			}
    			break;
    		case 5 : break;
    		case 6 : break;
    		default :
    			mView.printMessage("1~6 사이 숫자를 입력하시오");
    			break;
    		}
    	}
    }
}
