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
    	String memberName = "";
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
    			memberId = mView.searchMember("검색할 계정의 아이디를 ");
    			member = mCon.printOneById(memberId);
    			if(member != null) {
    				mView.showOne(member);
    			}else {
    				mView.displayError("존재하지 않는 아이디...");;
    			}
    			break;
    		case 3 : //이름으로 검색
    			memberName = mView.searchMember("검색할 계정의 이름을 ");
    			mList = mCon.printAllByName(memberName);
    			if(!mList.isEmpty()) {
    				mView.showAll(mList);
    			}else {
    				mView.displayError("그런 이름은 없어요");
    			}
    			break;
    		case 4 : //가입
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
    		case 6 : //삭제 성공메세지 나오는데 삭제가 안됨ㅋㅋㅋ
    			memberId = mView.searchMember("삭제할 계정의 아이디를 ");
    			member = mCon.printOneById(memberId);
    			if(member != null) {
    				member = mView.deleteMember(memberId);
    				result = mCon.deleteMember(memberId);
    				if(result > 0) {
    					mView.displaySuccess("삭제성공!");
    				}else {
    					mView.displayError("삭제 실패!!");
    				}
    			}else {
    				mView.displayError("존재하지 않는 회원. . . ");
    			}
    			break;
    		case 7 : //로그인
    			
    			break;
    		}
    		
    		
    	}
    	
    	
    	
    }
}
