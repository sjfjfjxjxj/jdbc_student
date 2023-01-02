package schedulerforme.run;

import java.util.List;

import javax.swing.text.View;

import schedulerforme.controller.ScheController;
import schedulerforme.model.Schedule;
import schedulerforme.view.ScheView;

public class ScheRun {
    public static void main(String [] args) {
    	List<Schedule> scheList = null;
    	ScheController scheCon = new ScheController();
    	ScheView scheView = new ScheView();
    	Schedule schedule = null;
    	int insertDate = 0;
    	exit :
    	while(true) {
    		int choice = scheView.printMenu();
    		switch(choice) {
    		case 1 : //전체 스케줄 보기
    			scheList = scheCon.accessAll();
    			if(!scheList.isEmpty()) {
    			scheView.printSuccess("총 "+ scheList.size() +"건의 일정이 있어요.");
    			scheView.showAll(scheList);
    			}else {
    				scheView.printFail("아직 등록된 일정이 없어요.");
    			}
    			break;
    		case 2 : //날짜별 스케줄 보기 
    			insertDate = scheView.searchSche("일정이 궁금한 날짜 입력해주세요(yyyymmdd) :"); //날짜를 입력받아서
    			scheList = scheCon.checkDate(insertDate);
    			if(!scheList.isEmpty()) {
    				scheView.printSuccess("총 "+ scheList.size() +"건의 일정이 있어요.");
    				scheView.showAll(scheList);
    			}else {
    				scheView.printFail(insertDate + "에는 아무 일정도 없어요.");
    			}
    			break;
    		case 3 : break;
    		case 4 : break;
    		case 5 : break;
    		case 6 : //새 일정 등록하기
    			schedule = scheView.insertSche();
    			int result = scheCon.saveSche(schedule);
    			if(result > 0) {
    				scheView.printSuccess("새 일정이 추가됐어요!");
    			} else {
    				scheView.printFail("다시 차근히 해보세요ㅠ");
    			}
    			break;
    		case 7 : break;
    		case 8 : break;
    		case 9 : break exit;
    		default : 
    			scheView.printFail("1 ~ 9 사이 숫자를 입력해주세요");
    			break;
    		}
    	}
    		
//    	System.out.println("---------심플스케줄러---------");
//		System.out.println("1. 나의 전체 스케줄 보기");
//		System.out.println("2. 날짜별 스케줄 보기");
//		System.out.println("3. 『개인』스케줄만 보기");
//		System.out.println("4. 『공식』스케줄만 보기");
//		System.out.println("5. 시간 순서로 스케줄 보기");
//		System.out.println("6. 새 일정 추가하기");
//		System.out.println("7. 스케줄 수정하기");
//		System.out.println("8. 스케줄 삭제하기");
//		System.out.println("9. 스케줄러 종료");
//		System.out.print("[메뉴선택] : ");
    	
    	
    	
    	
    	
    }
}
