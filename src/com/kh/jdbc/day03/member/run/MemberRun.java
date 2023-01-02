package com.kh.jdbc.day03.member.run;

import java.util.List;

import com.kh.jdbc.day03.member.controller.MemberController;
import com.kh.jdbc.day03.member.model.vo.Member;
import com.kh.jdbc.day03.member.view.MemberView;

public class MemberRun {
    public static void main (String [] args) {
    	Member member = null;
    	MemberView mView = new MemberView();
    	MemberController mCon = new MemberController();
    	List<Member> mList = null;
    	String memberId = "";
    	exit: 
    	while(true) {
    		int choice = mView.mainMenu();
    		switch(choice) {
    		case 0 : break exit;
    		case 1 : 
    			mList = mCon.printAll();
    			if(mList.size()>0) {
    				mView.showAll(mList);
    			}else {
    				mView.displayError("회원정보없음");
    			}
    			break;
    		case 2 : //아이디로 검색
    			break;
    		case 3 : break;
    		case 4 : 
    			int result;
    			
    			member = mView.inputMember();
    			result = mCon.registerMember(member);
    			if(result > 0) {
    				mView.displaySuccess("가입성공");
    			}else {
    				mView.displayError("가입오류!");
    			}
    			break;
    		case 5 : 
    			memberId = mView.searchMember("수정할 계정의 아이디를 ");
    			member = mCon.printOneById(memberId);
    			if(member != null) {
    				member = mView.modifyMember(memberId);
    				result = mCon.modifyMember(member);
    				if(result > 0) {
    					mView.displaySuccess("수정 성공");
    				}else {
    					mView.displayError("수정 실패...");
    				}
    			}else {
    				mView.displayError("존재하지 않는 회원..");
    			}
    			break;
    		case 6 : break;
    		case 7 : break;
    		}
    		
    		
    	}
    	
    	
    	
    }
}
